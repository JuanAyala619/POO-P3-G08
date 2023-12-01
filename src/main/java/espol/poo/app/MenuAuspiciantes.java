package espol.poo.app;

import espol.poo.models.*;
import java.util.Scanner;

public class MenuAuspiciantes {

    static void menu() {
        Scanner sc = new Scanner(System.in);

        String opcion = "";
        do {
            System.out.println("Auspiciantes registrados: ");
            for (Auspiciante a : App.listaAuspiciantes) {
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

            System.out.println("\nMenu de Opciones: ");
            System.out.println("1. Registrar Auspiciante" + "\n"
                    + "2. Editar Auspiciante" + "\n"
                    + "3. Asignar Auspiciante a Feria" + "\n"
                    + "4. Regresar");

            System.out.print("Ingrese el numero de opcion: ");
            opcion = sc.nextLine();
            System.out.println();

            switch (opcion.charAt(0)) {
                case '1':
                    // Código para Registrar Auspiciantes
                    registrarAuspiciante(sc);
                    break;
                case '2':
                    // Código para Editar Auspiciantes
                    editarAuspiciante(sc);
                    break;
                case '3':
                    // Código para Asignar un Auspiciante a Feria
                    asignarAuspiciante(sc);
                    break;
                case '4':
                    // Salir del bucle
                    System.out.println("Saliendo deL Menú de Auspiciantes....");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 5.");
            }
        } while (opcion.charAt(0) != '4');
        System.out.println("Volviendo al menú principal.....\n");
        sc.close();
    }

    static void registrarAuspiciante(Scanner sc) {
        System.out.println("\nRegistrar Auspiciante:");
        System.out.println("Ingrese el ruc del auspiciante: ");
        String ruc = sc.nextLine();
        System.out.println("Ingrese el nombre del auspiciante: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el telefono del auspiciante: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese el email del auspiciante: ");
        String email = sc.nextLine();
        System.out.println("Ingrese la direccion del auspiciante: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el sitio web del auspiciante: ");
        String sitio_web = sc.nextLine();
        System.out.println("Ingrese el nombre de la persona responsable: ");
        String p_responsable = sc.nextLine();
        boolean condicion = false;
        for (Auspiciante a : App.listaAuspiciantes) {//valida que no exista algun ruc repetido
            if (a.getRuc() == ruc) {
                condicion = true;
            }
        }
        if (condicion == true || ruc.isBlank()) {//valida que el ruc no se repita en auspiciantes y que no esté vacío
            System.out.println("Ya existe alguien registrado con el mismo ruc o no es un ruc válido.... ");
        } else {
            Auspiciante a = new Auspiciante(ruc, nombre, telefono, email, direccion, sitio_web, p_responsable);
            String opcion = "";
            int n_sector = 0;
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
                            System.out.println("El auspiciante no tiene asignado ningún sector porfavor asigne al menos uno.....");
                        } else {
                            System.out.println("Registro de sectores finalizado.....");
                        }
                    }
                    default ->
                        System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 2.");
                }
            } while (opcion.charAt(0) != '2' || a.getLstTipoSectores().isEmpty());

            //Agragar una red social
            for (TipoRedSocial t : TipoRedSocial.values()) {
                do {
                    System.out.println("\nTiene cuenta de " + t + "?");
                    System.out.println("Si: 1      No: 2");
                    System.out.print("Ingrese numero de opcion: ");
                    opcion = sc.nextLine() + " ";
                    if (opcion.charAt(0) == '1') {
                        System.out.print("Ingrese nombre de usuario: ");
                        String user = sc.nextLine();
                        System.out.print("Ingrese el link de su usuario: ");
                        String enlace = sc.nextLine();
                        a.agregarRedSocial(t.toString(), user, enlace);
                    }
                    if (opcion.charAt(0) != '1' && opcion.charAt(0) != '2') {
                        System.out.println("Opcion no valida, por favor, ingrese un numero del 1 al 2");
                    }
                } while (opcion.charAt(0) != '1' && opcion.charAt(0) != '2');
            }
            App.listaAuspiciantes.add(a);
            System.out.println("Auspiciante agregado correctamente.....\n");
            System.out.println("Volviendo al menú auspiciantes.....\n");
            sc.close();
        }
    }

    static void editarAuspiciante(Scanner sc) {
        String ruc;
        String opcionEdit;
        System.out.println("\nEditar Auspiciante:\n");
        do {
            System.out.println("Ingrese el RUC o cedula del auspiciante");
            ruc = sc.nextLine();
            if (App.buscarPersona(ruc) == null || !(App.buscarPersona(ruc) instanceof Auspiciante)) {
                System.out.println("El RUC o cedula ingresado no pertenese a ningun auspiciante registrado");
            }
        } while (App.buscarPersona(ruc) == null || !(App.buscarPersona(ruc) instanceof Auspiciante));
        System.out.println("Informacion actual de " + App.buscarPersona(ruc).getNombre());
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
                    System.out.println("Se ha borrado la lista de sectores del auspiciante, por favor ingrese nuevamente los sectores: ");
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
                                    System.out.println("El auspiciante no tiene asignado ningún sector porfavor asigne al menos uno.....");
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

    static void asignarAuspiciante(Scanner sc) {

        System.out.println("Auspiciantes registrados: ");
        for (Auspiciante a : App.listaAuspiciantes) {
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

        int cod_feria;
        String ruc;
        String desc;
        String opcion;
        System.out.println("\nAsignar Auspiciante:\n");
        do {
            System.out.println("Ingrese el código de la feria");
            cod_feria = sc.nextInt();
            sc.nextLine();
            if (App.buscarFeria(cod_feria) == null) {
                System.out.println("El codigo de feria ingresado no pertenese a ninguna feria registrada");
            }
        } while (App.buscarFeria(cod_feria) == null);

        do {
            System.out.println("Ingrese el RUC o cedula del auspiciante a asignar: ");
            ruc = sc.nextLine();
            if (App.buscarPersona(ruc) == null || !(App.buscarPersona(ruc) instanceof Auspiciante)) {
                System.out.println("El RUC o cedula ingresado no pertenese a ningun auspiciante registrado");
            }
        } while (App.buscarPersona(ruc) == null || !(App.buscarPersona(ruc) instanceof Auspiciante));

        System.out.println("Ingrese la descripción de lo que cubre el auspicio: ");
        desc = sc.nextLine();
        Auspiciante a = (Auspiciante) App.buscarPersona(ruc);
        do {
            System.out.println("\nIncluye Stand en la feria: ");
            System.out.println("1. Si" + "\n"
                    + "2. No");
            System.out.print("Ingrese el numero de opcion: ");
            opcion = sc.nextLine();

            switch (opcion.charAt(0)) {
                case '1' -> {
                    App.buscarFeria(cod_feria).asignarAuspiciante(a, desc, true);

                }
                case '2' -> {
                    App.buscarFeria(cod_feria).asignarAuspiciante(a, desc, false);
                }
                default ->
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 2.");
            }
        }while (opcion.charAt(0) != '2');
        System.out.println("Auspiciante agregado correctamente");
        System.out.println("Volviendo al menú de auspiciantes.....\n");
    }
}
