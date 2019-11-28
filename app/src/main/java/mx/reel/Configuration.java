package mx.reel;

import mx.reel.api.AppointmentService;
import mx.reel.api.EstateService;
import mx.reel.api.UserService;
import mx.reel.pojos.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configuration {
    private static User currentUser = null;
    private static String AUTH_TOKEN = "";
    public static final String API_URL = "https://byrn-dev.herokuapp.com";
    public static final Retrofit RETROFIT = new Retrofit
            .Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final EstateService STATE_SERVICE = RETROFIT.create(EstateService.class);
    public static final UserService USER_SERVICE = RETROFIT.create(UserService.class);
    public static final AppointmentService APPOINTMENT_SERVICE = RETROFIT.create(AppointmentService.class);

    public static void setAuthtoken(String token) {
        AUTH_TOKEN = token;
    }

    public static String getAuthToken() {
        return "Bearer " + AUTH_TOKEN;
    }

    public static void setLoggedInUser(User user) {
        currentUser = user;
    }

    public static User getLoggedInUser() {
        return currentUser;
    }
}
