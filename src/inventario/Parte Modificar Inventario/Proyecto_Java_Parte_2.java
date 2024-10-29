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
import java.util.Scanner;

public class Proyecto_Java_Parte_2 {

    public static void main(String[] args) {
        //Inicializo scanner
        Scanner entreda= new Scanner(System.in);
        
        //Declaro la matriz y le doy un valor de 6 x 6
        String [][] inventario;
        inventario= new String[4][6];
        
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
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
                
            default:
                throw new AssertionError();
        }
        
        //Le asigno valores a cada espacio de la matriz
        inventario[0][ 0] = "Nombre";
        inventario[0 ][ 1] ="Stock";
        inventario[0][ 2] = "Precio";
        inventario[0][ 3] = "Categoria";
        inventario[0][ 4] = "Marca";
        inventario[0][ 5] = "Fecha ingreso";
        inventario[1][ 0] = "Leche";
        inventario[1][ 1] = "20";
        inventario[1][ 2] = "100";
        inventario[1][ 3] = "Almacen";
        inventario[1][ 4] = "Ilolay";
        inventario[1][ 5] = "27/05/2024";
        inventario[2][ 0] = "Arroz";
        inventario[2][ 1] = "50";
        inventario[2][ 2] = "50";
        inventario[2][ 3] = "Almacen";
        inventario[2][ 4] = "Lucia";
        inventario[2][ 5] = "27/05/2024";
        inventario[3][ 0] ="Miel";
        inventario[3][1] = "18";
        inventario[3][ 2] = "200";
        inventario[3][ 3] = "Almacen";
        inventario[3][ 4] = "La Abeja";
        inventario[3][ 5] = "27/05/2024";
        
        //Recorremos las filas de la matriz
        for (int i = 0; i < inventario.length; i++) {
            //Recorremos las columnas de la matriz
            for (int j = 0; j < inventario[i].length; j++) {
                //Imprimimimos ayudandonos del format para derle spacio a las columnas
                System.out.print(String.format("%-15s",inventario[i][j]));
                
            }
            //Espaciado
            System.out.println();
        }
        
    
    
        
    
    
    
    
    
    
    
    
    
    
    }
    public void modificarProducto(){
        //Recorremos las filas de la matriz
        for (int i = 0; i < inventario.length; i++) {
            //Recorremos las columnas de la matriz
            for (int j = 0; j < inventario[i].length; j++) {
                //Imprimimimos ayudandonos del format para derle spacio a las columnas
                System.out.print(String.format("%-15s",inventario[i][j]));
                
            }
            //Espaciado
            System.out.println();
        }
    }
    
}
