import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Matrix", 1999);
        miPelicula.setDuracionEnMinutos(136);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();

        miPelicula.evalua(10);
        miPelicula.evalua(9);
        miPelicula.evalua(10);

        System.out.println(miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie miSerie = new Serie("Chernobyl", 2019);
        miSerie.setTemporadas(1);
        miSerie.setMinutosPorEpisodio(60);
        miSerie.setEpisodiosPorTemporada(5);
        miSerie.muestraFichaTecnica();
        System.out.println(miSerie.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Ghost in the Shell", 1995);
        otraPelicula.setDuracionEnMinutos(83);
        otraPelicula.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(miSerie);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver el total de títulos: "
                + calculadora.getTiempoTotal() + " minutos");

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("Episodio 1");
        episodio.setSerie(miSerie);
        episodio.setTotalVisualizaciones(350);

        filtro.filtra(episodio);

        var nuevaPelicula = new Pelicula("El señor de los anillos", 2001);
        nuevaPelicula.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(nuevaPelicula);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera película de la lista es: " + listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());


    }
}
