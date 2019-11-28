package mx.reel.api;

import java.util.List;

import mx.reel.pojos.Appointment;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AppointmentService {
    @GET("api/appoiments")
    Call<List<Appointment>> getAllAppointments(@Header("Authorization") String authorization);

    @PUT("api/appoiments/{appointmentId}")
    Call<Appointment> updateAppointment(
            @Header("Authorization") String authorization,
            @Path("appointmentId") String appointmentId,
            @Body Appointment appointment
    );
}
