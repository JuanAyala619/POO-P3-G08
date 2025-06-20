package espol.poo.app;

import java.time.LocalDate;
import java.util.Scanner;
import espol.poo.models.*;

public class MenuStands implements InterfaceMenu {
    @Override
    public void menu(Scanner sc) {
        String opcion; // Guarda la opcion del menu
        int codigoFeria;
        Feria feria;
        System.out.println("\nADMINISTRACION DE STANDS");
        // pedir codigo de feria
        do {
            System.out.println("\nIngrese el codigo de la feria");
            codigoFeria = sc.nextInt();
            sc.nextLine();
            feria = Feria.buscarFeria(codigoFeria, App.listaFerias);
            if (feria == null) {
                System.out.println("El codigo ingresado no pertenese a ninguna feria");
            }
        } while (feria == null);
        // Bucle de menu
        do {
            System.out.println("\nDistribucion de stands:");
            // For para recorrer la lista de emprendedores y mostrar sus datos
            System.out.println(feria.distribucionStands());
            System.out.println("\nMenu de administracion de stands");
            System.out.println("""
                    1. Reservar stand
                    2. Mostrar informacion de stand
                    3. Regresar""");
            System.out.print("\nIngrese el numero de opcion: ");
            opcion = sc.nextLine() + " ";
            System.out.println();

            switch (opcion.charAt(0)) {
                case '1' -> reservarStand(sc, feria);

                case '2' -> informacionStand(sc, feria);

                case '3' -> // regresar al menu principal
                    System.out.println("Volviendo al menú principal.....\n");

                default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 3.");
            }
        } while (opcion.charAt(0) != '3');
    }

    private static void reservarStand(Scanner sc, Feria feria) {
        // Código para reservar stand
        String codigo;
        do {
            System.out.println("Ingrese el codigo del stand que desea reservar");
            codigo = sc.nextLine();
            if (feria.informacionStand(codigo) == null) {
                System.out.println("El codigo ingresado no corresponde con ningun stand");
            }
        } while (feria.informacionStand(codigo) == null);
        String ruc;
        do {
            System.out.println("Ingrese el RUC o cedula de la persona que reservara el stand");
            ruc = sc.nextLine();
            if (App.buscarPersona(ruc) == null) {
                System.out.println(
                        "El RUC o cedula ingresado no pertenese a ningun emprendedor o auspiciante registrado");
            }
        } while (App.buscarPersona(ruc) == null);
        Persona persona = App.buscarPersona(ruc);
        if (persona instanceof Emprendedor) {
            int count = 0;
            for (Seccion seccion : feria.getSecciones()) {
                for (Stand stand : seccion.getLstStands()) {
                    if (stand.getPersonaAsignada() instanceof Emprendedor) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println("Un emprendedor puede reservar un maximo de 2 stands");
            } else {
                feria.reservarStand(codigo, App.buscarPersona(ruc), LocalDate.now());
                System.out.println("Stand reservado");
            }
        } else {
            Auspiciante a = (Auspiciante)persona;
            for(AuspicianteEnFeria af: feria.getAuspiciantes()){
                if(af.getAuspiciante().equals(a)){
                    if(af.isTieneStand()){
                        feria.reservarStand(codigo, App.buscarPersona(ruc), LocalDate.now());
                        System.out.println("Stand reservado");
                    }else{
                        System.out.println("Este auspiciante no incluye stand en la feria");
                    }
                }
            }
        }
    }

    private static void informacionStand(Scanner sc, Feria feria) {
        // Codigo para ver informacion de stands
        String codigo;
        do {
            System.out.println("Ingrese el codigo del stand que desea revisar");
            codigo = sc.nextLine();
            if (feria.informacionStand(codigo) == null) {
                System.out.println("El codigo ingresado no corresponde con ningun stand");
            }
        } while (feria.informacionStand(codigo) == null);
        System.out.println("Informacion de stand");
        System.out.println(feria.informacionStand(codigo));
    }
}
