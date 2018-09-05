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
import java.util.Map;
import java.util.zip.Inflater;

public class playlist_adapter extends BaseAdapter {

    Activity context;
    private static LayoutInflater inflater = null;
    Map<String, Cancion> canciones;
    List<String> Playlist;
    List<String> temp;

    public playlist_adapter(Activity context, Map<String, Cancion> canciones){
        this.context = context;
        this.canciones = canciones;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        temp = new ArrayList<>(canciones.keySet());
    }

    @Override
    public int getCount() {
        return canciones.size();
    }

    @Override
    public Object getItem(int position) {
        return canciones.get(temp.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null)? inflater.inflate(R.layout.add_playlist,null): itemView;
        TextView nombre = itemView.findViewById(R.id.textViewNombre);
        TextView album = itemView.findViewById(R.id.textViewAlbum);
        TextView duracion = itemView.findViewById(R.id.textViewDuracion);
        RatingBar rating = itemView.findViewById(R.id.ratingBarCalificacion);
        Cancion actual = (Cancion) this.getItem(position);
        nombre.setText(actual.nombre);
        album.setText(actual.album);
        duracion.setText(actual.duracion);
        rating.setProgress(actual.rating);
        return itemView;
    }
}
