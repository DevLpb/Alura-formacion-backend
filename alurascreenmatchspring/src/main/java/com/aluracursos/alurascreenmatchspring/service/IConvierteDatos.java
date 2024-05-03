package com.aluracursos.alurascreenmatchspring.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase); //tipos genéricos
}
