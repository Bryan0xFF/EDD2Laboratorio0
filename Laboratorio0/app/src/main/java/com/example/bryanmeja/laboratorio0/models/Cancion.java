package com.example.bryanmeja.laboratorio0.models;

public class Cancion {
    public String cancion;
    public String album;
    public double duracion;
    public int rating;

    public Cancion(String cancion, String album, String duracion, String rating){

        this.cancion = cancion;
        this.album = album;
        this.duracion = Double.parseDouble(duracion);
        this.rating = Integer.parseInt(rating);
    }
}
