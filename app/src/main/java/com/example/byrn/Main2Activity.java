package com.example.byrn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;


public class Main2Activity extends AppCompatActivity


implements NavigationView.OnNavigationItemSelectedListener,
        PropiedadesFragment.OnFragmentInteractionListener,
        CitasFragment.OnFragmentInteractionListener,
        UsuariosFragment.OnFragmentInteractionListener,
        EstadisticasFragment.OnFragmentInteractionListener
{


    private AppBarConfiguration mAppBarConfiguration;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Fragment fr = null;
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.SeccionPropiedades, R.id.SeccionCitas, R.id.SeccionUsuarios,
                R.id.SeccionEstadisticas, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        fr = new PropiedadesFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,fr).commit();

        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int  id = menuItem.getItemId();
        boolean seleccionado=false;
        Fragment fr = null;

        if(id ==R.id.SeccionPropiedades){
            seleccionado=true;

            fr = new PropiedadesFragment();

        }else if (id == R.id.SeccionCitas){
            seleccionado = true;
            fr = new CitasFragment();

        }else if (id == R.id.SeccionUsuarios){
                seleccionado=true;
                fr = new UsuariosFragment();

        }else if (id == R.id.SeccionEstadisticas){
                seleccionado = true;
                fr = new EstadisticasFragment();
        }

        if(seleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,fr).commit();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
