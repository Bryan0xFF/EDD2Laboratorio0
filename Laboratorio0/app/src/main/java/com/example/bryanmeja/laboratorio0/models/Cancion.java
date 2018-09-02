package com.example.bryanmeja.laboratorio0.models;

public class Cancion {
    public String cancion;
    public String album;
    public String duracion;
    public int rating;

    public Cancion(String cancion, String album, String duracion, String rating){

        this.cancion = cancion;
        this.album = album;
        this.duracion = duracion;
        this.rating = Integer.parseInt(rating); //rating es de 1-10
    }
}
