import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroMisterioso = new Random().nextInt(100);

        Scanner entrada = new Scanner(System.in);
        System.out.println("Adivina el número. Digita la cantidad de intentos deseada: ");

        int intentosMaximos = 0;
        int contador = 0;

        intentosMaximos = entrada.nextInt();

        while (contador < intentosMaximos) {
            System.out.println("Ingresa un número del 1 al 100");
            contador++;
            System.out.println("Intento n° " + contador);
            int numeroIngresado = entrada.nextInt();

            if (numeroIngresado > numeroMisterioso) {
                System.out.println("El número a adivinar es menor");
            } else if (numeroIngresado < numeroMisterioso) {
                System.out.println("El número a adivinar es mayor");
            } else {
                System.out.printf("¡Adivinaste el número en %d intentos!", contador);
                break;
            }

            if (contador == intentosMaximos) {
                System.out.printf("""
                        No lograste adivinar el número en %d intentos.
                        El número era %d""", intentosMaximos, numeroMisterioso);
            }
        }

    }


}
