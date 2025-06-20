package espol.poo.app;

import java.util.ArrayList;
import java.util.Scanner;
import espol.poo.models.*;

public class App {
    public static ArrayList<Feria> listaFerias = new ArrayList<>();
    public static ArrayList<Emprendedor> listaEmprendedores = new ArrayList<>();
    public static ArrayList<Auspiciante> listaAuspiciantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;
        agregarEmprendedores(); // Se agregan emprendedores por defecto
        agregarAuspiciantes(); // Se agregan auspiciantes por defecto
        agregarFerias();
        System.out.println("Bienvenido al sistema de administracion de ferias");
        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("""
                    1. Administracion de ferias
                    2. Administracion de emprendedores
                    3. Administracion de auspiciantes
                    4. Administracion de stands
                    5. Salir""");
            System.out.print("\nIngrese el numero de opcion: ");
            opcion = sc.nextLine();
            System.out.println();
            TipoMenu tipo = TipoMenu.desdeCodigo(opcion);
            if (tipo != null) {
                tipo.getMenu().menu(sc);
            }


            switch (opcion.charAt(0)) {
                case '5' -> // Salir del bucle
                    System.out.println("Saliendo del sistema de administracion de ferias.");
                default -> System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 5.");
            }
        } while (opcion.charAt(0) != '5');
        System.out.println("Gracias por usar el sistema.");
        sc.close();
    }

    public static Persona buscarPersona(String ruc) {
        Persona p = null;
        for (int i = 0; i < listaEmprendedores.size(); i++) {
            if (listaEmprendedores.get(i).getRuc().equals(ruc)) {
                p = listaEmprendedores.get(i);
            }
        }
        for (int i = 0; i < listaAuspiciantes.size(); i++) {
            if (listaAuspiciantes.get(i).getRuc().equals(ruc)) {
                p = listaAuspiciantes.get(i);
            }
        }
        return p;
    }

    public static void agregarEmprendedores() {
        listaEmprendedores.add(new Emprendedor("1798285937001", "Tienda de Pepe", "0948652474", "tpepe@gmail.com",
                "Urbanización Los Dos Caminos", "www.tiendapepe.com.ec", "Pepe", "Venta de articulos varios"));
        listaEmprendedores.get(0).agregarRedSocial("Twitter", "Pepe", "www.Twitter/pepe");
        listaEmprendedores.get(0).agregarRedSocial("Pinterest", "Pepe", "www.Pinterest/pepe");

        listaEmprendedores
                .add(new Emprendedor("1156183215484", "Super Papeleria", "0995685471", "superpapeleria@gmail.com",
                        "San Marcos, A, El Matacho", "www.superpapel.com.ec", "Maria", "Venta de articulos escolares"));
        listaEmprendedores.get(1).agregarRedSocial("TikTok", "SPapel", "www.TikTok/spapel");
        listaEmprendedores.get(1).agregarRedSocial("LinkedIn", "SPapel", "www.LinkedIn/spapel");

        listaEmprendedores.add(new Emprendedor("1745865631877", "Pasteles del chino", "0985632685",
                "pasteleschino@gmail.com", "Centro Comercial Ctro Com Euro, Piso PB, Local 6-7-8-9",
                "www.pasteles.com.ec", "El Chino", "Venta de pasteles"));
        listaEmprendedores.get(2).agregarRedSocial("LinkedIn", "pchino", "www.LinkedIn/pchino");

        listaEmprendedores.add(new Emprendedor("1456852584174", "Tacos don Jose", "0958714526", "tacostacos@gmail.com",
                "Cl. 20 Y 21, CC El Gran Muro, 2", "www.tacostacos.com.ec", "Jose", "Venta de tacos"));
        listaEmprendedores.get(3).agregarRedSocial("Pinterest", "tjose", "www.Pinterest/tjose");
    }

    public static void agregarAuspiciantes() {
        listaAuspiciantes.add(new Auspiciante("1234567891237", "Auspiciante S.A.", "987654321",
                "correoauspiciante@ejemplo.com", "Calle Principal 123", "www.auspiciante.com", "Juan Perez"));
        listaAuspiciantes.get(0).agregarRedSocial("TikTok", "Auspiciantes Oficial",
                "www.tiktok/auspiciantesoficial.com");
        listaAuspiciantes.get(0).agregarSectores(2);
        listaAuspiciantes.get(0).agregarSectores(3);
    }

    public static void agregarFerias() {
        Feria feria = new Feria(App.listaFerias.size() + 1, "Feria de Navidad",
                "Decoraciones para tu casa en tiempos de Navidad", "Ceibos", "2024-10-20", "2024-12-20", "9:00-20:00");
        feria.asignarNumeroStands(1, 1, 1, 1);
        feria.asignarAuspiciante(listaAuspiciantes.get(0), "Gorros de Navidad", true);

        listaFerias.add(feria);
    }

}
