package ar.com.elitecoders.utils;

// Utilidades.java
import ar.com.elitecoders.model.Producto;

import java.util.ArrayList;
import java.util.List;
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

    public static List<Producto> getInventarioInicial() {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Leche", 2, 1500));
        productos.add(new Producto("Arroz", 14, 800));
        productos.add(new Producto("Harina", 56, 1350));
        productos.add(new Producto("Gaseosa", 40, 1990));
        productos.add(new Producto("Vino", 8, 1200));

        return productos;
    }

    public static void imprimirProductos(List<Producto> productos) {
        int maxNombre = 20; // Longitud del título de la columna
        int maxStock = 5;
        int maxPrecio = 10;

        for (Producto p : productos) {
            maxNombre = Math.max(maxNombre, p.getNombre().length());
            maxStock = Math.max(maxStock, String.valueOf(p.getStock()).length());
            maxPrecio = Math.max(maxPrecio, String.format("%.2f", p.getPrecio()).length());
        }

        // Formato dinámico
        String formato = "%-" + (maxNombre + 2) + "s - %" + (maxStock + 2) + "s - %" + (maxPrecio + 2) + "s%n";

        // Imprime encabezado
        System.out.println("");
        System.out.printf(formato, "Nombre", "Stock", "Precio");
        System.out.println("=".repeat(maxNombre + maxStock + maxPrecio + 8));

        // Imprime cada línea formateada
        for (Producto p : productos) {
            System.out.printf(formato, p.getNombre(), p.getStock(), String.format("%.2f", p.getPrecio()));
        }
    }
}

