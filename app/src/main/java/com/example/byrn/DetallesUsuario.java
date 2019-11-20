package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import mx.reel.pojos.User;

public class DetallesUsuario extends AppCompatActivity {
    private User user = null;
    private TextView nameLabel = null;
    private TextView lastnameLabel = null;
    private TextView emailLabel = null;
    private TextView addressLabel = null;
    private TextView cellphoneLabel = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_usuario);

        nameLabel = findViewById(R.id.userDetailsName);
        lastnameLabel = findViewById(R.id.userDetailsLastname);
        emailLabel = findViewById(R.id.userDetailsEmail);
        addressLabel = findViewById(R.id.userDetailsAddress);
        cellphoneLabel = findViewById(R.id.userDetailsCellphone);

        user = (User) getIntent().getSerializableExtra("user");
        initViewData();
    }

    private void initViewData() {
        nameLabel.setText(user.getName());
        lastnameLabel.setText(user.getLastName());
        emailLabel.setText(user.getEmail());
        addressLabel.setText(user.getAddress());
        cellphoneLabel.setText(user.getCellphone());
    }
}
