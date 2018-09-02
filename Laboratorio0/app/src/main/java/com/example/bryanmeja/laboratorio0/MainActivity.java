package com.example.bryanmeja.laboratorio0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.bryanmeja.laboratorio0.models.Cancion;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listaCanciones;
    Map<String,Cancion> canciones = new ArrayMap<>();
    Button btnBuscar;
    EditText editTextBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StartArray();
        btnBuscar = findViewById(R.id.btnBuscar);
        editTextBuscar = findViewById(R.id.editTextCancion);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: buscar cancion por nombre y desplegarlo en nuevo array
            }
        });
    }

    private void StartArray(){

        canciones.put("La buena y la mala",new Cancion("La buena y la mala",
                "Saber","3:30","4"));
        canciones.put("En Alabama", new Cancion("En Alabama","Les Fleurs du Mal",
                "2:37","8"));
        canciones.put("Origem",new Cancion("Origem","The Quantum Enigma",
                "1:57","7"));
        canciones.put("Crimson Bow and Arrow", new Cancion("Crimson Bow and Arrow",
                "Epica vs Attack On Titan","5:42","10"));
        canciones.put("Hola Mundo", new Cancion("Hola Mundo","Android","1:30",
                "3"));

    }
}
