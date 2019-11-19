package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import mx.reel.Configuration;
import mx.reel.pojos.LoginRequest;
import mx.reel.pojos.LoginResponse;
import mx.reel.utils.DialogManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText usernameText = null;
    private EditText passwordText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        usernameText = findViewById(R.id.etUsuario);
        passwordText = findViewById(R.id.etContrasenia);
    }

    public void onLoginButtonClick(View v) {
        System.out.println("Iniciando sesión...");
        String email = usernameText.getText().toString();
        String passsword = passwordText.getText().toString();

        DialogManager.init(this);
        DialogManager.showLoadingDialog("Iniciando sesión...");
        Call<LoginResponse> loginCall = Configuration
                .USER_SERVICE.login(new LoginRequest(email, passsword));
        loginCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                // TODO: Save user to local state
                if (response.isSuccessful()) {
                    Configuration.setAuthtoken(response.body().getToken());
                    DialogManager.hideLoadingDialog();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                } else {
                    DialogManager.showMessageDialog("No se pudo iniciar sesión, intente de nuevo.");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println("==== LOGIN FAILED ====");
                DialogManager.showMessageDialog("No se pudo iniciar sesión, intente de nuevo.");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DialogManager.clear();
    }

}
