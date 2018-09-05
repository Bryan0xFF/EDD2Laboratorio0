package com.example.bryanmeja.laboratorio0;

import android.app.Activity;
import android.content.Intent;
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
    public static Map<String,Cancion> canciones = new ArrayMap<>();
    Button btnBuscar;
    Button btnCreatePlaylist;
    EditText etBuscar;
    String searchedSong =  "";

    private display_listAdapter displayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent a;
        //a = new Intent(this,display_listAdapter.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBuscar = findViewById(R.id.btnBuscar);
        etBuscar = (EditText) findViewById(R.id.editText);
        btnCreatePlaylist = findViewById(R.id.btnCrearPlaylist);
        StartArray();

        //TODO: buscar por nombre (usar trim)-> Alex
        //TODO: crear playlist -> Bryan

    }


    public void StartArray(){
        listaCanciones = findViewById(R.id.lvPlaylist);
        btnCreatePlaylist =(Button) findViewById(R.id.btnCrearPlaylist);

        btnCreatePlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregar = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(agregar);
            }
        });

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
        canciones.put("Animals".trim(), new Cancion("Animals","V","3:30",
                "4"));
        canciones.put("ASOT 301".trim(), new Cancion("ASOT 301","Armin van Buuren","5:00",
                "5"));
        canciones.put("How".trim(), new Cancion("How","Overexposed","3:21",
                "4"));
        canciones.put("Yellow submarine".trim(), new Cancion("Yellow submarine","Beatles","5:21",
                "5"));
        canciones.put("Cold".trim(), new Cancion("Cold","Maroon5","2:44",
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

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchedSong = etBuscar.getText().toString();

                if(canciones.containsKey(searchedSong)) {
                    Map<String,Cancion> selectedSong = new ArrayMap<>();
                    Cancion song = new Cancion();
                    song = canciones.get(searchedSong);
                    selectedSong.put(song.nombre, song);
                    displayAdapter = new display_listAdapter(MainActivity.this,selectedSong);
                    listaCanciones.setAdapter(displayAdapter);
                }
                else {
                    Toast.makeText(MainActivity.this,"La canción solicitada no está dentro de la biblioteca",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void cancelButton(View v) {
        etBuscar.setText("");
        displayAdapter = new display_listAdapter(this,canciones);
        listaCanciones.setAdapter(displayAdapter);
    }

}
