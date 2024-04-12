package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.lang.reflect.Array;
import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Matrix", 1999);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Ghost in the Shell", 1995);
        otraPelicula.evalua(10);
        var nuevaPelicula = new Pelicula("El señor de los anillos", 2001);
        nuevaPelicula.evalua(8);
        Serie miSerie = new Serie("Chernobyl", 2019);



        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(nuevaPelicula);
        lista.add(miSerie);

        for (Titulo item: lista) {
            System.out.println("Nombre: " + item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificación: " + pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Willem Dafoe");
        listaDeArtistas.add("Keanuu Reeves");
        listaDeArtistas.add("Tom Cruise");

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + lista);
    }
}
