package id.prihantoro.pixabay.retrofitservice;

import java.util.Map;

import id.prihantoro.pixabay.model.PixabayResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by wahyu on 10 Desember 2016.
 */

public interface PixabayService {
    @GET("api")
    Call<PixabayResponse> getImages(@QueryMap Map<String, String> parameter);
}
