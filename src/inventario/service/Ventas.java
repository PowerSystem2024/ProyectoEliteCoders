package inventario.service;

// Ventas.java
import java.util.ArrayList;
import java.util.List;

public class Ventas {
    private List<Producto> productos;
    private Carrito carrito;

    public Ventas() {
        productos = new ArrayList<>();
        carrito = new Carrito();
        productos.add(new Producto("Producto 1", 100, 10.5));
        productos.add(new Producto("Producto 2", 50, 20.0));
        productos.add(new Producto("Producto 3", 0, 15.0)); // Sin stock
    }

    public void iniciarVentas() {
        int opcion;
        do {
            Utilidades.limpiarPantalla();
            System.out.println("Ventas:");
            System.out.println("1. Cargar productos al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Volver al menú principal");
            opcion = Utilidades.obtenerOpcion(3);

            switch (opcion) {
                case 1 -> venta();
                case 2 -> carrito.mostrarCarrito();
            }
            Utilidades.esperarEntrada();
        } while (opcion != 3);
    }

    private void venta() {
        Utilidades.limpiarPantalla();
        System.out.println("Productos disponibles:");
        mostrarProductos();

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

    private void mostrarProductos() {
        productos.stream()
                .filter(p -> p.getStock() > 0)
                .forEach(System.out::println);
    }

    private Producto buscarProducto(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
