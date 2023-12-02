package espol.poo.app;

import java.util.Scanner;

import espol.poo.models.*;

public class MenuFerias {
    static void menu(Scanner sc) {
        String opcion;
        System.out.println("Administracion de Feria");
        do {
            System.out.println("Ferias registradas:");
            for (Feria feria : App.listaFerias) {
                System.out.println("Codigo: " + feria.getCodigo());
                System.out.println("Nombre: " + feria.getNombre());
                System.out.println("Fecha de Inicio: " + feria.getFechaInicio());
                System.out.println("Lugar: " + feria.getLugar());
                System.out.println("Cantidad de Auspiciantes: " + feria.getAuspiciantes().size());
            }
            System.out.println("Menu de Opciones:");
            System.out.println("""
                    1. Ver informacion de feria
                    2. Registrar feria
                    3. Editar feria
                    4. Consultar emprendedores en feria
                    5. Regresar
                    """);
            System.out.println("Ingrese el numero de opcion:");
            opcion = sc.nextLine();
            switch (opcion.charAt(0)) {
                case '1':
                    informacionFeria(sc);
                    break;

                case '2':
                    registrarFeria(sc);
                    break;

                case '3':
                    editarFeria(sc);
                    break;

                case '4':

                    break;

                case '5':
                    break;

                default:
                    System.out.println("Opcion no valida, por favor, ingrese un numero del 1 al 2");
                    break;
            }
        } while (opcion.charAt(0) != '5');
        System.out.println("Regresando al menú principal");
    }

