package id.prihantoro.pixabay;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.List;

import id.prihantoro.pixabay.adapter.PixabayAdapter;
import id.prihantoro.pixabay.api.Retrofit;
import id.prihantoro.pixabay.api.service.PixabayServie;
import id.prihantoro.pixabay.model.Hit;
import id.prihantoro.pixabay.model.PixabayResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wahyu on 10 Desember 2016.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById
    RecyclerView rv;

    @Bean
    Retrofit retrofit;
    PixabayAdapter adapter;
    int currentPage=0;
    HashMap<String,String> map = new HashMap<>();

    @AfterViews
    void init(){
        map.put("key", "3968517-94dbe52e08b9ec52249a64fdc");
        map.put("q", "animal");
        map.put("image_type","all");
        map.put("page","1");
        Call<PixabayResponse> call = retrofit.getService(PixabayServie.class).getImages(map);
        call.enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                PixabayResponse pixabayResponse = response.body();
                List<Hit> hits = pixabayResponse.getHits();
                adapter = new PixabayAdapter(getApplicationContext(),hits);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                currentPage = 1;
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadNextPage(){
        map.put("page",(currentPage+1)+"");
        Call<PixabayResponse> call = retrofit.getService(PixabayServie.class).getImages(map);
        call.enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                PixabayResponse pixabayResponse = response.body();
                List<Hit> hits = pixabayResponse.getHits();
                adapter.addItems(hits);
                currentPage++;
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
