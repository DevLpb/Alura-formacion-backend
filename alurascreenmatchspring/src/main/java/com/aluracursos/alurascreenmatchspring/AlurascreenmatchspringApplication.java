package com.aluracursos.alurascreenmatchspring;

import com.aluracursos.alurascreenmatchspring.model.DatosSerie;
import com.aluracursos.alurascreenmatchspring.service.ConsumoAPI;
import com.aluracursos.alurascreenmatchspring.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlurascreenmatchspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AlurascreenmatchspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hola mundo en Spring");
		var consumoApi = new ConsumoAPI(); //Instancia de la clase ConsumoAPI
		var json = consumoApi.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=28749dc6");
//		var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		//Instancia el objeto de clase ConvierteDatos
		ConvierteDatos conversor = new ConvierteDatos();

		//Usa el método de la interfaz implementada, asignandole json (url omdbapi)
		//Y el Record DatosSerie
		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);
	}
}
