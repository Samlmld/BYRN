package mx.reel;

import mx.reel.api.StateService;
import retrofit2.Retrofit;

public class Configuration {
    public static final String API_URL = "https://byrn-dev.herokuapp.com";
    public static final Retrofit RETROFIT = new Retrofit
            .Builder()
            .baseUrl(API_URL)
            .build();

    public static final StateService STATE_SERVICE = RETROFIT.create(StateService.class);
}
