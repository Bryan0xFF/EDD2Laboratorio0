package com.example.bryanmeja.laboratorio0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bryanmeja.laboratorio0.models.Cancion;

import java.util.ArrayList;
import java.util.List;

import static com.example.bryanmeja.laboratorio0.MainActivity.canciones;

public class Main2Activity extends AppCompatActivity {

    ListView lvAddPlaylist;
    Button addToPlaylist;
    Button goToPlaylist;
    EditText DatosObtain;
    public static List<Cancion> Playlist = new ArrayList<>();
    private playlist_adapter playlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Start();
    }

    private void Start(){
      lvAddPlaylist = findViewById(R.id.lvAddPlaylist);
      addToPlaylist = findViewById(R.id.btnAdd);
      DatosObtain = findViewById(R.id.etAgregar);
      goToPlaylist = findViewById(R.id.btnVerPlaylist);

      addToPlaylist.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(DatosObtain.getText().toString().trim().equals("")){
                  Toast.makeText(Main2Activity.this,"No se ha ingresado nada",
                          Toast.LENGTH_SHORT).show();
              }else if(canciones.containsKey(DatosObtain.getText().toString().trim()) == true){
                    Playlist.add(MainActivity.canciones.get(DatosObtain.getText().toString().trim()));
                    Toast.makeText(Main2Activity.this, "Datos guardados",
                            Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(Main2Activity.this,"Datos incorrectos",
                          Toast.LENGTH_SHORT).show();
              }
          }
      });

      goToPlaylist.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //TODO: ir a nueva UI que muestra lista
              Intent go = new Intent(Main2Activity.this,Main3Activity.class);
              startActivity(go);
          }
      });

      playlistAdapter = new playlist_adapter(this, canciones);
      lvAddPlaylist.setAdapter(playlistAdapter);

    }
}
