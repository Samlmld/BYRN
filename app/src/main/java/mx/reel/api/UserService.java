package mx.reel.api;

import mx.reel.pojos.LoginRequest;
import mx.reel.pojos.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("api/login")
    Call<LoginResponse> login(@Body LoginRequest loginReq);
}
