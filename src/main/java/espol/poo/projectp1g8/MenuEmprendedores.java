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
            System.out.println("Menu de administracion de emprendedores");
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
                    String ruc;
                    String opcionEdit;
                    System.out.println("Editar emprendedor");
                    do{
                    System.out.println("Ingrese el RUC o cedula del emprendedor");
                    ruc = sc.nextLine();
                    if(Projectp1g8.buscarPersona(ruc) == null || !(Projectp1g8.buscarPersona(ruc) instanceof Emprendedor)){
                        System.out.println("El RUC o cedula ingresado no pertenese a ningun emprendedor registrado");
                    }
                    }while(Projectp1g8.buscarPersona(ruc) == null || !(Projectp1g8.buscarPersona(ruc) instanceof Emprendedor));
                    System.out.println("Informacion actual de " + Projectp1g8.buscarPersona(ruc).getNombre());
                    System.out.println(Projectp1g8.buscarPersona(ruc));
                    System.out.println("¿Que campo desea editar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Telefono");
                    System.out.println("3. Email");
                    System.out.println("4. Direccion");
                    System.out.println("5. Sitio Web");
                    System.out.println("6. Persona Responsable");
                    System.out.println("7. Redes Sociales");
                    System.out.println("8. Descripcion de servicios");
                    do{
                        System.out.print("Ingrese numero de opcion: ");
                        opcionEdit = sc.nextLine() + " ";
                        switch(opcionEdit.charAt(0)){
                            case '1' -> {
                                System.out.println("Ingrese el nuevo nombre");
                                String nuevoNombre = sc.nextLine();
                                Projectp1g8.buscarPersona(ruc).setNombre(nuevoNombre);
                                System.out.println("Nombre modificado con exito.");
                            }
                            case '2' -> {
                                System.out.println("Ingrese el nuevo telefono");
                                String nuevoTelefono = sc.nextLine();
                                Projectp1g8.buscarPersona(ruc).setTelefono(nuevoTelefono);
                                System.out.println("Telefono modificado con exito.");
                            }
                            case '3' -> {
                                System.out.println("Ingrese el nuevo Email");
                                String nuevoEmail = sc.nextLine();
                                Projectp1g8.buscarPersona(ruc).setEmail(nuevoEmail);
                                System.out.println("Email modificado con exito.");
                            }
                            case '4' -> {
                                System.out.println("Ingrese la nueva direccion");
                                String nuevaDir = sc.nextLine();
                                Projectp1g8.buscarPersona(ruc).setDireccion(nuevaDir);
                                System.out.println("Direccion modificada con exito.");
                            }
                            case '5' -> {
                                System.out.println("Ingrese el nuevo sitio web");
                                String nuevoSitio = sc.nextLine();
                                Projectp1g8.buscarPersona(ruc).setTelefono(nuevoSitio);
                                System.out.println("Sitio web modificado con exito.");
                            }
                            case '6' -> {
                                System.out.println("Ingrese el nombre de la nueva persona responsable");
                                String nuevoResponsable = sc.nextLine();
                                Projectp1g8.buscarPersona(ruc).setPersonaResponsable(nuevoResponsable);
                                System.out.println("Nombre de persona responsable modificado con exito.");
                            }
                            case '7' -> {
                                if(Projectp1g8.buscarPersona(ruc).getRedesSociales().isEmpty()){
                                    System.out.println("\nEste emprendedor no tiene niguna red social\n");
                                }else{
                                    System.out.println("Lista de redes sociales del emprendedor");
                                    System.out.println(Projectp1g8.buscarPersona(ruc).getRedesSociales());
                                    int ind;
                                    do{
                                        System.out.println("Escriba el nombre de la red social que de desea editar");
                                        String tipo = sc.nextLine();
                                        TipoRedSocial red = TipoRedSocial.Twitter;
                                        if (tipo.equals("Twitter")) {
                                            red = TipoRedSocial.Twitter;
                                        } else if (tipo.equals("Facebook")) {
                                            red = TipoRedSocial.Facebook;
                                        } else if (tipo.equals("Instagram")) {
                                            red = TipoRedSocial.Instagram;
                                        } else if (tipo.equals("Youtube")) {
                                            red = TipoRedSocial.Youtube;
                                        } else if (tipo.equals("TikTok")) {
                                            red = TipoRedSocial.TikTok;
                                        } else if (tipo.equals("LinkedIn")) {
                                            red = TipoRedSocial.LinkedIn;
                                        } else if (tipo.equals("Pinterest")) {
                                            red = TipoRedSocial.Pinterest;
                                        } else {}
                                        ind = Projectp1g8.buscarPersona(ruc).getRedesSociales().indexOf(new RedSocial(red,"",""));
                                        if(ind == -1){
                                            System.out.println("Por favor escriba un nombre valido");
                                        }
                                    }while(ind == -1);
                                    System.out.println("Escriba el nuevo nombre de usuario");
                                    String nuevoNombre = sc.nextLine();
                                    System.out.println("Escriba el nuevo link del usuario");
                                    String nuevoLink = sc.nextLine();
                                    Projectp1g8.buscarPersona(ruc).getRedesSociales().get(ind).setUsuario(nuevoNombre);
                                    Projectp1g8.buscarPersona(ruc).getRedesSociales().get(ind).setEnlace(nuevoLink);
                                    System.out.println("Red social modificada con exito");
                                }
                            }
                            case '8' -> {
                                Emprendedor e = (Emprendedor)Projectp1g8.buscarPersona(ruc);
                                System.out.println("Ingrese la nueva descripcion");
                                String nuevaDesc = sc.nextLine();
                                e.setDescripcionServicios(nuevaDesc);
                                System.out.println("Descripcion de servicios modificado con exito.");
                            }
                            default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 8.");
                        }
                    }while(opcionEdit.charAt(0) != '1' && opcionEdit.charAt(0) != '2' && opcionEdit.charAt(0) != '3' && opcionEdit.charAt(0) != '4' && opcionEdit.charAt(0) != '5' && opcionEdit.charAt(0) != '6' && opcionEdit.charAt(0) != '7' && opcionEdit.charAt(0) != '8');
                }
                case '3' -> // regresar al menu principal
                    System.out.println("Volviendo al menú principal.....\n");
                default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 3.");
            }
            // Código para editar emprendedor
        }while(opcion.charAt(0) != '3');
    }
}
