package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditarPropiedad extends AppCompatActivity {
    Button btnGuardarCambios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_propiedad);

        btnGuardarCambios = (Button) findViewById(R.id.btnGuardarCambios);

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(EditarPropiedad.this, DetallesDePropiedades.class);
                startActivity(v);
                Toast.makeText(getApplicationContext(),"Cambios Realizados",Toast.LENGTH_SHORT).show();



            }
        });

    }
}
