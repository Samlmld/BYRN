package mx.reel.api;

import mx.reel.pojos.TestObjectResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TestService {
    @GET("random-test")
    Call<TestObjectResponse> testRequest();
}
