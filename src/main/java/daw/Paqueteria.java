package daw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Paqueteria {
    public static boolean repetir = false;

    // public static void main(String[] args) {

    //     Scanner teclado = new Scanner(System.in);

    //     double pesoPaquete = 0;
    //     char zonaDestino = ' ';
    
    //     // Bucle que valida que el usuario introduzca correctamente los kilos del paquete
    //     do {
    //         try {
    //             System.out.println("------------------------------------");
    //             System.out.print("Introduce el peso del paquete en kg: ");
    //             pesoPaquete = teclado.nextDouble();
    //             repetir = false;

    //         } catch (InputMismatchException ime) {
    //             System.out.println("-----------------------------------------------------------------------------------------------");
    //             System.out.println("Error: Debes introducir un número válido para el peso. Recuerda no utilizar letras ni símbolos.");
    //             teclado.nextLine(); // Limpiar el buffer del scanner
    //             repetir = true;
    //         }
    //     } while (repetir);

    //     teclado.nextLine(); // Limpiar el buffer del scanner antes de leer un char

    //     // Bucle que valida que el usuario introduzca correctamente la zona de destino
    //     do {
    //         try {
    //             System.out.println("----------------------------------------");
    //             System.out.print("Introduce la zona de destino (A, B o C): ");
    //             zonaDestino = teclado.next().toUpperCase().charAt(0);
    //             if (zonaDestino != 'A' && zonaDestino != 'B' && zonaDestino != 'C') {
    //                 System.out.println("-------------------------------------------------------");
    //                 System.out.println("Error -2: Zona de destino no válida. Debe ser A, B o C.");
    //                 repetir = true;
    //                 continue;
    //             }
    //             repetir = false;
                
    //         } catch (InputMismatchException ime) {
    //             System.out.println("-----------------------------------------------------------------------------");
    //             System.out.println("Error -1: Debes introducir una letra válida. No utilices números ni símbolos.");
    //             teclado.nextLine(); // Limpiar el buffer del scanner
    //             repetir = true;
    //         }
    //     } while (repetir);

    //     System.out.println("El coste de envío es: " + calcularTarifaEnvio(pesoPaquete, zonaDestino) + " euros.");

    //     teclado.nextLine(); // Limpiar el buffer del scanner antes de leer una cadena

    //     // Bucle que valida que el usuario introduzca correctamente el identificador del paquete
    //     String idPaquete = "";
    //     do {
    //         System.out.println("---------------------------------------------------------------");
    //         System.out.print("Introduce el identificador del paquete (4 dígitos entre 1 y 9): ");
    //         idPaquete = teclado.nextLine();
    //         System.out.println("-------------------------------------");   
    //         if (validarIdentificador(idPaquete)) {
    //             System.out.println("El identificador del paquete es válido.");
    //             repetir = false;
    //         } else {
    //             System.out.println("Error: El identificador del paquete no es válido. Debe tener 4 dígitos entre 1 y 9.");
    //             repetir = true;
    //         }
    //     } while (repetir);

    //     // Bucle que valida que el usuario introduzca correctamente el número de paquetes
    //     int totalPaquetes = 0;
    //     do {
    //         try {
    //             System.out.println("-------------------------------------------------");
    //             System.out.print("Introduce el número total de paquetes a repartir: ");
    //             totalPaquetes = teclado.nextInt();
    //             repetir = false;
    //         } catch (InputMismatchException ime) {
    //             System.out.println("-------------------------------------------------------------------");
    //             System.out.println("Error: Debes introducir un número válido para el total de paquetes.");
    //             teclado.nextLine(); // Limpiar el buffer del scanner
    //             repetir = true;
    //         }
    //     } while (repetir);

    //     // Bucle que valida que el usuario introduzca correctamente el número de camiones
    //     int numeroCamiones = 0;
    //     do {
    //         try {
    //             System.out.println("-------------------------------------------------------");
    //             System.out.print("Introduce el número total de camiones que van a repartir: ");
    //             numeroCamiones = teclado.nextInt();
    //             if (numeroCamiones < 0) {
    //                 System.out.println("------------------------------------------------");
    //                 System.out.println("Error: Introduce un número igual o mayor a cero.");
    //                 repetir = true; 
    //             } 
    //             repetir = false;

    //         } catch (InputMismatchException ime) {
    //             System.out.println("-------------------------------------------------------------------------------------------");
    //             System.out.println("Error: Debes introducir un número válido sin letras ni decimales para el total de camiones.");
    //             teclado.nextLine(); // Limpiar el buffer del scanner
    //             repetir = true;
    //         }
    //     } while (repetir);

    //     System.out.println("El número de paquetes que cada camión llevará serán: " + repartirCarga(totalPaquetes, numeroCamiones));

    // }
    
    // Función que calcula la tarifa base del envío en función de la zona de envío y del peso del paquete
    public static double calcularTarifaEnvio(double peso, char zona) {
        double costeBase;

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
            default: return -1; // zona inválida
        }

        if (peso <= 0) return -1;

        if (peso < 5) return costeBase;

        if (peso < 10) return costeBase + 5.0;

        return costeBase + 10.0;
    }

    // Función que verifica que el identificador del paquete tiene 4 caracteres y estos dígitos están entre 1 y 9
    public static boolean validarIdentificador(String id){
        if (id.length() != 4) return false;

        for (char c : id.toCharArray()) {
            if (c < '1' || c > '9')
                return false;
        }
        return true;
    }

    // Función que reparte la carga de paquetes entre los camiones disponibles
    // Si se lanza la excepción, devolver 0
    // División entera entre el total de paquetes y el número de camiones

    public static int repartirCarga(int totalPaquetes, int camiones) {
        try {
            return totalPaquetes / camiones;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

}