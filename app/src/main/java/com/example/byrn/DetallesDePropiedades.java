package com.example.byrn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;
import mx.reel.pojos.Estate;
import mx.reel.pojos.EstateImage;

public class DetallesDePropiedades extends AppCompatActivity {
    private Estate passedEstate = null;
    private TextView estateTitle = null;
    private EditText estateContent = null;
    private Slider imageSlider = null;

    Button btnEliminar, btnEditarPropiedad, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_de_propiedades);

        estateTitle = findViewById(R.id.estateDetailTitle);
        estateContent = findViewById(R.id.estateDetailContent);
        imageSlider = findViewById(R.id.estateDetailSlider);

        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEditarPropiedad = (Button) findViewById(R.id.btnEditarPropiedad);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
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
                                Toast.makeText(getApplicationContext(), "Borrado Exitoso", Toast.LENGTH_SHORT).show();
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
                finish();
            }
        });

        passedEstate = (Estate) getIntent().getSerializableExtra("estate");
        initSlider();
        showData();
    }

    private void showData() {
        estateTitle.setText(passedEstate.getName());
        String content = passedEstate.getDescription();
        content += ", " + passedEstate.getAddress();
        content += ", " + passedEstate.getSurfaceArea() + " mt2";
        content += ", $ " + passedEstate.getSellerPrice() + " MXN";
        content += ", agregada el: " + passedEstate.getCreatedAt() + ".";
        estateContent.setText(content);
    }

    private void initSlider() {
        List<Slide> slideList = new ArrayList<>();
        if (passedEstate.getImages().size() > 0) {
            for (int idx = 0; idx < passedEstate.getImages().size(); idx++) {
                EstateImage img = passedEstate.getImages().get(idx);
                slideList.add(new Slide(
                        idx,
                        img.getUrl(),
                        getResources().getDimensionPixelSize(R.dimen.slider_image_corner)
                ));
            }
            imageSlider.addSlides(slideList);
            return;
        }
        // Create list of slides
        slideList.add(new Slide(0,"https://techcrunch.com/wp-content/uploads/2018/01/gettyimages-200066800-001-1.jpg?w=730&crop=1" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(1,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Townhouses_in_Victoria_Australia.jpg/220px-Townhouses_in_Victoria_Australia.jpg" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));

        // Add slides to slider
        imageSlider.addSlides(slideList);
    }
}
