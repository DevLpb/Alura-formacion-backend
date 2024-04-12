package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Matrix", 1999);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Ghost in the Shell", 1995);
        otraPelicula.evalua(10);
        var nuevaPelicula = new Pelicula("El señor de los anillos", 2001);
        nuevaPelicula.evalua(8);
        Serie miSerie = new Serie("Chernobyl", 2019);



        ArrayList<Titulo> lista = new ArrayList<>();
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
    }
}
