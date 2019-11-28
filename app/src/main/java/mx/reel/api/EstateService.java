package mx.reel.api;

import mx.reel.pojos.AllEstatesResponse;
import mx.reel.pojos.Estate;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface EstateService {
    @GET("api/estates")
    Call<AllEstatesResponse> getAllEstates();

    @Multipart
    @POST("/api/estates")
    Call<Estate> createEstate(
            @Header("Authorization") String authorization,
            @Body RequestBody estate
        );
}
