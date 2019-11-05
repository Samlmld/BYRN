package com.example.byrn;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerDragListener,OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;
    private Marker markerprueba;
    public String lat , longitud;
    AgregarPropiedad a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng Zapotlanejo = new LatLng(20.62311065180603, -103.06540554474388);
        mMap.addMarker(new MarkerOptions().position(Zapotlanejo).title("Zapotlanejo Jalisco").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Zapotlanejo));

        LatLng prueba = new LatLng (20.62482468319483,-103.07110065161473);
        markerprueba  = googleMap.addMarker(new MarkerOptions()
        .position(prueba)
                .title("Zapo").draggable(true).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.equals(markerprueba)){

            lat = Double.toString(marker.getPosition().latitude);
            longitud = Double.toString(marker.getPosition().longitude);

            Intent v = new Intent(MapsActivity.this, AgregarPropiedad.class);
            v.putExtra("latitud",lat);
            v.putExtra("longitud",longitud);

            startActivity(v);



        }




        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}
