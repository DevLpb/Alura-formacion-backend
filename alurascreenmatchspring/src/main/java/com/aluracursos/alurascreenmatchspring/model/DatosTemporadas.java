package com.aluracursos.alurascreenmatchspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//Record usado para mapear los datos de las temporadas
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporadas(
 @JsonAlias("Season") Integer numeroDeTemporada,
 @JsonAlias("Episodes") List<DatosEpisodio> episodios
        ) {
}
