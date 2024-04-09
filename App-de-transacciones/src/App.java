import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String nombre = "John Doe";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;

        System.out.println("********************************");
        System.out.println("\nNombre del cliente: " + nombre);
        System.out.println("El tipo de cuenta es: " + tipoDeCuenta);
        System.out.println("Su saldo disponible es: " + "$" + saldo);
        System.out.println("\n********************************");

        String menu = """
                *** Escriba el número de la opción deseada ***
                1. Consultar saldo
                2. Retirar
                3. Depositar
                9. Salir
                """;

        Scanner teclado = new Scanner(System.in);
        while (opcion != 9) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El saldo actualizado es: " + "$" + saldo);
                    break;

                case 2:
                    System.out.println("¿Cuál es el valor que desea retirar?");
                    double valorRetiro = teclado.nextDouble();
                    if (saldo < valorRetiro) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        saldo -= valorRetiro;
                        System.out.println("El saldo actualizado es: " + "$" + saldo);
                    }
                    break;

                case 3:
                    System.out.println("¿Cuál es el valor que desea depositar?");
                    double valorDeposito = teclado.nextDouble();
                    saldo += valorDeposito;
                    System.out.println("El saldo actualizado es: " + "$" + saldo);
                    break;

                case 9:
                    System.out.println("Terminando transacción. Gracias por usar nuestro servicio.");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}