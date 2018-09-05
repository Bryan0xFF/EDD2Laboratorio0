package com.example.bryanmeja.laboratorio0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.bryanmeja.laboratorio0.models.Cancion;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private playlistUI_Adapter Adapter;
    List<Cancion> Playlist = Main2Activity.Playlist;
    ListView lvPlay;
    Button btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btnGoBack = findViewById(R.id.btnBack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Start3();


    }

    public void Start3(){
        btnGoBack = findViewById(R.id.btnBack);
        lvPlay = findViewById(R.id.lvVerPlaylist);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack;
                goBack = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(goBack);
            }
        });

        Adapter = new playlistUI_Adapter(Main3Activity.this,this.Playlist);
        lvPlay.setAdapter(Adapter);
    }
}
