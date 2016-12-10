package id.prihantoro.pixabay.api;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wahyu on 10 Desember 2016.
 */

@EBean
public class Retrofit {
    String baseUrl = "https://pixabay.com/";

    @RootContext
    Context context;

    public <T> T getService(Class<T> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

    public synchronized retrofit2.Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        OkHttpClient client = httpClient.build();
        return new retrofit2.Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
