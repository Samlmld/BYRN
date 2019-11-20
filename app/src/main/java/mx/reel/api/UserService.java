package mx.reel.api;

import java.util.List;

import mx.reel.pojos.LoginRequest;
import mx.reel.pojos.LoginResponse;
import mx.reel.pojos.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("api/login")
    Call<LoginResponse> login(@Body LoginRequest loginReq);

    @GET("api/users/{userId}")
    Call<User> getUserById(
            @Path("userId") String userId,
            @Header("Authorization") String authorization
    );

    @GET("/api/users")
    Call<List<User>> getAllUsers(@Header("Authorization") String authorization);
}
