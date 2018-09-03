package com.example.bryanmeja.laboratorio0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bryanmeja.laboratorio0.models.Cancion;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listaCanciones;
    private Map<String,Cancion> canciones = new ArrayMap<>();
    Button btnBuscar;
    EditText editTextBuscar;

    private display_listAdapter displayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnBuscar = findViewById(R.id.btnBuscar);
        editTextBuscar = findViewById(R.id.editTextCancion);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartArray();

        //TODO: buscar por nombre (usar trim)-> Alex
        //TODO: crear playlist -> Bryan

    }

    public void StartArray(){
        listaCanciones = findViewById(R.id.lvPlaylist);

        canciones.put("La buena y la mala".trim(),new Cancion("La buena y la mala",
                "Saber","3:30","4"));
        canciones.put("En Alabama".trim(), new Cancion("En Alabama","Les Fleurs du Mal",
                "2:37","8"));
        canciones.put("Origem".trim(),new Cancion("Origem","The Quantum Enigma",
                "1:57","7"));
        canciones.put("Crimson Bow and Arrow".trim(), new Cancion("Crimson Bow and Arrow",
                "Epica vs Attack On Titan".trim(),"5:42","10"));
        canciones.put("Hola Mundo".trim(), new Cancion("Hola Mundo","Android","1:30",
                "3"));

        displayAdapter = new display_listAdapter(this,canciones);
        listaCanciones.setAdapter(displayAdapter);

        listaCanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click to item"+position,
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
