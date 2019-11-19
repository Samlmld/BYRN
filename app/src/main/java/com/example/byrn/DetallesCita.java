package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.reel.pojos.Appointment;

public class DetallesCita extends AppCompatActivity {
    Button btnRegresar;
    private Appointment passedAppointment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);

        btnRegresar = (Button) findViewById(R.id.btnRegresarCita);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Aquí me quedé: Crear el layout para esta activity
        // TODO: Appointment detail layout
        passedAppointment = (Appointment) getIntent().getSerializableExtra("appointment");
        System.out.println(passedAppointment.getId());
    }
}
