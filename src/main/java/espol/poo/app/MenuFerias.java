package espol.poo.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import espol.poo.models.*;

public class MenuFerias {
    static void menu(Scanner sc) {
        String opcion;
        do {
            System.out.println("\nADMINISTRACION DE FERIAS");
            System.out.println("\nFerias registradas:");
            for (Feria feria : App.listaFerias) {
                System.out.println("\nCodigo: " + feria.getCodigo());
                System.out.println("Nombre: " + feria.getNombre());
                System.out.println("Fecha de Inicio: " + feria.getFechaInicio().toString());
                System.out.println("Lugar: " + feria.getLugar());
                System.out.println("Cantidad de Auspiciantes: " + feria.getAuspiciantes().size() + "\n");
            }
            System.out.println("\nMenu de Opciones:");
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
                    emprendedoresFeria(sc);
                    break;

                case '5':
                    System.out.println("\nVolviendo al menu principal");
                    break;

                default:
                    System.out.println("Opcion no valida, por favor, ingrese un numero del 1 al 2");
                    break;
            }
        } while (opcion.charAt(0) != '5');
        System.out.println("Regresando al menú principal");
    }

    private static void informacionFeria(Scanner sc) {
        System.out.println("\nIngrese codigo de Feria:");
        int codigo = sc.nextInt();
        sc.nextLine();
        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);
        if (feria != null) {

            System.out.println("\nNombre: " + feria.getNombre());
            System.out.println("Lugar: " + feria.getLugar());
            System.out.println("Fecha de Inicio: " + feria.getFechaInicio().toString());
            System.out.println("Feha de Fin: " + feria.getFechaFin().toString());
            System.out.println("Horario :" + feria.getHorario());
            System.out.println("Lista de Auspiciantes:");
            for (AuspicianteEnFeria auspicianteEnFeria : feria.getAuspiciantes()) {
                System.out.println(auspicianteEnFeria.getAuspiciante().getNombre());
            }
            System.out.println("\nCantidad de Stands en cada Seccion:");
            for (Seccion seccion : feria.getSecciones()) {
                System.out.println("Seccion " + seccion.getId() + ": " + seccion.getLstStands().size());
            }
        } else {
            System.out.println("No existe una feria con ese codigo");
        }
        System.out.println("\nRegresando al menu de administracion de ferias...");
    }

    private static void registrarFeria(Scanner sc) {
        System.out.println("\nIngrese los siguientes datos");

        System.out.println("\nNombre:");
        String nombre = sc.nextLine();
        System.out.println("\nDescripcion:");
        String descripcion = sc.nextLine();
        System.out.println("\nLugar:");
        String lugar = sc.nextLine();
        System.out.println("\nFecha de Inicio (formato: yyyy-mm-dd):");
        String fechaInicio = sc.nextLine();
        System.out.println("\nFecha de Fin (formato yyyy-mm-dd):");
        String fechaFin = sc.nextLine();
        System.out.println("\nHorario (formato 24h, hh:mm-hh:mm):");
        String horario = sc.nextLine();

        Feria feria = new Feria(App.listaFerias.size() + 1, nombre, descripcion, lugar, fechaInicio, fechaFin, horario);

        System.out.println("\nIngrese la cantidad de stands para cada seccion:");
        System.out.println("\nSeccion 1:");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.println("\nSeccion 2:");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.println("\nSeccion 3:");
        int num3 = sc.nextInt();
        sc.nextLine();
        System.out.println("\nSeccion 4:");
        int num4 = sc.nextInt();
        sc.nextLine();

        feria.asignarNumeroStands(num1, num2, num3, num4);

        App.listaFerias.add(feria);
        System.out.println("\nRegresando al menu de administracion de ferias...");

    }

    private static void editarFeria(Scanner sc) {

        String opcionEdit;
        System.out.println("\nEDITAR FERIA");

        System.out.println("\nIngrese el codigo de la feria:");
        int codigo = sc.nextInt();
        sc.nextLine();
        while (Feria.buscarFeria(codigo, App.listaFerias) == null
                || LocalDate.now().isAfter(Feria.buscarFeria(codigo, App.listaFerias).getFechaInicio())) {

            System.out.println("\nEl codigo no pertenece a ninguna feria registrada");
            System.out.println("\nIngrese el codigo de la feria");
            codigo = sc.nextInt();
            sc.nextLine();
        }

        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);

        System.out.println("\nInformacion actual de la feria");
        System.out.println(feria);

        System.out.println("\n¿Que campo desea editar?");
        System.out.println("1. Nombre");
        System.out.println("2. Descripcion");
        System.out.println("3. Lugar");
        System.out.println("4. Fecha de Inicio");
        System.out.println("5. Fecha de Fin");
        System.out.println("6. Horario");
        System.out.println("7. Lista de Auspiciantes");
        System.out.println("8. Lista de Emprendedores");
        System.out.println("9. Volver al Menu de Feria");

        do {
            System.out.print("\nIngrese numero de opcion: ");
            opcionEdit = sc.nextLine() + " ";
            switch (opcionEdit.charAt(0)) {
                case '1' -> {
                    System.out.println("\nIngrese el nuevo nombre");
                    String nombre = sc.nextLine();
                    feria.setNombre(nombre);
                    System.out.println("Nombre modificado con exito.");
                }
                case '2' -> {
                    System.out.println("\nIngrese la nueva descripcion:");
                    String descripcion = sc.nextLine();
                    feria.setDescripcion(descripcion);
                    System.out.println("Descripcion modificada con exito.");
                }
                case '3' -> {
                    System.out.println("\nIngrese el nuevo Lugar");
                    String lugar = sc.nextLine();
                    feria.setLugar(lugar);
                    System.out.println("Lugar modificado con exito.");
                }
                case '4' -> {
                    System.out.println("\nIngrese la nueva fecha de inicio (formato yyyy-mm-dd)");
                    String fechaInicio = sc.nextLine();
                    feria.setFechaInicio(fechaInicio);
                    System.out.println("Fecha de Inicio modificada con exito.");
                }
                case '5' -> {
                    System.out.println("\nIngrese la nueva fecha de fin (formato yyyy-mm-dd)");
                    String fechaFin = sc.nextLine();
                    feria.setFechaFin(fechaFin);
                    System.out.println("Fecha de Fin modificado con exito.");
                }
                case '6' -> {
                    System.out.println("\nIngrese el nuevo horario (formato 24h, hh:mm-hh:mm)");
                    String horario = sc.nextLine();
                    feria.setHorario(horario);
                    System.out.println("Horario modificado con exito.");
                }
                case '7' -> {
                    if (feria.getAuspiciantes() == null) {
                        System.out.println("\nEsta feria no tiene auspiciantes");
                    } else {
                        ArrayList<AuspicianteEnFeria> auspiciantesFeria = feria.getAuspiciantes();
                        System.out.println("\nEditar Auspiciantes:");
                        for (int i = 0; i < auspiciantesFeria.size(); i++) {
                            System.out.println("\nAuspciante" + i + 1);
                            System.out.println(auspiciantesFeria.get(i).toString());
                        }

                        System.out.println("\nIngrese numero de auspiciante a editar:");
                        int index = sc.nextInt();
                        sc.nextLine();
                        AuspicianteEnFeria auspicianteFeria = auspiciantesFeria.get(index - 1);

                        System.out.println("\nAuspiciante escogido:");
                        System.out.println(auspicianteFeria.toString());

                        System.out.println("\nMenu de Opciones:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Telefono");
                        System.out.println("3. Email");
                        System.out.println("4. Direccion");
                        System.out.println("5. Sitio Web");
                        System.out.println("6. Persona Responsable");
                        System.out.println("7. Redes Sociales");
                        System.out.println("8. Lista de Sectores");
                        System.out.println("9. Descripcion de Servicio en la Feria");
                        System.out.println("10. Tiene Stand o no");
                        System.out.println("11. Volver a Menu de Editar Feria");

                        System.out.println("\nIngrese numero de Opcion:");
                        Auspiciante auspiciante = auspicianteFeria.getAuspiciante();
                        do {
                            System.out.print("\nIngrese numero de opcion: ");
                            opcionEdit = sc.nextLine() + " ";
                            switch (opcionEdit) {
                                case "1" -> {
                                    System.out.println("\nIngrese el nuevo nombre");
                                    String nuevoNombre = sc.nextLine();
                                    auspiciante.setNombre(nuevoNombre);
                                    System.out.println("Nombre modificado con exito.");
                                }
                                case "2" -> {
                                    System.out.println("\nIngrese el nuevo telefono");
                                    String nuevoTelefono = sc.nextLine();
                                    auspiciante.setTelefono(nuevoTelefono);
                                    System.out.println("Telefono modificado con exito.");
                                }
                                case "3" -> {
                                    System.out.println("\nIngrese el nuevo Email");
                                    String nuevoEmail = sc.nextLine();
                                    auspiciante.setEmail(nuevoEmail);
                                    System.out.println("Email modificado con exito.");
                                }
                                case "4" -> {
                                    System.out.println("\nIngrese la nueva direccion");
                                    String nuevaDir = sc.nextLine();
                                    auspiciante.setDireccion(nuevaDir);
                                    System.out.println("Direccion modificada con exito.");
                                }
                                case "5" -> {
                                    System.out.println("\nIngrese el nuevo sitio web");
                                    String nuevoSitio = sc.nextLine();
                                    auspiciante.setTelefono(nuevoSitio);
                                    System.out.println("Sitio web modificado con exito.");
                                }
                                case "6" -> {
                                    System.out.println("\nIngrese el nombre de la nueva persona responsable");
                                    String nuevoResponsable = sc.nextLine();
                                    auspiciante.setPersonaResponsable(nuevoResponsable);
                                    System.out.println("Nombre de persona responsable modificado con exito.");
                                }
                                case "7" -> {
                                    if (auspiciante.getRedesSociales().isEmpty()) {
                                        System.out.println("\nEste emprendedor no tiene niguna red social\n");
                                    } else {
                                        System.out.println("Lista de redes sociales del auspiciante");
                                        System.out.println(auspiciante.getRedesSociales());
                                        int ind;
                                        do {
                                            System.out
                                                    .println("Escriba el nombre de la red social que de desea editar");
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
                                            ind = auspiciante.getRedesSociales().indexOf(new RedSocial(red, "", ""));
                                            if (ind == -1) {
                                                System.out.println("Por favor escriba un nombre valido");
                                            }
                                        } while (ind == -1);
                                        System.out.println("Escriba el nuevo nombre de usuario");
                                        String nuevoNombre = sc.nextLine();
                                        System.out.println("Escriba el nuevo link del usuario");
                                        String nuevoLink = sc.nextLine();
                                        auspiciante.getRedesSociales().get(ind).setUsuario(nuevoNombre);
                                        auspiciante.getRedesSociales().get(ind).setEnlace(nuevoLink);
                                        System.out.println("Red social modificada con exito");
                                    }
                                }
                                case "8" -> {
                                    Auspiciante a = (Auspiciante) auspiciante;
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
                                                System.out.println(
                                                        "Opción no válida. Por favor, ingresa un número del 1 al 2.");
                                        }
                                    } while (opcion.charAt(0) != '2' || a.getLstTipoSectores().isEmpty());
                                }
                                case "9" -> {
                                    System.out.println("Ingrese la nueva descripion del servicio");
                                    String descripcion = sc.nextLine();
                                    auspicianteFeria.setDescripcionServicio(descripcion);
                                    System.out.println("Descripcion de Servicio modificado con exito.");

                                }
                                case "10" -> {

                                    System.out.println("¿Desea que el Aupsiciante tenga stand o no? (S/N)");
                                    String respStand = sc.nextLine();
                                    if (respStand == "s" || respStand == "S") {
                                        auspicianteFeria.setTieneStand(true);
                                    } else if (respStand == "n" || respStand == "N") {
                                        auspicianteFeria.setTieneStand(false);
                                    }
                                }
                                case "11" -> {
                                    System.out.println("Volviendo al Menu de Edicion de Feria");
                                }

                                default ->
                                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 11.");
                            }
                        } while (opcionEdit.charAt(0) != '9');
                    }

                }
                case '8' -> {
                    if (feria.getEmprendedores() == null) {
                        System.out.println("\nEsta feria no tiene emprendedores");
                    } else {
                        ArrayList<Emprendedor> emprendedores = feria.getEmprendedores();
                        System.out.println("\nEditar Emprendedores:");
                        for (int i = 0; i < emprendedores.size(); i++) {
                            System.out.println("\nAuspciante" + i + 1);
                            System.out.println(emprendedores.get(i).toString());
                        }

                        System.out.println("\nIngrese numero de emprendedor a editar:");
                        int index = sc.nextInt();
                        sc.nextLine();
                        Emprendedor emprendedor = emprendedores.get(index - 1);

                        System.out.println("\nEmprendedor escogido:");
                        System.out.println(emprendedor.toString());
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
                                    emprendedor.setNombre(nombre);
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
                                    emprendedor.setTelefono(telefono);
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
                                    emprendedor.setEmail(email);
                                    System.out.println("Email modificado con exito.");
                                }
                                case '4' -> {
                                    System.out.println("Ingrese la nueva direccion");
                                    String nuevaDir = sc.nextLine();
                                    emprendedor.setDireccion(nuevaDir);
                                    System.out.println("Direccion modificada con exito.");
                                }
                                case '5' -> {
                                    System.out.println("Ingrese el nuevo sitio web");
                                    String nuevoSitio = sc.nextLine();
                                    emprendedor.setTelefono(nuevoSitio);
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
                                    emprendedor.setPersonaResponsable(personaResponsable);
                                    System.out.println("Nombre de persona responsable modificado con exito.");
                                }
                                case '7' -> {
                                    if (emprendedor.getRedesSociales().isEmpty()) {
                                        System.out.println("\nEste emprendedor no tiene niguna red social\n");
                                    } else {
                                        System.out.println("Lista de redes sociales del emprendedor");
                                        System.out.println(emprendedor.getRedesSociales());
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
                                            ind = emprendedor.getRedesSociales().indexOf(new RedSocial(red, "", ""));
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
                                        emprendedor.getRedesSociales().get(ind).setUsuario(user);
                                        emprendedor.getRedesSociales().get(ind).setEnlace(enlace);
                                        System.out.println("Red social modificada con exito");
                                    }
                                }
                                case '8' -> {
                                    Emprendedor e = (Emprendedor) emprendedor;
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
                                default ->
                                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 8.");
                            }
                        } while (opcionEdit.charAt(0) != '1' && opcionEdit.charAt(0) != '2'
                                && opcionEdit.charAt(0) != '3'
                                && opcionEdit.charAt(0) != '4' && opcionEdit.charAt(0) != '5'
                                && opcionEdit.charAt(0) != '6'
                                && opcionEdit.charAt(0) != '7' && opcionEdit.charAt(0) != '8');
                    }
                }
                case '9' -> {
                    System.out.println("Volviendo al menu principal");
                }
                default ->
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 9.");
            }
        } while (opcionEdit.charAt(0) != '9');

    }

    private static void emprendedoresFeria(Scanner sc) {
        System.out.println("\nIngrese codigo de Feria");
        int codigo = sc.nextInt();
        sc.nextLine();
        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);
        if (feria != null) {
            System.out.println("\nLista de Emprendedores:");
            for (Emprendedor emprendedor : feria.getEmprendedores()) {
                System.out.println(emprendedor.toString());
            }
        } else {
            System.out.println("\nNo existe una feria con ese codigo");
        }
    }

}
