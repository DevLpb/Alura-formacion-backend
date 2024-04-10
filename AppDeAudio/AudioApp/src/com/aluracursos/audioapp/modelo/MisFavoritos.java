package com.aluracursos.audioapp.modelo;

public class MisFavoritos {
    public void agrega(Audio audio) {
        if (audio.getClasificacion() >= 8) {
            System.out.println(audio.getTitulo() + " es uno de los favoritos del momento.");
        } else {
            System.out.println(audio.getTitulo() + " algo nuevo que escuchar.");
        }
    }
}
