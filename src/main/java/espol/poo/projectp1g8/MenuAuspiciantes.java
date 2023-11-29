package espol.poo.projectp1g8;
import espol.poo.model.*;
import espol.poo.model.*;
import java.util.Scanner;

public class MenuAuspiciantes {
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Auspiciantes registrados: ");
        for (Auspiciante a: Projectp1g8.listaAuspiciantes){
            System.out.println(a.getRuc());
            System.out.println(a.getNombre());
            System.out.println(a.getTelefono());
            System.out.println(a.getEmail());
            System.out.println(a.getDireccion());
            System.out.println(a.getSitioWeb());
            System.out.println(a.getPersonaResponsable());
            System.out.println(a.getLstTipoSectores());
            System.out.println();
        }
        
        String opcion = "";
        do{
        System.out.println("\nMenu de Opciones: ");
        System.out.println("1. Registrar Auspciiante" + "\n"
                             + "2. Editar Auspiciante"+ "\n"
                             + "3. Asignar Auspiciante a Feria" + "\n"
                             + "4. Regresar");
        
            System.out.print("Ingrese el numero de opcion: ");
            opcion = sc.nextLine();
            System.out.println();
            
            switch (opcion.charAt(0)) {
                case '1':
                    // Código para Registrar Auspiciantes
                    registrarAuspiciante();
                    break;
                case '2':
                    // Código para Editar Auspiciantes
                    editarAuspiciante();
                    break;
                case '3':
                    // Código para Asignar un Auspiciante a Feria
                    asignarAuspiciante();
                    break;
                case '4':
                    // Salir del bucle
                    System.out.println("Saliendo deL Menú de Auspiciantes....");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 5.");
            }
        }while(opcion.charAt(0) != '4');
        System.out.println("Volviendo al menú principal.....\n");
    }
    
    static void registrarAuspiciante(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ruc del auspiciante: ");
        String ruc = sc.nextLine();
        sc.next();
        System.out.println("Ingrese el nombre del auspiciante: ");
        String nombre = sc.nextLine();
        sc.next();
        System.out.println("Ingrese el telefono del auspiciante: ");
        String telefono = sc.nextLine();
        sc.next();
        System.out.println("Ingrese el email del auspiciante: ");
        String email = sc.nextLine();
        sc.next();
        System.out.println("Ingrese la direccion del auspiciante: ");
        String direccion = sc.nextLine();
        sc.next();
        System.out.println("Ingrese el sitio web del auspiciante: ");
        String sitio_web = sc.nextLine();
        sc.next();
        System.out.println("Ingrese el nombre de la persona responsable: ");
        String p_responsable = sc.nextLine();
        sc.next();
        
    }
    static void editarAuspiciante(){
        
    }
    static void asignarAuspiciante(){
        
    }
}
