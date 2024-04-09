import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double gradosCelcius = 0;
        double gradosFahrenheit = 0;
        int opcion = 0;

        System.out.println("Iniciando programa convertidor de temperatura");
        System.out.println("""
                Indica la opción deseada:
                1. Convertir Celcius en Fahrenheit.
                2. Convertir Fahrenheit en Celcius.
                """);
        Scanner teclado = new Scanner(System.in);
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese la temperatura en Celcius");
                gradosCelcius = teclado.nextDouble();
                gradosFahrenheit = (gradosCelcius * 9/5) + 32;
                //printf es la forma abreviada para darle formato a la línea siguiente.
                System.out.printf("La temperatura %.1f°C en Fahrenheit es: %.1f°F", gradosCelcius, gradosFahrenheit);
                break;

            case 2:
                System.out.println("Ingrese la temperatura en Fahrenheit");
                gradosFahrenheit = teclado.nextDouble();
                gradosCelcius = (gradosFahrenheit - 32) * 5/9;
                //printf es la forma abreviada para darle formato a la línea siguiente.
                System.out.printf("La temperatura %.1f°F en Celcius es: %.1f°C", gradosFahrenheit, gradosCelcius);
                break;

            default:
                System.out.println("Opción no válida.");
        }
        }

    }