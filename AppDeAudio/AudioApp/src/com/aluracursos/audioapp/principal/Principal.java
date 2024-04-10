package com.aluracursos.audioapp.principal;

import com.aluracursos.audioapp.modelo.Cancion;
import com.aluracursos.audioapp.modelo.MisFavoritos;
import com.aluracursos.audioapp.modelo.Podcast;

public class Principal {
    public static void main(String[] args) {
        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Imagine");
        miCancion.setCantante("John Lennon");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("IDK");
        miPodcast.setTitulo("A Random Podcast");

        //Set de likes y reproducciones de canción
        for (int i = 0; i < 100; i++ ) {
            miCancion.meGusta();
        }

        for (int i = 0; i < 500; i++) {
            miCancion.reproduce();
        }
        System.out.println("Total de 'me gusta': " + miCancion.getTotalDeMeGusta());
        System.out.println("Total de reproducciones: " + miCancion.getTotalDeReproducciones());

        //Set de likes y reproducciones de podcast
        for (int i = 0; i < 1250; i++) {
            miPodcast.meGusta();
        }

        for (int i = 0; i < 5000; i++) {
            miPodcast.reproduce();
        }

        System.out.println("Total de 'me gusta': " + miPodcast.getTotalDeMeGusta());
        System.out.println("Total de reproducciones: " + miPodcast.getTotalDeReproducciones());

        MisFavoritos favoritos = new MisFavoritos();
        favoritos.agrega(miCancion);
        favoritos.agrega(miPodcast);
    }
}
