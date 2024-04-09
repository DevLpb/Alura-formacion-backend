public class Principal {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula();
        miPelicula.nombre = "Matrix";
        miPelicula.fechaDeLanzamiento = 1999;
        miPelicula.duracionEnMinutos = 136;

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(9);
        miPelicula.evalua(10);

        System.out.println(miPelicula.sumaDeEvaluaciones);
        System.out.println(miPelicula.totalDeEvaluaciones);
        System.out.println(miPelicula.calculaMedia());

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.nombre = "Ghost in the Shell";
        otraPelicula.fechaDeLanzamiento = 1995;
        otraPelicula.duracionEnMinutos = 83;

        otraPelicula.muestraFichaTecnica();
        otraPelicula.evalua(10);
        miPelicula.evalua(9);
        miPelicula.evalua(9);
    }
}
