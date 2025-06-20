package espol.poo.app;

import java.util.Scanner;
import espol.poo.models.*;

public class MenuEmprendedores implements InterfaceMenu{
    @Override
    public void menu(Scanner sc) {
        String opcion; // Guarda la opcion del menu
        System.out.println("\nADMINISTRACION DE EMPRENDEDORES");
        // Blucle del menu
        do {
            System.out.println("\nEmprendedores registrados actualmente:");
            // For para recorrer la lista de emprendedores y mostrar sus datos
            for (Emprendedor e : App.listaEmprendedores) {
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
            System.out.print("\nIngrese el numero de opcion: ");
            opcion = sc.nextLine() + " ";
            System.out.println();

            switch (opcion.charAt(0)) {
                case '1' -> registrarEmprendedor(sc);

                case '2' -> editarEmprendedor(sc);

                case '3' -> // regresar al menu principal
                    System.out.println("Volviendo al menú principal.....\n");

                default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 3.");
            }
        } while (opcion.charAt(0) != '3');
    }

    private static void registrarEmprendedor(Scanner sc) {
        // Código para registrar emprendedor
        String opcion; // Guarda la opcion del menu
        System.out.println("Registrar emprendedor");
        String ruc = "";
        // bucle para pedir de nuevo el RUC si el ingresado ya existe en el sistema.
        do {
            System.out.println("Ingrese cedula o RUC:");
            ruc = sc.nextLine();
            if (App.buscarPersona(ruc) != null) {
                System.out.println(
                        "El RUC o Cedula ingresado ya se encuentra registrado en el sistema, por favor, ingrese uno nuevo.");
            }
            if ("".equals(ruc)) {
                System.out.println("Este campo no puede quedar vacio");
            }
        } while (App.buscarPersona(ruc) != null || "".equals(ruc));

        String nombre;
        do {
            System.out.println("Ingrese el nombre:");
            nombre = sc.nextLine();
            if ("".equals(nombre))
                System.out.println("Este campo no puede quedar vacio");
        } while ("".equals(nombre));

        String telefono;
        do {
            System.out.println("Ingrese el teléfono:");
            telefono = sc.nextLine();
            if ("".equals(telefono))
                System.out.println("Este campo no puede quedar vacio");
        } while ("".equals(telefono));

        String email;
        do {
            System.out.println("Ingrese el correo electrónico:");
            email = sc.nextLine();
            if ("".equals(email))
                System.out.println("Este campo no puede quedar vacio");
        } while ("".equals(email));

        System.out.println("Ingrese la dirección:");
        String direccion = sc.nextLine();

        System.out.println("Ingrese el sitio web:");
        String sitioWeb = sc.nextLine();

        String personaResponsable;
        do {
            System.out.println("Ingrese la persona responsable:");
            personaResponsable = sc.nextLine();
            if ("".equals(personaResponsable))
                System.out.println("Este campo no puede quedar vacio");
        } while ("".equals(personaResponsable));

        String descripcionServicios;
        do {
            System.out.println("Ingrese la descripción de servicios:");
            descripcionServicios = sc.nextLine();
            if ("".equals(descripcionServicios))
                System.out.println("Este campo no puede quedar vacio");
        } while ("".equals(descripcionServicios));

        App.listaEmprendedores.add(new Emprendedor(ruc, nombre, telefono, email, direccion, sitioWeb,
                personaResponsable, descripcionServicios));

        // blucles para Agregar redes sociales
        for (TipoRedSocial t : TipoRedSocial.values()) {
            do {
                System.out.println("Tiene cuenta de " + t + "?");
                System.out.println("Si: 1      No: 2");
                System.out.print("Ingrese numero de opcion: ");
                opcion = sc.nextLine() + " ";
                if (opcion.charAt(0) == '1') {
                    String user;
                    do {
                        System.out.print("Ingrese nombre de usuario: ");
                        user = sc.nextLine();
                        if ("".equals(user))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(user));
                    String enlace;
                    do {
                        System.out.print("Ingrese el link de su usuario: ");
                        enlace = sc.nextLine();
                        if ("".equals(enlace))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(enlace));
                    App.buscarPersona(ruc).agregarRedSocial(t.toString(), user, enlace);
                }
                if (opcion.charAt(0) != '1' && opcion.charAt(0) != '2') {
                    System.out.println("Opcion no valida, por favor, ingrese un numero del 1 al 2");
                }
            } while (opcion.charAt(0) != '1' && opcion.charAt(0) != '2');
        }
        System.out.println("Emprendedor agregado exitosamente");
    }

    private static void editarEmprendedor(Scanner sc) {
        // Codigo para editar emprendedor
        String ruc; // Guarda el ruc del emprendedor a editar
        String opcionEdit; // Guarda la opcion del menu
        System.out.println("Editar emprendedor");
        // Blucle del menu de edicion
        do {
            System.out.println("Ingrese el RUC o cedula del emprendedor");
            ruc = sc.nextLine();
            if (App.buscarPersona(ruc) == null || !(App.buscarPersona(ruc) instanceof Emprendedor)) {
                System.out.println("El RUC o cedula ingresado no pertenese a ningun emprendedor registrado");
            }
        } while (App.buscarPersona(ruc) == null || !(App.buscarPersona(ruc) instanceof Emprendedor));
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
        System.out.println("8. Descripcion de servicios");
        do {
            System.out.print("Ingrese numero de opcion: ");
            opcionEdit = sc.nextLine() + " ";
            switch (opcionEdit.charAt(0)) {
                case '1' -> {
                    String nombre;
                    do {
                        System.out.println("Ingrese nuevo el nombre:");
                        nombre = sc.nextLine();
                        if ("".equals(nombre))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(nombre));
                    App.buscarPersona(ruc).setNombre(nombre);
                    System.out.println("Nombre modificado con exito.");
                }
                case '2' -> {
                    String telefono;
                    do {
                        System.out.println("Ingrese el nuevo teléfono:");
                        telefono = sc.nextLine();
                        if ("".equals(telefono))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(telefono));
                    App.buscarPersona(ruc).setTelefono(telefono);
                    System.out.println("Telefono modificado con exito.");
                }
                case '3' -> {
                    String email;
                    do {
                        System.out.println("Ingrese el nuevo correo electrónico:");
                        email = sc.nextLine();
                        if ("".equals(email))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(email));
                    App.buscarPersona(ruc).setEmail(email);
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
                    String personaResponsable;
                    do {
                        System.out.println("Ingrese la persona responsable:");
                        personaResponsable = sc.nextLine();
                        if ("".equals(personaResponsable))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(personaResponsable));
                    App.buscarPersona(ruc).setPersonaResponsable(personaResponsable);
                    System.out.println("Nombre de persona responsable modificado con exito.");
                }
                case '7' -> {
                    if (App.buscarPersona(ruc).getRedesSociales().isEmpty()) {
                        System.out.println("\nEste emprendedor no tiene niguna red social\n");
                    } else {
                        System.out.println("Lista de redes sociales del emprendedor");
                        System.out.println(App.buscarPersona(ruc).getRedesSociales());
                        int ind;
                        do {
                            System.out.println(
                                    "Escriba el nombre de la red social que de desea editar, ejemplo: Twitter");
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
                        String user;
                        do {
                            System.out.print("Ingrese nuevo nombre de usuario: ");
                            user = sc.nextLine();
                            if ("".equals(user))
                                System.out.println("Este campo no puede quedar vacio");
                        } while ("".equals(user));
                        String enlace;
                        do {
                            System.out.print("Ingrese el nuevo link de su usuario: ");
                            enlace = sc.nextLine();
                            if ("".equals(enlace))
                                System.out.println("Este campo no puede quedar vacio");
                        } while ("".equals(enlace));
                        App.buscarPersona(ruc).getRedesSociales().get(ind).setUsuario(user);
                        App.buscarPersona(ruc).getRedesSociales().get(ind).setEnlace(enlace);
                        System.out.println("Red social modificada con exito");
                    }
                }
                case '8' -> {
                    Emprendedor e = (Emprendedor) App.buscarPersona(ruc);
                    String descripcionServicios;
                    do {
                        System.out.println("Ingrese la descripción de servicios:");
                        descripcionServicios = sc.nextLine();
                        if ("".equals(descripcionServicios))
                            System.out.println("Este campo no puede quedar vacio");
                    } while ("".equals(descripcionServicios));
                    e.setDescripcionServicios(descripcionServicios);
                    System.out.println("Descripcion de servicios modificado con exito.");
                }
                default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 8.");
            }
        } while (opcionEdit.charAt(0) != '1' && opcionEdit.charAt(0) != '2' && opcionEdit.charAt(0) != '3'
                && opcionEdit.charAt(0) != '4' && opcionEdit.charAt(0) != '5' && opcionEdit.charAt(0) != '6'
                && opcionEdit.charAt(0) != '7' && opcionEdit.charAt(0) != '8');
    }
}