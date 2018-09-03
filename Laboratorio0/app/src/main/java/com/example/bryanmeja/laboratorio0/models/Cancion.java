package com.example.bryanmeja.laboratorio0.models;

public class Cancion {
    public String nombre;
    public String album;
    public String duracion;
    public int rating;

    public Cancion(String nombre, String album, String duracion, String rating){

        this.nombre = nombre;
        this.album = album;
        this.duracion = duracion;
        this.rating = Integer.parseInt(rating); //rating es de 1-10
    }
}
