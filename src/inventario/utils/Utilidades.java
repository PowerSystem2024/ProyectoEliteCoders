package inventario.utils;

// Utilidades.java
import java.util.Scanner;

public class Utilidades {
    public static final Scanner scanner = new Scanner(System.in);

    public static int obtenerOpcion(int maxOpciones) {
        int opcion;
        while (true) {
            System.out.print("Ingrese su opción (1-" + maxOpciones + "): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= maxOpciones) break;
                System.out.println("Opción inválida, intente nuevamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
        return opcion;
    }

    public static int obtenerCantidad() {
        int cantidad;
        while (true) {
            try {
                System.out.print("Ingrese la cantidad: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad > 0) break;
                System.out.println("Ingrese una cantidad válida mayor que 0.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
        return cantidad;
    }

    public static void limpiarPantalla() {
        System.out.println("\n".repeat(50));
    }

    public static void esperarEntrada() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }
}

