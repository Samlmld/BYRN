package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLOutput;

import mx.reel.Configuration;
import mx.reel.pojos.Appointment;
import mx.reel.pojos.User;
import mx.reel.utils.DialogManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallesCita extends AppCompatActivity implements Callback<User> {
    Button btnRegresar;
    private Appointment passedAppointment = null;
    private User client = null;
    // View fields
    private TextView appointmentIdLabel = null;
    private TextView appointmentDateTimeLabel = null;
    private TextView appointmentTypeLabel = null;
    private TextView appointmentLocationLabel = null;
    private TextView appointmentStatusLabel = null;
    private TextView appointmentClientLabel = null;
    private Button clientDetailButton = null;
    private Callback<Appointment> appointmentCallback = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);
        DialogManager.init(this);
        // Labels
        appointmentIdLabel = findViewById(R.id.appointmentId);
        appointmentDateTimeLabel = findViewById(R.id.appointmentDateTime);
        appointmentTypeLabel = findViewById(R.id.appointmentType);
        appointmentLocationLabel = findViewById(R.id.appointmentLocation);
        appointmentStatusLabel = findViewById(R.id.appointmentStatus);
        appointmentClientLabel = findViewById(R.id.appointmentClient);
        clientDetailButton = findViewById(R.id.clientDetailButton);
        // Back button
        btnRegresar = findViewById(R.id.btnRegresarCita);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        passedAppointment = (Appointment) getIntent().getSerializableExtra("appointment");
        initViewData();

        // Client detail listener
        clientDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClientDetailAction();
            }
        });

        // User data
        String userId = passedAppointment.getCustomerId() + "";
        appointmentClientLabel.setText(userId);
        fetchUserData(userId);

        appointmentCallback = new Callback<Appointment>() {
            @Override
            public void onResponse(Call<Appointment> call, Response<Appointment> response) {
                DialogManager.hideLoadingDialog();
                if (!response.isSuccessful()) {
                    DialogManager.showMessageDialog("Ocurrió un error inesperado.");
                    return;
                }
                System.out.println("=== HTTP RESPONSE DATA ===");
                System.out.println(response.code());
                System.out.println(response.raw().toString());
                String currentStatus = passedAppointment.getStatus();
                initViewData();
                if (currentStatus.equals("0")) {
                    DialogManager.showMessageDialog("Cita rechazada exitosamente.");
                }

                if (currentStatus.equals("2")) {
                    DialogManager.showMessageDialog("Se aceptó la cita exitosamente.\nPor favor este al pendiente de su cliente.");
                }
            }

            @Override
            public void onFailure(Call<Appointment> call, Throwable t) {
                DialogManager.showMessageDialog("No se pudo actualizar la cita.");
                System.out.println(t.getLocalizedMessage());
            }
        };
    }

    private void initViewData() {
        appointmentIdLabel.setText(passedAppointment.getId() + "");
        appointmentDateTimeLabel.setText(
                passedAppointment.getDate() + " a las "
                + passedAppointment.getStartTime()
        );
        appointmentTypeLabel.setText(passedAppointment.getAppoimentType());
        appointmentLocationLabel.setText(passedAppointment.getLocation());
        String status;
        switch (passedAppointment.getStatus()) {
            case "2":
                status = "Aceptada";
            break;
            case "3":
                status = "Rechazada";
            break;
            default:
                status = "Pendiente";
        }
        appointmentStatusLabel.setText(status);
    }

    public void onClientDetailAction() {
        // TODO: Add client detail layout & logic
        System.out.println("TODO: Add client detail layout & logic");
        Intent intento = new Intent(this, DetallesUsuario.class);
        intento.putExtra("user", client);
        startActivity(intento);
    }

    private void fetchUserData(String userId) {
        DialogManager.showLoadingDialog("Obteniendo detalles del usuario...");
        Configuration
                .USER_SERVICE
                .getUserById(userId, Configuration.getAuthToken())
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        if (!response.isSuccessful()) {
            DialogManager.showMessageDialog("Ocurrió un error inesperado, intente más tarde.");
            clientDetailButton.setEnabled(false);
            return;
        }
        DialogManager.hideLoadingDialog();
        client = response.body();
        String clientName = client.getName() + " " + client.getLastName();
        appointmentClientLabel.setText(clientName);
        clientDetailButton.setEnabled(true);
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        DialogManager.showMessageDialog("No se pudieron obtener los datos del cliente.");
        clientDetailButton.setEnabled(false);
    }

    public void onAcceptAppointment(View v) {
        // Dos es "aceptado"
        passedAppointment.setStatus("2");
        System.out.println("ACEPTAR CITA");
        DialogManager.showLoadingDialog("Aprobando cita...");
        Configuration.APPOINTMENT_SERVICE.updateAppointment(
                Configuration.getAuthToken(),
                String.valueOf(passedAppointment.getId()),
                passedAppointment
        ).enqueue(appointmentCallback);
    }

    public void onRejectAppointment(View v) {
        // Cero es "rechazado"
        passedAppointment.setStatus("0");
        System.out.println("RECHAZAR CITA");
        DialogManager.showLoadingDialog("Rechazando cita...");
        Configuration.APPOINTMENT_SERVICE.updateAppointment(
                Configuration.getAuthToken(),
                String.valueOf(passedAppointment.getId()),
                passedAppointment
        ).enqueue(appointmentCallback);
    }
}
