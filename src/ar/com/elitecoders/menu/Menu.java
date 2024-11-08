package ar.com.elitecoders.menu;

import ar.com.elitecoders.service.Stock;
import ar.com.elitecoders.service.Ventas;
import ar.com.elitecoders.utils.Utilidades;

// Menu.java
public class Menu {
    private Ventas ventas;
    private Stock stock;

    public Menu() {
        this.ventas = new Ventas();
        this.stock = new Stock();
    }

    /**
     * Metodo para mostrar el menu principal con sus opciones
     */
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            Utilidades.limpiarPantalla();
            System.out.println("MENÚ PRINCIPAL:");
            System.out.println("1. Ventas");
            System.out.println("2. Inventario");
            System.out.println("3. Salir");
            opcion = Utilidades.obtenerOpcion(3);

            switch (opcion) {
                case 1 -> ventas.iniciarVentas();
                case 2 -> stock.iniciarInventario();
                case 3 -> System.out.println("Saliendo...");
            }
            Utilidades.esperarEntrada();
        } while (opcion != 3);
    }
}

