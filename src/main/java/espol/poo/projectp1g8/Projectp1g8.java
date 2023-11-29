package espol.poo.projectp1g8;

import java.util.Scanner;

public class Projectp1g8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        do{
            System.out.println("Bienvenido al sistema de administracion de ferias");
            System.out.println("Menu Principal");
            System.out.println("1. Administracion de ferias"
                             + "2. Administracion de emprendedores"
                             + "3. Sdministracion de auspiciantes"
                             + "4. Administracion de stands"
                             + "5. Salir");
            System.out.print("Ingrese el numero de opcion: ");
            opcion = sc.nextLine();
            System.out.println("\n");
            
            switch (opcion.charAt(0)) {
                case '1':
                    // Código para la Administracion de ferias
                    MenuFerias.menu();
                    break;
                case '2':
                    // Código para la Administracion de emprendedores
                    MenuEmprendedores.menu();
                    break;
                case '3':
                    // Código para la Administracion de auspiciantes
                    MenuAuspiciantes.menu();
                    break;
                case '4':
                    // Código para la Administracion de stands
                    MenuStands.menu();
                    break;
                case '5':
                    // Salir del bucle
                    System.out.println("Saliendo del sistema de administracion de ferias.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 5.");
            }
        }while(opcion.charAt(0) != '5');
        System.out.println("Gracias por usar el programa.");
        sc.close();
    }
}
