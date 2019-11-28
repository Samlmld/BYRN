package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

import mx.reel.Configuration;
import mx.reel.pojos.Estate;
import mx.reel.utils.DialogManager;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class FormularioPropiedadActivity extends AppCompatActivity implements Callback<Estate> {
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
        createEstateRequest();
    }

    private RequestBody buildEstateRequestBody() {
        // return MultipartBody.create("image/*", ASD);
        // return RequestBody.create();
        return null;
    }

    private void createEstateRequest() {
        Configuration
                .STATE_SERVICE
                .createEstate(
                        Configuration.getAuthToken(),
                        buildEstateRequestBody()
                )
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<Estate> call, Response<Estate> response) {
        if (!response.isSuccessful()) {
            DialogManager.showMessageDialog("Ocurrió un problema inesperado.");

            try {
                System.out.println(response.raw().body().string());
            } catch (IOException e) {
                System.err.println("ERROR WHILE TRYING TO CONVERT RESPONSE TO STRING");
                System.out.println(e.getLocalizedMessage());
            }

            return;
        }
        DialogManager.showMessageDialog("Se guardó la propiedad exitosamente.");
    }

    @Override
    public void onFailure(Call<Estate> call, Throwable t) {
        DialogManager.showMessageDialog("No se pudo crear la propiedad.");
    }
}
