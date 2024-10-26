package inventario.model;

// Carrito.java
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

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
}
