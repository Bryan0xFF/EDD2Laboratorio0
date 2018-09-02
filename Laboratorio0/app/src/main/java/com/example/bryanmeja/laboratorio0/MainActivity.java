package com.example.bryanmeja.laboratorio0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.widget.ListView;

import com.example.bryanmeja.laboratorio0.models.Cancion;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listaCanciones;
    Map<String,Cancion> canciones = new ArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
