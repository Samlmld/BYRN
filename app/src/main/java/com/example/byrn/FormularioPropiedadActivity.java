package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import mx.reel.utils.DialogManager;

public class FormularioPropiedadActivity extends AppCompatActivity {
    private Button createButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_propiedad);

        DialogManager.init(this);
        createButton = findViewById(R.id.estateFormCreateButton);
    }

    public void onCreateButton(View v) {
        System.out.println("CREATING ESTATE...");
    }
}
