package mx.reel;

import mx.reel.api.TestService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestConfiguration {
    public static final String API_URL = "http://192.168.43.32:8080";
    public static final Retrofit RETROFIT = new Retrofit
            .Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final TestService TEST_SERVICE = RETROFIT.create(TestService.class);
}
