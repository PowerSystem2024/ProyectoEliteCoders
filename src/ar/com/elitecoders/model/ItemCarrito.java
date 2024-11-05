package ar.com.elitecoders.model;

// ItemCarrito.java
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public double getTotalParcial() {
        return producto.getPrecio() * cantidad;
    }
}