    private static void informacionFeria(Scanner sc) {
        System.out.println("Ingrese codigo de Feria");
        int codigo = sc.nextInt();
        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);
        if (feria != null) {

            System.out.println("Nombre: " + feria.getNombre());
            System.out.println("Lugar: " + feria.getLugar());
            System.out.println("Fecha de Inicio:" + feria.getFechaInicio());
            System.out.println("Feha de Fin:" + feria.getFechaFin());
            System.out.println("Horario:" + feria.getHorario());
            System.out.println("Lista de Auspiciantes:");
            for (AuspicianteEnFeria auspicianteEnFeria : feria.getAuspiciantes()) {
                System.out.println(auspicianteEnFeria.getAuspiciante().getNombre());
            }
            System.out.println("Cantidad de Stands en cada Seccion:");
            for (Seccion seccion : feria.getSecciones()) {
                System.out.println("Seccion" + seccion.getId() + ": " + seccion.getLstStands().size());
            }
        } else {
            System.out.println("No existe una feria con ese codigo");
        }

    }

    private static void registrarFeria(Scanner sc) {
        System.out.println("Ingrese los siguientes datos");

        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Descripcion");
        String descripcion = sc.nextLine();
        System.out.println("Lugar");
        String lugar = sc.nextLine();
        System.out.println("Fecha de Inicio");
        String fechaInicio = sc.nextLine();
        System.out.println("Fecha de Fin");
        String fechaFin = sc.nextLine();
        System.out.println("Horario");
        String horario = sc.nextLine();

        App.listaFerias.add(new Feria(nombre, descripcion, lugar, fechaInicio, fechaFin, horario));
    }

    private static void editarFeria(Scanner sc) {
        int codigo;
        String opcionEdit;
        System.out.println("\nEditar Auspiciante:\n");
        do {
            System.out.println("Ingrese el codigo de la feria");
            codigo = sc.nextInt();
            if (Feria.buscarFeria(codigo, App.listaFerias) == null) {
                System.out.println("El RUC o cedula ingresado no pertenese a ningun auspiciante registrado");
            }
        } while (Feria.buscarFeria(codigo, App.listaFerias) == null);
        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);
        System.out.println("Informacion actual de la feria");
        System.out.println(App.buscarPersona(ruc));
        System.out.println("¿Que campo desea editar?");
        System.out.println("1. Nombre");
        System.out.println("2. Telefono");
        System.out.println("3. Email");
        System.out.println("4. Direccion");
        System.out.println("5. Sitio Web");
        System.out.println("6. Persona Responsable");
        System.out.println("7. Redes Sociales");
        System.out.println("8. Lista de Sectores");
        System.out.println("9. Volver a Menu Auspiciantes");

        do {
            System.out.print("Ingrese numero de opcion: ");
            opcionEdit = sc.nextLine() + " ";
            switch (opcionEdit.charAt(0)) {
                case '1' -> {
                    System.out.println("Ingrese el nuevo nombre");
                    String nuevoNombre = sc.nextLine();
                    App.buscarPersona(ruc).setNombre(nuevoNombre);
                    System.out.println("Nombre modificado con exito.");
                }
                case '2' -> {
                    System.out.println("Ingrese el nuevo telefono");
                    String nuevoTelefono = sc.nextLine();
                    App.buscarPersona(ruc).setTelefono(nuevoTelefono);
                    System.out.println("Telefono modificado con exito.");
                }
                case '3' -> {
                    System.out.println("Ingrese el nuevo Email");
                    String nuevoEmail = sc.nextLine();
                    App.buscarPersona(ruc).setEmail(nuevoEmail);
                    System.out.println("Email modificado con exito.");
                }
                case '4' -> {
                    System.out.println("Ingrese la nueva direccion");
                    String nuevaDir = sc.nextLine();
                    App.buscarPersona(ruc).setDireccion(nuevaDir);
                    System.out.println("Direccion modificada con exito.");
                }
                case '5' -> {
                    System.out.println("Ingrese el nuevo sitio web");
                    String nuevoSitio = sc.nextLine();
                    App.buscarPersona(ruc).setTelefono(nuevoSitio);
                    System.out.println("Sitio web modificado con exito.");
                }
                case '6' -> {
                    System.out.println("Ingrese el nombre de la nueva persona responsable");
                    String nuevoResponsable = sc.nextLine();
                    App.buscarPersona(ruc).setPersonaResponsable(nuevoResponsable);
                    System.out.println("Nombre de persona responsable modificado con exito.");
                }
                case '7' -> {
                    if (App.buscarPersona(ruc).getRedesSociales().isEmpty()) {
                        System.out.println("\nEste emprendedor no tiene niguna red social\n");
                    } else {
                        System.out.println("Lista de redes sociales del auspiciante");
                        System.out.println(App.buscarPersona(ruc).getRedesSociales());
                        int ind;
                        do {
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
                            } else {
                            }
                            ind = App.buscarPersona(ruc).getRedesSociales().indexOf(new RedSocial(red, "", ""));
                            if (ind == -1) {
                                System.out.println("Por favor escriba un nombre valido");
                            }
                        } while (ind == -1);
                        System.out.println("Escriba el nuevo nombre de usuario");
                        String nuevoNombre = sc.nextLine();
                        System.out.println("Escriba el nuevo link del usuario");
                        String nuevoLink = sc.nextLine();
                        App.buscarPersona(ruc).getRedesSociales().get(ind).setUsuario(nuevoNombre);
                        App.buscarPersona(ruc).getRedesSociales().get(ind).setEnlace(nuevoLink);
                        System.out.println("Red social modificada con exito");
                    }
                }
                case '8' -> {
                    Auspiciante a = (Auspiciante) App.buscarPersona(ruc);
                    a.borrarSectores();
                    System.out.println(
                            "Se ha borrado la lista de sectores del auspiciante, por favor ingrese nuevamente los sectores: ");
                    int n_sector = 0;
                    String opcion = "";
                    do {
                        System.out.println("\nMenu de Opciones: ");
                        System.out.println("1. Añadir Sector" + "\n"
                                + "2. Terminar de añadir sectores");
                        System.out.print("Ingrese el numero de opcion: ");
                        opcion = sc.nextLine();

                        switch (opcion.charAt(0)) {
                            case '1' -> {
                                System.out.println("\nLos sectores disponibles son: ");
                                System.out.println("1. Alimentacion" + "\n"
                                        + "2. Educacion" + "\n"
                                        + "3. Salud" + "\n"
                                        + "4. Vestimenta");
                                System.out.println("Ingrese el número de sector a añadir:");
                                n_sector = sc.nextInt();
                                sc.nextLine();
                                if (n_sector > 4 || n_sector < 0) {
                                    System.out.println("Número de sector inválido. Regresando......");
                                } else {
                                    a.agregarSectores(n_sector);
                                }
                            }
                            case '2' -> {
                                if (a.getLstTipoSectores().isEmpty()) {
                                    System.out.println(
                                            "El auspiciante no tiene asignado ningún sector porfavor asigne al menos uno.....");
                                } else {
                                    System.out.println("Registro de sectores finalizado.....");
                                }
                            }
                            default ->
                                System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 2.");
                        }
                    } while (opcion.charAt(0) != '2' || a.getLstTipoSectores().isEmpty());
                }
                case '9' -> {
                    System.out.println("Volviendo al menú de auspiciantes.....\n");
                }
                default ->
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 9.");
            }
        } while (opcionEdit.charAt(0) != '9');
    }

}
