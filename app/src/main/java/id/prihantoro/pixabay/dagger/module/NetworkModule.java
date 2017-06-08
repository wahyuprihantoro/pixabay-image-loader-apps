package id.prihantoro.pixabay.dagger.module;

import dagger.Module;
import dagger.Provides;
import id.prihantoro.pixabay.retrofitservice.PixabayService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static id.prihantoro.pixabay.utils.Constants.BASE_URL;

/**
 * Created by wahyu on 08 June 2017.
 */
@Module
public class NetworkModule {

    @Provides
    public OkHttpClient okHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient client = httpClient.build();
        return client;
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient) {

        return new retrofit2.Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    public PixabayService getService(Retrofit retrofit) {
        return retrofit.create(PixabayService.class);
    }
}
