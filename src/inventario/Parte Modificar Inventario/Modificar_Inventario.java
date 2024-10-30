/*
 Segunda Parte Divicion Exel
    b)Modificar Inventario	
    1-Que producto quiere modificar?	
    2-Que producto quiere eliminar?	
    3-Quiere agregar un producto?	
    4-Volver	
 */
package proyecto_java_parte_2;
/**
 * @author matis
 */
import java.security.Principal;
import java.util.Scanner;

public class Modificar_Inventario  {

    public static void main(String[] args) {
        //Inicializo scanner
        Scanner entreda= new Scanner(System.in);
       
        
        //Ofresemos al usuario opciones
        System.out.println("1.¿Qué producto quiere modificar?");
        System.out.println("2.¿Qué producto quiere eliminar");
        System.out.println("3.¿Quiere agregar un producto?");
        System.out.println("4.¿Qué producto quiere modificar?");
        
        //Le pedimos al usuario que digite una opcion
        System.out.print("Digita una Opcion: ");
        int opcion=entreda.nextInt();
       
        
        
        //Segun la opcion que digite entrara en una opcion
        
        switch (opcion) {
            case 1:
                //Llamamos a la clase ModificarProducto y accedemos a su metodo
                ModificarProducto modificarProducto= new ModificarProducto();
                modificarProducto.modificarInventario();
                break;
            
            case 2:
                //Fran:)
                break;
            case 3:
                
                break;
            case 4:
                
                break;
                
            default:
                throw new AssertionError();
        }
    
    }
public static class MatrizInventario{
        //Declaro la matriz y le doy un valor de 6 x 6
        private String [][] inventario;
        
        //Creamos un metodo para la matriz
        public MatrizInventario(){
            
        //Definimos la matris
        inventario= new String[4][6];
        
        //Le asigno valores a cada espacio de la matriz
        inventario[0][ 0] = "Nombre";
        inventario[0 ][ 1] ="Stock";
        inventario[0][ 2] = "Precio";
        inventario[0][ 3] = "Categoria";
        inventario[0][ 4] = "Marca";
        inventario[0][ 5] = "Año ingreso";
        inventario[1][ 0] = "Leche";
        inventario[1][ 1] = "20";
        inventario[1][ 2] = "100";
        inventario[1][ 3] = "Almacen";
        inventario[1][ 4] = "Ilolay";
        inventario[1][ 5] = "2022";
        inventario[2][ 0] = "Arroz";
        inventario[2][ 1] = "50";
        inventario[2][ 2] = "50";
        inventario[2][ 3] = "Almacen";
        inventario[2][ 4] = "Lucia";
        inventario[2][ 5] = "2023";
        inventario[3][ 0] ="Miel";
        inventario[3][1] = "18";
        inventario[3][ 2] = "200";
        inventario[3][ 3] = "Almacen";
        inventario[3][ 4] = "La Abeja";
        inventario[3][ 5] = "2021";
        
    }

    //Metodo para obtener matriz
    public String[][] getMatriz(){
       return  inventario;
        
    }
        
    public void ImprimirInventario(){
        
        
        //Recorremos las filas de la matriz
        for (int i = 0; i < inventario.length; i++) {
            //Recorremos las columnas de la matriz
            for (int j = 0; j < inventario[i].length; j++) {
                //Imprimimimos ayudandonos del format para derle spacio a las columnas
                System.out.print(String.format("%-12s",inventario[i][j]));
                
            }
            //Espaciado
            System.out.println();
        }
        
        
    }
        
}
public static class ModificarProducto {
    
