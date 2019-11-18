package mx.reel;

import mx.reel.api.StateService;
import mx.reel.api.UserService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configuration {
    public static final String API_URL = "https://byrn-dev.herokuapp.com";
    public static final Retrofit RETROFIT = new Retrofit
            .Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final StateService STATE_SERVICE = RETROFIT.create(StateService.class);
    public static final UserService USER_SERVICE = RETROFIT.create(UserService.class);
}
