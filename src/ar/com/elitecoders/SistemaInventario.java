package ar.com.elitecoders;

import ar.com.elitecoders.menu.Menu;

// SistemaInventario.java
public class SistemaInventario {
    /**
     * Metodo principal. Se ejecuta una sola vez e inicializa el menú
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenuPrincipal();
    }
}
