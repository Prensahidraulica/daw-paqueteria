package daw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Paqueteria {
    public static boolean repetir = false;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double pesoPaquete = 0;
        char zonaDestino = ' ';
    

        do {
            try {
                System.out.println("----------------------------------");
                System.out.print("Introduce el peso del paquete en kg: ");
                pesoPaquete = teclado.nextDouble();
                System.out.println("----------------------------------");
                repetir = false;

            } catch (InputMismatchException ime) {
                System.out.println("Error: Debes introducir un número válido para el peso. Recuerda no utilizar letras ni símbolos.");
                teclado.nextLine(); // Limpiar el buffer del scanner
                repetir = true;
            }
        } while (repetir);

        do {
            try {
                System.out.println("--------------------------------------");
                System.out.print("Introduce la zona de destino (A, B o C): ");
                zonaDestino = teclado.next().toUpperCase().charAt(0);
                System.out.println("--------------------------------------");
                repetir = false;
                
            } catch (InputMismatchException ime) {
                System.out.println("Error: Debes introducir una letra válida. No utilices números ni símbolos.");
                teclado.nextLine(); // Limpiar el buffer del scanner
                repetir = true;
            }
        } while (repetir);

        System.out.println("El coste de envío es: " + calcularTarifaEnvio(pesoPaquete, zonaDestino) + " euros.");

    }
    
    public static double calcularTarifaEnvio(double peso, char zona) {
        double costeBase;
        double costeTotal = 0;

        switch (zona) {
            case 'A':
                costeBase = 10.0;
                break;
            case 'B':
                costeBase = 15.0;
                break;
            case 'C':
                costeBase = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Zona de destino no válida. Debe ser A, B o C.");
        }

        do {
            if (peso < 5 && peso > 0) {
                costeTotal = costeBase;
                repetir = false;
            } else if (peso >= 5 && peso < 10) {
                costeTotal = costeBase + 5.0;
                repetir = false;
            } else if (peso >= 10) {
                costeTotal = costeBase + 10.0;
                repetir = false;
            } else {
                throw new IllegalArgumentException("Peso no válido. Debe ser un número positivo.");
            }
        } while (repetir);
        

        return costeTotal;
    }

}