package com.example.byrn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarPropiedad extends AppCompatActivity {
    Button btnGuardarNuevaPropiedad, btnAbrirMapa,btnCalcular,btnAgregarImagen;
    public EditText etLatitud, etLongitud;
    Spinner spTipoDePropiedad;
    Spinner spTipoPublicacion;
    Spinner spDueño;
    Spinner spCiudad;
    final String [] TiposDePropiedades = {"Terreno rústico", "Terreno urbano","Casa Habitación", "Local Comercial","Bodega", "Departamento","Casa campestre", "Acción de sociedad"};
    final String [] TipoPublicacion = {"Venta","Renta"};
    final String [] TipoDueño={"1","2","3"};
    final String [] municipios={"Guadalajara","Zapotlanejo","Tlajomulco","Zapopan","Tlaquepaque","Tequila","La Barca","Chapala"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_propiedad);
        btnGuardarNuevaPropiedad = (Button) findViewById(R.id.btnGuardarNuevaPropiedad);
        btnAbrirMapa = (Button) findViewById(R.id.btnAbrirMapa);
        etLatitud = (EditText) findViewById(R.id.etLatitud);
        etLongitud = (EditText) findViewById(R.id.etLongitud);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnAgregarImagen = (Button) findViewById(R.id.btnAgregarImagen);
        spTipoDePropiedad = (Spinner) findViewById(R.id.spTipoDePropiedad);
        spTipoPublicacion = (Spinner) findViewById(R.id.spTipoPublicacion);
        spDueño = (Spinner) findViewById(R.id.spDueño);
        spCiudad = (Spinner) findViewById(R.id.spCiudad);


        spTipoDePropiedad.setAdapter(new ArrayAdapter<String>(AgregarPropiedad.this,android.R.layout.simple_spinner_item,TiposDePropiedades));
        spTipoPublicacion.setAdapter(new ArrayAdapter<String>(AgregarPropiedad.this,android.R.layout.simple_spinner_item,TipoPublicacion));
        spDueño.setAdapter(new ArrayAdapter<String>(AgregarPropiedad.this,android.R.layout.simple_spinner_item,TipoDueño));
        spCiudad.setAdapter(new ArrayAdapter<String>(AgregarPropiedad.this,android.R.layout.simple_spinner_item,municipios));


        btnGuardarNuevaPropiedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(AgregarPropiedad.this);
                alerta.setMessage("¡Propiedad Guardada con éxito!")
                        .setCancelable(false)
                        .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                finish();


                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Propiedad");
                titulo.show();
            }
        });

        btnAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent v = new Intent(AgregarPropiedad.this, MapsActivity.class);
                startActivity(v);

            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Bundle extras =getIntent().getExtras();

                    etLatitud.setText(extras.getString("latitud"));
                    etLongitud.setText(extras.getString("longitud"));
            }
        });

        btnAgregarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(intent.createChooser(intent,"Seleccione apliacion"),10);


            }
        });




    }
}
