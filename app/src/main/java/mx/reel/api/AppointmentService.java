package mx.reel.api;

import java.util.List;

import mx.reel.pojos.Appointment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AppointmentService {
    @GET("api/appoiments")
    Call<List<Appointment>> getAllAppointments(@Header("Authorization") String authorization);
}
