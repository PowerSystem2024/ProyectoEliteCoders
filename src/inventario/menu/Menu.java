package inventario.menu;

import inventario.service.Ventas;
import inventario.utils.Utilidades;

// Menu.java
public class Menu {
    private Ventas ventas;

    public Menu() {
        ventas = new Ventas();
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            Utilidades.limpiarPantalla();
            System.out.println("MENÚ PRINCIPAL:");
            System.out.println("1. Ventas");
            System.out.println("2. Salir");
            opcion = Utilidades.obtenerOpcion(2);

            switch (opcion) {
                case 1 -> ventas.iniciarVentas();
                case 2 -> System.out.println("Saliendo...");
            }
            Utilidades.esperarEntrada();
        } while (opcion != 2);
    }
}

