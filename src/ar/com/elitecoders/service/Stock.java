package ar.com.elitecoders.service;

import ar.com.elitecoders.model.Carrito;
import ar.com.elitecoders.model.Producto;
import ar.com.elitecoders.utils.Utilidades;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Stock  {
    // Se inicializa listado de productos de manera estática
    public static List<Producto> productos = Utilidades.getInventarioInicial();
    private static Scanner scanner = new Scanner(System.in);

    public void iniciarInventario() {
        int opcion;
        do {
            Utilidades.limpiarPantalla();
            System.out.println("Inventario:");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Volver al menú principal");
            opcion = Utilidades.obtenerOpcion(5);

            switch (opcion) {
                case 1 -> Utilidades.imprimirProductos(productos);
                case 2 -> agregarProducto();
                case 3 -> modificarProducto();
                case 4 -> eliminarProducto();
            }
            Utilidades.esperarEntrada();
        } while (opcion != 5);
    }

    /**
     * Metodo que crea un nuevo producto en base a lo que el usuario ingresa por teclado
     * @return nuevo producto
     */
    public Producto leerProductoPorTeclado() {
        Producto producto = new Producto();
        System.out.print("Nombre: ");
        producto.setNombre(scanner.nextLine());

        System.out.print("Precio: ");
        producto.setPrecio(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Cantidad: ");
        producto.setStock(scanner.nextInt());
        scanner.nextLine();
        return producto;
    }

    public void agregarProducto() {
        System.out.println("\nAgregando producto");
        Producto producto = leerProductoPorTeclado();
        productos.add(producto);
        System.out.println("\nProducto agregado correctamente");
    }

    public void modificarProducto() {
        System.out.println("\nModificando producto");
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();

        Optional<Producto> productoEncontrado = productos.stream()
                .filter(producto -> producto.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (productoEncontrado.isEmpty()) {
            System.out.println("\nEl producto ingresado no existe");
            return;
        }

        Producto productoModificado = leerProductoPorTeclado();

        productoEncontrado.get().setStock(productoModificado.getStock());
        productoEncontrado.get().setNombre(productoModificado.getNombre());
        productoEncontrado.get().setPrecio(productoModificado.getPrecio());
        System.out.println("\nProducto modificado correctamente");
    }

    public void eliminarProducto() {
        System.out.println("\nEliminando producto");
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Optional<Producto> productoEncontrado = productos.stream()
                .filter(producto -> producto.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (productoEncontrado.isEmpty()) {
            System.out.println("\nEl producto ingresado no existe");
            return;
        }

        // Si el producto se encuentra en el carrito no permite eliminarlo
        if (Carrito.tieneProducto(nombre)) {
            System.out.println("No se puede eliminar un producto cargado en el carrito.\nVacíe el carrito y luego " +
                    "elimine");
            return;
        }

        productos.remove(productoEncontrado.get());
        System.out.println("Producto eliminado correctamente");
    }
}
