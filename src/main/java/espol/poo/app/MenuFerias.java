package espol.poo.app;

import java.time.LocalDate;
import java.util.ArrayList;
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
                System.out.println("Fecha de Inicio: " + feria.getFechaInicio().toString());
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
            System.out.println("Fecha de Inicio:" + feria.getFechaInicio().toString());
            System.out.println("Feha de Fin:" + feria.getFechaFin().toString());
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
        System.out.println("Fecha de Inicio (formato: yyyy-mm-dd)");
        String fechaInicio = sc.nextLine();
        System.out.println("Fecha de Fin (formato yyyy-mm-dd)");
        String fechaFin = sc.nextLine();
        System.out.println("Horario (formato 24h, hh:mm-hh:mm)");
        String horario = sc.nextLine();

        Feria feria = new Feria(App.listaFerias.size() + 1, nombre, descripcion, lugar, fechaInicio, fechaFin, horario);

        System.out.println("Ingrese la cantidad de stands para cada seccion:");
        System.out.println("Seccion 1:");
        int num1 = sc.nextInt();
        System.out.println("Seccion 2:");
        int num2 = sc.nextInt();
        System.out.println("Seccion 3:");
        int num3 = sc.nextInt();
        System.out.println("Seccion 4:");
        int num4 = sc.nextInt();

        feria.asignarNumeroStands(num1, num2, num3, num4);

        App.listaFerias.add(feria);
    }

    private static void editarFeria(Scanner sc) {

        String opcionEdit;
        System.out.println("\nEditar Feria:");

        System.out.println("\nIngrese el codigo de la feria");
        int codigo = sc.nextInt();
        while (Feria.buscarFeria(codigo, App.listaFerias) == null
                || LocalDate.now().isAfter(Feria.buscarFeria(codigo, App.listaFerias).getFechaInicio())) {

            System.out.println("\nEl codigo no pertenece a ninguna feria registrada");
            System.out.println("\nIngrese el codigo de la feria");
            codigo = sc.nextInt();
        }

        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);

        System.out.println("Informacion actual de la feria");
        System.out.println(feria);

        System.out.println("¿Que campo desea editar?");
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
            System.out.print("Ingrese numero de opcion: ");
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
                        System.out.println("Ingrese numero de auspiciante a editar:");
                        int index = sc.nextInt();
                        AuspicianteEnFeria auspicianteFeria = auspiciantesFeria.get(index - 1);
                        System.out.println("\nMenu de Opciones:");
                        System.out.println("1. Nombre de Auspiciante");
                        System.out.println("2. Telefono de Auspiciante");
                        System.out.println("3. Email de Auspiciante");
                        System.out.println("4. Direccion de Auspiciante");
                        System.out.println("5. Sitio Web de Auspiciante");
                        System.out.println("6. Persona Responsable de Auspiciante");
                        System.out.println("7. Redes Sociales de Auspiciante");
                        System.out.println("8. Lista de Sectores de Auspiciante");
                        System.out.println("10. Descripcion de Auspiciante");
                        System.out.println("11. Tiene Stand o no");
                        System.out.println("12. Volver a Menu de Editar Feria");
                        System.out.println("\nIngrese numero de Opcion:");
                    }

                }
                case '8' -> {
                    Auspiciante a = null;
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
