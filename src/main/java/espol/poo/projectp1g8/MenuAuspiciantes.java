package espol.poo.projectp1g8;

import espol.poo.model.*;
import java.util.Scanner;

public class MenuAuspiciantes {

    static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Auspiciantes registrados: ");
        for (Auspiciante a : Projectp1g8.listaAuspiciantes) {
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
        do {
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
        } while (opcion.charAt(0) != '4');
        System.out.println("Volviendo al menú principal.....\n");
    }

    static void registrarAuspiciante() {
        Scanner sc = new Scanner(System.in);
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
        for (Auspiciante a : Projectp1g8.listaAuspiciantes) {//valida que no exista algun ruc repetido
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
                            System.out.println("Registro finalizado.....");
                        }
                    }
                    default ->
                        System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 2.");
                }
            } while (opcion.charAt(0) != '2' || a.getLstTipoSectores().isEmpty());

            //Agragar una red social
            for (TipoRedSocial t : TipoRedSocial.values()) {
                do {
                    System.out.println("Tiene cuenta de " + t + "?");
                    System.out.println("Si: 1      No: 2");
                    System.out.print("Ingrese numero de opcion: ");
                    opcion = sc.nextLine() + " ";
                    if (opcion.charAt(0) == '1') {
                        System.out.print("Ingrese nombre de usuario: ");
                        String user = sc.nextLine();
                        System.out.print("Ingrese el link de su usuario: ");
                        String enlace = sc.nextLine();
                        Projectp1g8.buscarPersona(ruc).agregarRedSocial(t.toString(), user, enlace);
                    }
                    if (opcion.charAt(0) != '1' && opcion.charAt(0) != '2') {
                        System.out.println("Opcion no valida, por favor, ingrese un numero del 1 al 2");
                    }
                } while (opcion.charAt(0) != '1' && opcion.charAt(0) != '2');
            }
            System.out.println("Auspiciante agregado correctamente.....\n");
            System.out.println("Volviendo al menú auspiciantes.....\n");
        }
    }

    static void editarAuspiciante() {

    }

    static void asignarAuspiciante() {

    }
}
