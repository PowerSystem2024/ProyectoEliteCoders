import java.util.ArrayList;//Para crear listas dinamicas sin tamano definido
import java.util.List;
import java.util.Scanner;

// Clase que representa un producto
class Producto {
    //Definimos los atributos de la clase
    private String nombre;
    private int stock;
    private double precio;
    // Constructor de la clase
    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }
    //Metodo para reducir el stock --------------------esto se vincula con el stock del inventario. MATIAS Y FRANCO
    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }
}

// Clase que representa un item en el carrito-----------------Esta parte tambien se vincula con el inventario. MATIAS Y FRANCO
class ItemCarrito {
    //Atributos de la clase
    private Producto producto;
    private int cantidad;

    //Constructor de la clase
    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    //Metodo para obtener el precio parcial segun la cantidad vendida
    public double getTotalParcial() {
        return producto.getPrecio() * cantidad;
    }
}

// Clase que representa el carrito de compras
class Carrito {
    //Atributos de la clase, crea una lista con los ariculos que se vayan agregando
    private List<ItemCarrito> items;

    //Constructor de la clase
    public Carrito() {
        this.items = new ArrayList<>();
    }

    //Metodo para agregar un item al carrito, invoca el metodo reducirStock y la clase ItemCarrito
    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
        producto.reducirStock(cantidad);
    }

    //Metodo para calcular el total de la compra del carrito--------------vincular con mostrar carrito MARINA
    private double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getTotalParcial();
        }
        return total;
    }
}

public class Ventas {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Producto> productos = new ArrayList<>();
    private static Carrito carrito = new Carrito();
    //Esta parte agrega 3 prductos por defecto, si quieren lo sacamos y que arranque el carrito vacio.
    public static void main(String[] args) {
        // Agregar productos de ejemplo
        productos.add(new Producto("Producto 1", 100, 10.5));
        productos.add(new Producto("Producto 2", 50, 20.0));
        productos.add(new Producto("Producto 3", 0, 15.0)); // Sin stock

        ventas();
    }

    // Método principal para gestionar las ventas del carrito
    public static void ventas() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("Ventas:");
            System.out.println("1-Cargar productos al carrito");
            System.out.println("2-Ver carrito");
            System.out.println("3-Volver al menú anterior");
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    venta();
                    break;
                case 2:
                    carrito.mostrarCarrito();//--------------------MARINA, aca tenes que agregar tu parte.
                    esperarEntrada();
                    break;
                case 3:
                    // Volver al menú principal (implementación pendiente)-----------------ALEX aca tenes que agregar tu parte del menu principal
                    break;
            }
        } while (opcion > 0 && opcion < 4);
    }

    // Método para realizar una venta
    public static void venta() {
        //Imprime lineas vacias para hacer un espacio en consola con respecto a lo ejectuado anteriormente
        limpiarPantalla();
        //Muestra el inventario pero solo el nombre, el precio y el stock de los productos disponibles
        System.out.println("Productos disponibles:");
        mostrarProductos();
        //Solicita al usuario que ingrese el nombre del producto que quiere comprar
        System.out.print("Ingrese el producto: ");
        String articulo = scanner.nextLine();
        Producto productoSeleccionado = buscarProducto(articulo);
        //Verifica la existencia del producto y la cantidad
        if (productoSeleccionado == null) {
            System.out.println("El producto ingresado no existe.");
            esperarEntrada();
            return;
        }

        System.out.print("Digite la cantidad a vender: ");
        int cantidad = obtenerCantidad();

        if (productoSeleccionado.getStock() < cantidad) {
            System.out.println("La cantidad solicitada no está disponible.");
            esperarEntrada();
            return;
        }
        //se ejectua el metodo para agregar el item al carrito
        carrito.agregarItem(productoSeleccionado, cantidad);
        System.out.println("Producto agregado al carrito.");
        esperarEntrada();
    }
    //Metodo para mostrar los productos del inventario-------------------------------------------------------Este te puede servir ALEX
    private static void mostrarProductos() {
        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                System.out.printf("%s - Stock: %d - Precio: %.2f%n",
                        producto.getNombre(), producto.getStock(), producto.getPrecio());
            }
        }
    }
    //Metodo para buscar un producto---------------------------------------------------------------Este te puede servir ALEX
    private static Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    // Método para obtener la opción del menú, verifica que la opcion ingresada sea correcta
    private static int obtenerOpcion() {
        int opcion = -1;
        while (opcion < 1 || opcion > 3) {
            System.out.print("Ingrese su opción (1-3): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        return opcion;
    }

    // Método para obtener la cantidad ingresada, verifica que el numero ingresado sea correcto.
    private static int obtenerCantidad() {
        int cantidad = -1;
        while (cantidad < 1) {
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad < 1) {
                    System.out.println("Ingrese una cantidad válida (mayor que 0).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        return cantidad;
    }

    // Método para esperar la entrada del usuario-----------------------------Esto lo pueden reutilizar en varias partes del codigo.
    private static void esperarEntrada() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    // Método para limpiar la pantalla (simulado)-----------------------------Esto es lo mas similar que encontre para limpiar la consola, si quieren lo sacamos.
    private static void limpiarPantalla() {
        // En la práctica, esto solo imprime muchas líneas en consola
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
