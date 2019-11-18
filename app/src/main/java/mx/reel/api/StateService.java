package mx.reel.api;

import mx.reel.pojos.AllEstatesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StateService {
    @GET("api/estates")
    Call<AllEstatesResponse> getAllStates();
}
