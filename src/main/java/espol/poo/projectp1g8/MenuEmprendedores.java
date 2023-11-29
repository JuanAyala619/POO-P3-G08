package espol.poo.projectp1g8;

import java.util.ArrayList;
import java.util.Scanner;
import espol.poo.model.*;

public class MenuEmprendedores {
    static void menu(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        System.out.println("Administracion de emprendedores");
        do{
            System.out.println("Emprendedores registrados actualmente:");
            //For para recorrer la lista de emprendedores y mostrar sus datos
            for(Emprendedor e: Projectp1g8.listaEmprendedores){
                System.out.println("Cedula/RUC: " + e.getRuc());
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Telefono: " + e.getTelefono());
                System.out.println("Mail: " + e.getEmail());
                System.out.println();
            }
            System.out.println("Menu de opciones");
            System.out.println("""
                               1. Registrar emprendedor
                               2. Editar emprendedor
                               3. Regresar""");
            System.out.print("Ingrese el numero de opcion: ");
            opcion = sc.nextLine() + " ";
            System.out.println();
            switch (opcion.charAt(0)) {
                case '1' -> {
                    // Código para registrar emprendedor
                    System.out.println("Registrar emprendedor");
                    String ruc = "";
                    //bucle para pedir de nuevo el RUC si el ingresado ya existe en el sistema.
                    do{
                        System.out.println("Ingrese cedula o RUC:");
                        ruc = sc.nextLine();
                        if(Projectp1g8.buscarPersona(ruc) != null){
                            System.out.println("El RUC o Cedula ingresado ya se encuentra registrado en el sistema, por favor, ingrese uno nuevo.");
                        }
                    }while(Projectp1g8.buscarPersona(ruc) != null);
                    System.out.println("Ingrese el nombre:");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese el teléfono:");
                    String telefono = sc.nextLine();

                    System.out.println("Ingrese el correo electrónico:");
                    String email = sc.nextLine();

                    System.out.println("Ingrese la dirección:");
                    String direccion = sc.nextLine();

                    System.out.println("Ingrese el sitio web:");
                    String sitioWeb = sc.nextLine();

                    System.out.println("Ingrese la persona responsable:");
                    String personaResponsable = sc.nextLine();

                    System.out.println("Ingrese la descripción de servicios:");
                    String descripcionServicios = sc.nextLine();
                    
                    Projectp1g8.listaEmprendedores.add(new Emprendedor(ruc, nombre, telefono, email, direccion, sitioWeb, personaResponsable, descripcionServicios));
                    
                    //Agragar una red social
                    for(TipoRedSocial t: TipoRedSocial.values()){
                        do{
                        System.out.println("Tiene cuenta de " + t +"?");
                        System.out.println("Si: 1      No: 2");
                        System.out.print("Ingrese numero de opcion: ");
                        opcion = sc.nextLine() + " ";
                        if(opcion.charAt(0) == '1'){
                            System.out.print("Ingrese nombre de usuario: ");
                            String user = sc.nextLine();
                            System.out.print("Ingrese el link de su usuario: ");
                            String enlace = sc.nextLine();
                            Projectp1g8.buscarPersona(ruc).agregarRedSocial(t.toString(), user, enlace);
                        }
                        if(opcion.charAt(0) != '1' && opcion.charAt(0) != '2'){
                            System.out.println("Opcion no valida, por favor, ingrese un numero del 1 al 2");
                        }
                        }while(opcion.charAt(0) != '1' && opcion.charAt(0) != '2');
                    }
                    
                    System.out.println("Emprendedor agregado exitosamente");
                    
                }
                case '2' -> {
                    //Codigo para editar emprendedor
                    
                }
                case '3' -> // regresar al menu principal
                    System.out.println("Volviendo al menú principal.....\n");
                default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 3.");
            }
            // Código para editar emprendedor
                    }while(opcion.charAt(0) != '3');
    }
}
