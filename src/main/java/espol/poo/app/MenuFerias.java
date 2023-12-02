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

                    break;

                case '4':

                    break;

                case '5':
                    break;

                default:
                    break;
            }
        } while (opcion.charAt(0) != '5');
        System.out.println("Regresando al menú principal");
    }

    private static void informacionFeria(Scanner sc) {
        System.out.println("Ingrese codigo de Feria");
        int codigo = sc.nextInt();
        Feria feria = Feria.buscarFeria(codigo, App.listaFerias);
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

    }

    private static void registrarFeria(Scanner sc) {
        System.out.println("Ingrese los siguientes datos");
        System.out.println("Nombre:");
        System.out.println("Descripcion");
        System.out.println("Lugar");
        System.out.println("Fecha de Inicio");
        System.out.println("Fecha de Fin");
        System.out.println("Horario");


        System.out.println("");
    }
}
