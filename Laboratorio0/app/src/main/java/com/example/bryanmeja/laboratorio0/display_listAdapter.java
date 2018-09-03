package com.example.bryanmeja.laboratorio0;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CaptureResult;
import android.util.ArrayMap;
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


public class display_listAdapter extends BaseAdapter {

    Activity context;
    Map<String, Cancion> canciones;
    List<String> temp;
    private static LayoutInflater inflater = null;

    public display_listAdapter(Activity context, Map<String,Cancion> canciones){
        this.context = context;
        this.canciones = canciones;
        temp = new ArrayList<>(canciones.keySet());
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return canciones.size();
    }

    @Override
    public Object getItem(int position) {
        return canciones.get(temp.get(position).trim());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        itemView = (itemView == null)? inflater.inflate(R.layout.display_list, null): itemView;
        TextView nombre = itemView.findViewById(R.id.textViewNombreDic);
        TextView album = itemView.findViewById(R.id.textViewAlbumDic);
        TextView duracion = itemView.findViewById(R.id.textViewDuracionDic);
        RatingBar rating = itemView.findViewById(R.id.ratingBarCalificacionDic);
        Cancion actual = (Cancion) this.getItem(position);
        nombre.setText(actual.nombre);
        album.setText(actual.album);
        duracion.setText(actual.duracion);
        rating.setProgress(actual.rating);
        return itemView;
    }


}
