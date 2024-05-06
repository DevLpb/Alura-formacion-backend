package com.aluracursos.alurascreenmatchspring.principal;

import com.aluracursos.alurascreenmatchspring.model.DatosEpisodio;
import com.aluracursos.alurascreenmatchspring.model.DatosSerie;
import com.aluracursos.alurascreenmatchspring.model.DatosTemporadas;
import com.aluracursos.alurascreenmatchspring.model.Episodio;
import com.aluracursos.alurascreenmatchspring.service.ConsumoAPI;
import com.aluracursos.alurascreenmatchspring.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista del tipo "DatosEpisodio"
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()).collect(Collectors.toList());

        //Top 5 episodios
//        System.out.println("Top 5 episodios");
//        datosEpisodios.stream()
//                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primer filtro (N/A)" + e))
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .peek(e -> System.out.println("Segundo filtro ordenacion (M>m)" + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek( e-> System.out.println("Tercer filtro Mayusculas"))
//                .limit(5)
//                .forEach(System.out::println);

        //Convirtiendo los datos a una lista del tipo Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream().
                        map(d -> new Episodio(t.numeroDeTemporada(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        //Búsqueda de episodios a partir de un determinado año
//        System.out.println("Indica el año a partir del cual deseas buscar episodios");
//        var fecha = teclado.nextInt();
//        teclado.nextLine();
//
//        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episodio: " + e.getTitulo() +
//                                " Fecha de lanzamiento: " + e.getFechaDeLanzamiento().format(dtf)
//                ));

        //Busca episodio por palabras del título
//        System.out.println("Ingrese el título del episodio que desea buscar");
//
//        var fragmentoTitulo = teclado.nextLine();
//
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(fragmentoTitulo.toUpperCase()))
//                .findFirst();
//
//        if(episodioBuscado.isPresent()) {
//            System.out.println("Episodio encontrado");
//            System.out.println(" Los datos son: " + episodioBuscado.get());
//        } else {
//            System.out.println("Episodio no encontrado");
//        }

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media de las evaluaciones: " + est.getAverage());
        System.out.println("Mejor evaluación: " + est.getMax());
        System.out.println("Peor evaluación: " + est.getMin());

    }
}
