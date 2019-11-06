package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import mx.reel.TestConfiguration;
import mx.reel.pojos.TestObjectResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // private Button iniciarButton = null;
    private EditText usernameText = null;
    private EditText passwordText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        iniciarButton = findViewById(R.id.btnInicarSesion);
        btninicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent v = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(v);

            }
        });
        */
        initViews();
    }

    private void initViews() {
        usernameText = findViewById(R.id.etUsuario);
        passwordText = findViewById(R.id.etContrasenia);
    }

    public void onLoginButtonClick(View v) {
        System.out.println("Iniciando sesión...");
        String username = usernameText.getText().toString();
        String passsword = passwordText.getText().toString();

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);

        // Configuration.STATE_SERVICE.getAllStates();
        Call<TestObjectResponse> testCall = TestConfiguration.TEST_SERVICE.testRequest();
        testCall.enqueue(new Callback<TestObjectResponse>() {
            @Override
            public void onResponse(Call<TestObjectResponse> call, Response<TestObjectResponse> response) {
                System.out.println("Was call successful? " + response.isSuccessful());
            }

            @Override
            public void onFailure(Call<TestObjectResponse> call, Throwable t) {
                System.out.println("======== ERROR ON RETROFIT CALL ========");
                System.out.println(t.getLocalizedMessage());
            }
        });
    }

}
