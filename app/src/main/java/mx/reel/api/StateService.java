package mx.reel.api;

import java.util.List;

import mx.reel.pojos.State;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StateService {
    @GET("api/estates")
    Call<List<State>> getAllStates();
}
