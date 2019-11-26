package com.example.byrn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class BusquedaCita extends AppCompatActivity implements View.OnClickListener{

    Button btnFecha,btnHora,btnBuscar;
    EditText etfolio;
    Spinner spTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_cita);

        btnFecha = findViewById(R.id.btnSelectFecha);
        btnHora = findViewById(R.id.btnSelectHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);

        etfolio = findViewById(R.id.etFolioCita);

        btnBuscar = findViewById(R.id.btnBuscarCita);
        spTipo = findViewById(R.id.spTipoCita);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        String[] tiposCitas = {"Compraventa","Informacion","Recorridón","Otro"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        tiposCitas);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spTipo.setAdapter(spinnerArrayAdapter);
    }

    private int dia, mes, anio, hora, minutos;
    @Override
    public void onClick(View view){
        if (view== btnFecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (datePicker, year, monthOfYear, dayOfMonth) -> {

                        if (monthOfYear<9) {
                            btnFecha.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }else{
                            btnFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    },anio,mes,dia);
            datePickerDialog.show();
        }//fin fecha
        if(view == btnHora){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    (timePicker, hourOfDay, minute) -> {
                        String h,m;

                        if(hourOfDay<10)
                        {
                            h="0"+hourOfDay;
                        }
                        else
                        {
                            h=hourOfDay+"";
                        }
                        if(minute<10)
                        {
                            m="0"+minute;
                        }
                        else
                        {
                            m=minute+"";
                        }
                        btnHora.setText(h+ ":"+m);
                    },hora,minutos,false);
            timePickerDialog.show();
        }
    }
}
