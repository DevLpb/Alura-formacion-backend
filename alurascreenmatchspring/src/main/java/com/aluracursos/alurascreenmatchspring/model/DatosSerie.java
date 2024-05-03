package com.aluracursos.alurascreenmatchspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Record usado para mapear los datos de la serie
//Usa las notaciones de Jackson para identificar los datos en el formato Json
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora los datos que no le pedimos
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion) {
}
