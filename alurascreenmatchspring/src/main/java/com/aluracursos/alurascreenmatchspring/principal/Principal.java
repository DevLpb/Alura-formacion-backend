package com.aluracursos.alurascreenmatchspring.principal;

import com.aluracursos.alurascreenmatchspring.model.DatosEpisodio;
import com.aluracursos.alurascreenmatchspring.model.DatosSerie;
import com.aluracursos.alurascreenmatchspring.model.DatosTemporadas;
import com.aluracursos.alurascreenmatchspring.service.ConsumoAPI;
import com.aluracursos.alurascreenmatchspring.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    //Instancia de clases para uso posterior
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=28749dc6";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu() {
        System.out.println("Escribe el nombre de la nombreSerie que deseas buscar.");
        //Busca los datos generales de la serie
        var nombreSerie = teclado.nextLine();
        //El método .replace() hace que los espacios ingresados se vuelvan "+" en la URL
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las Temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE+nombreSerie.
                    replace(" ", "+")+"&Season="+i+API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
    //    for (DatosTemporadas datosTemp : temporadas) {
    //        System.out.println(datosTemp);
    //    }

        //Mostrar sólo el titulo de los episodios para las temporadas
//        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        //El bloque de código de arriba puede resumirse usando una expresión Lambda
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
