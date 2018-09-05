package com.example.bryanmeja.laboratorio0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import static com.example.bryanmeja.laboratorio0.MainActivity.canciones;

public class Main2Activity extends AppCompatActivity {

    ListView lvAddPlaylist;
    Button addToPlaylist;
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

      playlistAdapter = new playlist_adapter(this, canciones);
      lvAddPlaylist.setAdapter(playlistAdapter);

    }
}
