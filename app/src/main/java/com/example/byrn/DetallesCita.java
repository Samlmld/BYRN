package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.reel.pojos.Appointment;

public class DetallesCita extends AppCompatActivity {
    Button btnRegresar;
    private Appointment passedAppointment = null;
    // View fields
    private TextView appointmentIdLabel = null;
    private TextView appointmentDateTimeLabel = null;
    private TextView appointmentTypeLabel = null;
    private TextView appointmentLocationLabel = null;
    private TextView appointmentStatusLabel = null;
    private TextView appointmentClientLabel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);
        // Labels
        appointmentIdLabel = findViewById(R.id.appointmentId);
        appointmentDateTimeLabel = findViewById(R.id.appointmentDateTime);
        appointmentTypeLabel = findViewById(R.id.appointmentType);
        appointmentLocationLabel = findViewById(R.id.appointmentLocation);
        appointmentStatusLabel = findViewById(R.id.appointmentStatus);
        appointmentClientLabel = findViewById(R.id.appointmentClient);
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
        appointmentClientLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClientDetailAction();
            }
        });
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
        appointmentClientLabel.setText(passedAppointment.getCustomerId() + "");
    }

    public void onClientDetailAction() {
        // TODO: Add client detail layout & logic
        System.out.println("TODO: Add client detail layout & logic");
    }
}
