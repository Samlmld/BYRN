package com.example.byrn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetallesDePropiedades extends AppCompatActivity {
    Button btnEliminar, btnEditarPropiedad,btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_de_propiedades);

        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEditarPropiedad = (Button) findViewById(R.id.btnEditarPropiedad);
        btnRegresar =(Button) findViewById(R.id.btnRegresar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(DetallesDePropiedades.this);
                alerta.setMessage("¿Seguro que desea eliminar?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                finish();
                                Toast.makeText(getApplicationContext(),"Borrado Exitoso",Toast.LENGTH_SHORT).show();
                                Intent inte = new Intent(DetallesDePropiedades.this, Main2Activity.class);
                                startActivity(inte);

                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog titulo = alerta.create();
                titulo.setTitle("Propiedad");
                titulo.show();

            }
        });


        btnEditarPropiedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent v = new Intent(DetallesDePropiedades.this, EditarPropiedad.class);
                startActivity(v);

            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(DetallesDePropiedades.this, Main2Activity.class);
                startActivity(v);
            }
        });
    }
}
