package espol.poo.projectp1g8;

import java.util.ArrayList;
import java.util.Scanner;
import espol.poo.model.*;

public class Projectp1g8 {
    public static ArrayList<Emprendedor> listaEmprendedores = new ArrayList<>();
    public static ArrayList<Auspiciante> listaAuspiciantes = new ArrayList<>();
    //public static ArrayList<Feria> listaFerias = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        System.out.println("Bienvenido al sistema de administracion de ferias");
        do{
            System.out.println("Menu Principal");
            System.out.println("1. Administracion de ferias" + "\n"
                             + "2. Administracion de emprendedores"+ "\n"
                             + "3. Sdministracion de auspiciantes" + "\n"
                             + "4. Administracion de stands" + "\n"
                             + "5. Salir");
            System.out.print("Ingrese el numero de opcion: ");
            opcion = sc.nextLine();
            System.out.println();
            
            switch (opcion.charAt(0)) {
                case '1':
                    // Código para la Administracion de ferias
                    MenuFerias.menu();
                    break;
                case '2':
                    // Código para la Administracion de emprendedores
                    MenuEmprendedores.menu();
                    break;
                case '3':
                    // Código para la Administracion de auspiciantes
                    MenuAuspiciantes.menu();
                    break;
                case '4':
                    // Código para la Administracion de stands
                    MenuStands.menu();
                    break;
                case '5':
                    // Salir del bucle
                    System.out.println("Saliendo del sistema de administracion de ferias.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 5.");
            }
        }while(opcion.charAt(0) != '5');
        System.out.println("Gracias por usar el programa.");
        sc.close();
    }
    
    public static void agragarEmprendedores(){
        listaEmprendedores.add(new Emprendedor("1798285937001", "Tienda de Pepe", "0948652474", "tpepe@gmail.com", "Urbanización Los Dos Caminos", "www.tiendapepe.com.ec", "Pepe", "Venta de articulos varios"));
        listaEmprendedores.add(new Emprendedor("1156183215484", "Super Papeleria", "0995685471", "superpapeleria@gmail.com", "San Marcos, A, El Matacho", "www.superpapel.com.ec", "Maria", "Venta de articulos escolares"));
        listaEmprendedores.add(new Emprendedor("1745865631877", "Pasteles del chino", "0985632685", "pasteleschino@gmail.com", "Centro Comercial Ctro Com Euro, Piso PB, Local 6-7-8-9", "www.pasteles.com.ec", "El Chino", "Venta de pasteles"));
        listaEmprendedores.add(new Emprendedor("1456852584174", "Tacos don Jose", "0958714526", "tacostacos@gmail.com", "Cl. 20 Y 21, CC El Gran Muro, 2", "www.tacostacos.com.ec", "Jose", "Venta de tacos"));
    }
    
    public static void agragarAuspiciantes(){
        listaAuspiciantes.add(new Auspiciante("1234567891237","Auspiciante S.A.","987654321","correoauspiciante@ejemplo.com","Calle Principal 123","www.auspiciante.com", "Juan Perez"));
    }
    
    public static void agragarFerias(){
        
    }
    
}
