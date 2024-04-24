import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Escriba el número de la película que quiere consultar");
        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consulta.conseguirPelicula(numeroDePelicula);
            System.out.println(pelicula.propiedades());
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Número no encontrado " + e.getMessage());
        }
        catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }

    }
}