    public void modificarInventario(){
        //Llamamos a la clase MatrizInventario y accedemos al metodo matriz para imprimir la matriz completa
        MatrizInventario matrizInventario=new MatrizInventario();
        //Imprimimos la matriz
        matrizInventario.ImprimirInventario();
        
        //Inicializo los scanner a utilizar
        //Para entrar en alguna opcion de Modificar inventario
        Scanner entredaOpcionInventario= new Scanner(System.in);
        
        //Para selicionar el producto de la matriz
        Scanner entraModifiArticu= new Scanner(System.in);
        
        //Para modificar el nombre del producto de la matriz
        Scanner entradaModificarNombre= new Scanner(System.in);
        
        //Para modificar el Stock del producto de la matriz
        Scanner entradaModificarStock=new Scanner(System.in);
        
        //Para modificar el Precio del producto de la matriz
        Scanner entradaModificarPrecio=new Scanner(System.in);
        
        //Para modificar el Categoria del producto de la matriz
        Scanner entradaModificarCatego=new Scanner(System.in);
        
        //Para modificar el Marca del producto de la matriz
        Scanner entradaModificarMarca=new Scanner(System.in);
        
        //Para modificar el fecha del producto de la matriz
        Scanner entradaModificarAño=new Scanner(System.in);
        
        //Cramos las variables para que si les cambio el nombre no cree error
        String leche= "Leche";
        String arroz= "Arroz";
        String miel= "Miel";
        
        //Entramos en el bucle while para un mejor manejo de opciones
        while (true) {            
            //Le pregunatamos que producto quiere modificar
            System.out.print("Digita el nombre del producto a modificar?(Digite <Salir> para Salir) : ");
            String opciModifiInventario=entredaOpcionInventario.nextLine();
            
            //Entramos en un condicional segun lo que digite en opciModifiInventario
            
            if (opciModifiInventario.equals(leche) ) {
              
                //Creamos un while para poder manejar de mejor manera las opciones
                while (true) {
                    
                    //Presentamos las opciones
                    System.out.println("0-Nombre");
                    System.out.println("1-Stoc");
                    System.out.println("2-Precio");
                    System.out.println("3-Categoria");
                    System.out.println("4-Marca");
                    System.out.println("5-Año de Ingreso");
                    System.out.println("6-SALIR");
                    
                    //Preguntamos que opcion quiere digitar 
                    System.out.print("Que item de ese articulo desea modificar? : ");
                    int modifiArti=entraModifiArticu.nextInt();
                    
                    //Entramos en un condicional segun la opcion digitada
                    if (modifiArti==0) {
                        
                        
                        //Modificamos el nombre en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el nombre para modificar
                                System.out.print("Que nuevo nombre quieres ponerle? : ");
                                String modifiNombre=entradaModificarNombre.nextLine();
                                
                                matrizInventario.getMatriz()[i][0]=modifiNombre;
                                leche=modifiNombre;
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                        
                    }
                    else if (modifiArti==1) {
                        //Modificamos el stock en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el stock para modificar
                                System.out.print("Digita el Stock deseado : ");
                                int modifiStock=entradaModificarStock.nextInt();
                                
                                matrizInventario.getMatriz()[i][1]=String.valueOf(modifiStock);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==2) {
                        //Modificamos el precio en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Precio para modificar
                                System.out.print("Digita el Precio deseado : ");
                                int modifiPrecio=entradaModificarPrecio.nextInt();
                                
                                matrizInventario.getMatriz()[i][2]=String.valueOf(modifiPrecio);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==3) {
                        //Modificamos el categoria en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Categoria para modificar
                                System.out.print("Que Categoria quieres ponerle? : ");
                                String modifiCategoria=entradaModificarCatego.nextLine();
                                
                                matrizInventario.getMatriz()[i][3]=modifiCategoria;
                               
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==4) {
                        //Modificamos el Marca en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Marca para modificar
                                System.out.print("Que Marca quieres ponerle? : ");
                                String modifiMarca=entradaModificarMarca.nextLine();
                                
                                matrizInventario.getMatriz()[i][4]=modifiMarca;
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==5) {
                        //Modificamos el fecha en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el fecha para modificar
                                System.out.print("Digita la fecha deseado : ");
                                int modifiFecha=entradaModificarAño.nextInt();
                                
                                matrizInventario.getMatriz()[i][5]=String.valueOf(modifiFecha);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==6) {
                        break;
                    }
                    //Si digita mal
                    else{
                        System.out.println("El numero ingresado no existe, digite nuevamente");
                    }
                    
                }
                
                
                
                
            }
            else if (opciModifiInventario.equals(arroz)) {
                //Creamos un while para poder manejar de mejor manera las opciones
                while (true) {
                    
                    //Presentamos las opciones
                    System.out.println("0-Nombre");
                    System.out.println("1-Stoc");
                    System.out.println("2-Precio");
                    System.out.println("3-Categoria");
                    System.out.println("4-Marca");
                    System.out.println("5-Año de Ingreso");
                    System.out.println("6-SALIR");
                    
                    //Preguntamos que opcion quiere digitar 
                    System.out.print("Que item de ese articulo desea modificar? : ");
                    int modifiArti=entraModifiArticu.nextInt();
                    
                    //Entramos en un condicional segun la opcion digitada
                    if (modifiArti==0) {
                        
                        
                        //Modificamos el nombre en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el nombre para modificar
                                System.out.print("Que nuevo nombre quieres ponerle? : ");
                                String modifiNombre=entradaModificarNombre.nextLine();
                                
                                matrizInventario.getMatriz()[i][0]=modifiNombre;
                                leche=modifiNombre;
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                        
                    }
                    else if (modifiArti==1) {
                        //Modificamos el stock en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el stock para modificar
                                System.out.print("Digita el Stock deseado : ");
                                int modifiStock=entradaModificarStock.nextInt();
                                
                                matrizInventario.getMatriz()[i][1]=String.valueOf(modifiStock);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==2) {
                        //Modificamos el precio en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Precio para modificar
                                System.out.print("Digita el Precio deseado : ");
                                int modifiPrecio=entradaModificarPrecio.nextInt();
                                
                                matrizInventario.getMatriz()[i][2]=String.valueOf(modifiPrecio);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==3) {
                        //Modificamos el categoria en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Categoria para modificar
                                System.out.print("Que Categoria quieres ponerle? : ");
                                String modifiCategoria=entradaModificarCatego.nextLine();
                                
                                matrizInventario.getMatriz()[i][3]=modifiCategoria;
                               
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==4) {
                        //Modificamos el Marca en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Marca para modificar
                                System.out.print("Que Marca quieres ponerle? : ");
                                String modifiMarca=entradaModificarMarca.nextLine();
                                
                                matrizInventario.getMatriz()[i][4]=modifiMarca;
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==5) {
                        //Modificamos el fecha en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el fecha para modificar
                                System.out.print("Digita la fecha deseado : ");
                                int modifiFecha=entradaModificarAño.nextInt();
                                
                                matrizInventario.getMatriz()[i][5]=String.valueOf(modifiFecha);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==6) {
                        break;
                    }
                    //Si digita mal
                    else{
                        System.out.println("El numero ingresado no existe, digite nuevamente");
                    }
                }
            }
                
            else if (opciModifiInventario.equals(miel)) {
                
                //Creamos un while para poder manejar de mejor manera las opciones
                while (true) {
                    
                    //Presentamos las opciones
                    System.out.println("0-Nombre");
                    System.out.println("1-Stoc");
                    System.out.println("2-Precio");
                    System.out.println("3-Categoria");
                    System.out.println("4-Marca");
                    System.out.println("5-Año de Ingreso");
                    System.out.println("6-SALIR");
                    
                    //Preguntamos que opcion quiere digitar 
                    System.out.print("Que item de ese articulo desea modificar? : ");
                    int modifiArti=entraModifiArticu.nextInt();
                    
                    //Entramos en un condicional segun la opcion digitada
                   
                    if (modifiArti==0) {
                        
                        
                        //Modificamos el nombre en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el nombre para modificar
                                System.out.print("Que nuevo nombre quieres ponerle? : ");
                                String modifiNombre=entradaModificarNombre.nextLine();
                                
                                matrizInventario.getMatriz()[i][0]=modifiNombre;
                                leche=modifiNombre;
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                        
                    }
                    else if (modifiArti==1) {
                        //Modificamos el stock en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el stock para modificar
                                System.out.print("Digita el Stock deseado : ");
                                int modifiStock=entradaModificarStock.nextInt();
                                
                                matrizInventario.getMatriz()[i][1]=String.valueOf(modifiStock);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==2) {
                        //Modificamos el precio en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Precio para modificar
                                System.out.print("Digita el Precio deseado : ");
                                int modifiPrecio=entradaModificarPrecio.nextInt();
                                
                                matrizInventario.getMatriz()[i][2]=String.valueOf(modifiPrecio);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==3) {
                        //Modificamos el categoria en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Categoria para modificar
                                System.out.print("Que Categoria quieres ponerle? : ");
                                String modifiCategoria=entradaModificarCatego.nextLine();
                                
                                matrizInventario.getMatriz()[i][3]=modifiCategoria;
                               
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==4) {
                        //Modificamos el Marca en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el Marca para modificar
                                System.out.print("Que Marca quieres ponerle? : ");
                                String modifiMarca=entradaModificarMarca.nextLine();
                                
                                matrizInventario.getMatriz()[i][4]=modifiMarca;
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==5) {
                        //Modificamos el fecha en la matriz entrando en un for
                        for (int i = 0; i < matrizInventario.getMatriz().length; i++) {
                            if (matrizInventario.getMatriz()[i][0].equals(opciModifiInventario)) {
                                
                                //Igualamos el valor ingrsado en el lugar que se quiere modificar
                                //Preguntamos el fecha para modificar
                                System.out.print("Digita la fecha deseado : ");
                                int modifiFecha=entradaModificarAño.nextInt();
                                
                                matrizInventario.getMatriz()[i][5]=String.valueOf(modifiFecha);
                                
                                //Imprimimos la matriz
                                matrizInventario.ImprimirInventario();
                                //Producto modificado correctamente
                                System.out.println("Producto modificado correctamente");
                                
                                
                            }
                        }
                    }
                    else if (modifiArti==6) {
                        break;
                    }
                    //Si digita mal
                    else{
                        System.out.println("El numero ingresado no existe, digite nuevamente");
                    }
                }     
            }
            //Para salir al menu 
            else if (opciModifiInventario.equals("Salir")) {
                //Nos vamos al menu principal 
                Modificar_Inventario modificar_Inventario= new Modificar_Inventario();
                String[] args = null;
                
                modificar_Inventario.main(args);
                break;
            }
            //Si digita mal
            else{
                System.out.println("El articulo ingresado no existe, digite nuevamente");
            }
            
        }
        
        
        
      
    }
    
        
        
}
    
    
}
