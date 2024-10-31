package ar.com.elitecoders.model;

// Carrito.java
import ar.com.elitecoders.service.Stock;
import ar.com.elitecoders.utils.Utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrito {
    private static List<ItemCarrito> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
        producto.reducirStock(cantidad);
    }

    public void mostrarCarrito() {
        if (items.isEmpty()) {
            System.out.println("El carrito se encuentra vacío");
        } else {
            System.out.println("Carrito de compras:");
            double total = 0;
            for (ItemCarrito item : items) {
                System.out.printf("%s - Cantidad: %d - Total: %.2f%n",
                        item.getProducto().getNombre(),
                        item.getCantidad(),
                        item.getTotalParcial());
                total += item.getTotalParcial();
            }
            System.out.printf("Total a pagar: %.2f%n", total);
        }
    }

    public void vaciarCarrito() {
        System.out.print("\n¿Está seguro que quiere vaciar el carrito? (si/no)");
        String respuesta = Utilidades.scanner.nextLine();

        // En caso que el usuario ingrese cualquier texto distinto a "si", se lo saca del metodo con un "early return"
        if (!respuesta.equals("si")) {
            return;
        }
        Map<String, Producto> inventarioMap = new HashMap<>();
        for (Producto producto : Stock.productos) {
            inventarioMap.put(producto.getNombre(), producto);
        }
        for (ItemCarrito item : items) {
            Producto productoInventario = inventarioMap.get(item.getProducto().getNombre());
            if (productoInventario != null) {
                productoInventario.setStock(productoInventario.getStock() + item.getCantidad());
            }
        }
        items.clear();
        System.out.println("\n¡Carrito vaciado con éxito!");
    }

    public static boolean tieneProducto(String nombreProducto) {
        return items
                .stream()
                .anyMatch(producto -> producto.getProducto().getNombre().equalsIgnoreCase(nombreProducto));
    }
}
