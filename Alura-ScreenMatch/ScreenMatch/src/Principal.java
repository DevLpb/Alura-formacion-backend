import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Matrix");
        miPelicula.setFechaDeLanzamiento(1999);
        miPelicula.setDuracionEnMinutos(136);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();

        miPelicula.evalua(10);
        miPelicula.evalua(9);
        miPelicula.evalua(10);

        System.out.println(miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie miSerie = new Serie();
        miSerie.setNombre("Chernobyl");
        miSerie.setFechaDeLanzamiento(2019);
        miSerie.setTemporadas(1);
        miSerie.setMinutosPorEpisodio(60);
        miSerie.setEpisodiosPorTemporada(5);
        miSerie.muestraFichaTecnica();
        System.out.println(miSerie.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Ghost in the Shell");
        otraPelicula.setFechaDeLanzamiento(1995);
        otraPelicula.setDuracionEnMinutos(83);
        otraPelicula.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(miSerie);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver el total de títulos: "
                + calculadora.getTiempoTotal() + " minutos");

    }
}
