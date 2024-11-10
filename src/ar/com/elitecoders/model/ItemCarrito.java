package ar.com.elitecoders.model;

// ItemCarrito.java
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    /**
     * Constructor
     * @param producto producto
     * @param cantidad cantidad del producto
     */
    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters
    public Producto getProducto() { return producto; }

    public int getCantidad() { return cantidad; }

    /**
     * Obtiene el precio que acumula este ItemCarrito, multiplicando el precio
     * del producto por la cantidad indicada
     * @return monto (precio) del producto multiplicado por la cantidad
     */
    public double getTotalParcial() {
        return producto.getPrecio() * cantidad;
    }
}

