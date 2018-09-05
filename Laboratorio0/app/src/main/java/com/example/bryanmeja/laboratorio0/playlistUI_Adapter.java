package com.example.bryanmeja.laboratorio0;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.bryanmeja.laboratorio0.models.Cancion;

import java.util.ArrayList;
import java.util.List;

public class playlistUI_Adapter extends BaseAdapter {

    Activity context;
    private static LayoutInflater inflater = null;
    List<Cancion> Playlist;

    public playlistUI_Adapter(Activity context, List<Cancion> Playlist){
        this.Playlist = Playlist;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Playlist.size();
    }

    @Override
    public Object getItem(int position) {
        return Playlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO: probar en Main3Activity
        View itemView = convertView;
        itemView =(convertView == null)? inflater.inflate(R.layout.add_playlist,null):itemView;

        TextView nombre = itemView.findViewById(R.id.textViewNombre);
        TextView album = itemView.findViewById(R.id.textViewAlbum);
        TextView duracion = itemView.findViewById(R.id.textViewDuracion);
        RatingBar rating = itemView.findViewById(R.id.ratingBarCalificacion);
        Cancion actual = Playlist.get(position);
        nombre.setText(actual.nombre);
        album.setText(actual.album);
        duracion.setText(actual.duracion);
        rating.setProgress(actual.rating);
        return itemView;
    }
}
