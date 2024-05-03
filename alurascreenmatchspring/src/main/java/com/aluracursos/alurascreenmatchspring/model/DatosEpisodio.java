package com.aluracursos.alurascreenmatchspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Record usado para mapear los datos de los episodios
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
  @JsonAlias("Title") String titulo,
  @JsonAlias("Episode") Integer numeroEpisodio,
  @JsonAlias("imdbRating") String evaluacion,
  @JsonAlias("Released") String fechaDeLanzamiento
) {
}
