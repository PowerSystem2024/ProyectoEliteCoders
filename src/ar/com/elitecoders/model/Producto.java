package ar.com.elitecoders.model;

// Producto.java
public class Producto {
    private String nombre;
    private int stock;
    private double precio;

    // Constructor
    public Producto() {
    }

    // Constructor completo
    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // Getters & setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Reduce el stock del producto según se indique, siempre y cuando la cantidad
     * ingresada sea menor o igual al disponible
     * @param cantidad cantidad a descontar del stock
     */
    public void reducirStock(int cantidad) {
        if (stock >= cantidad) {
            this.stock -= cantidad;
        }
    }

    /**
     * Metodo toString()
     * @return visualización del producto
     */
    @Override
    public String toString() {
        return "Producto: " + nombre + " - Stock: " + stock + " - Precio: $" + precio;
    }
}
