package ar.com.elitecoders.service;

// Ventas.java
import ar.com.elitecoders.model.Carrito;
import ar.com.elitecoders.model.Producto;
import ar.com.elitecoders.utils.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class Ventas {
    private Carrito carrito;

    public Ventas() {
        carrito = new Carrito();
    }

    public void iniciarVentas() {
        int opcion;
        do {
            Utilidades.limpiarPantalla();
            System.out.println("Ventas:");
            System.out.println("1. Cargar productos al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Vaciar carrito");
            System.out.println("4. Volver al menú principal");
            opcion = Utilidades.obtenerOpcion(4);

            switch (opcion) {
                case 1 -> venta();
                case 2 -> carrito.mostrarCarrito();
                case 3 -> carrito.vaciarCarrito();
            }
            Utilidades.esperarEntrada();
        } while (opcion != 4);
    }

    private void venta() {
        Utilidades.limpiarPantalla();
        System.out.println("Productos disponibles:");
        List<Producto> disponibles = Stock.productos
                .stream()
                .filter(p -> p.getStock() > 0)
                .toList();
        Utilidades.imprimirProductos(disponibles);

        System.out.print("Ingrese el nombre del producto a comprar: ");
        String nombreProducto = Utilidades.scanner.nextLine();
        Producto producto = buscarProducto(nombreProducto);
        if (producto == null || producto.getStock() <= 0) {
            System.out.println("Producto no disponible.");
        } else {
            int cantidad = Utilidades.obtenerCantidad();
            if (cantidad <= producto.getStock()) {
                carrito.agregarItem(producto, cantidad);
                System.out.println("Producto agregado al carrito.");
            } else {
                System.out.println("Stock insuficiente.");
            }
        }
    }

    private Producto buscarProducto(String nombre) {
        return Stock.productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
