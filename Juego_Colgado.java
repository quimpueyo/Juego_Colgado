package Entregables1;

import java.util.Scanner;

public class Juego_Colgado {
    public static void main(String[] args) {
    	
    	
        // Declarar variables
        int menu = 0;
        int continuar = 1;
        Scanner sc = new Scanner(System.in);

        while (continuar == 1) {
        	System.out.println("Menu ");
        	System.out.println(" 1. Jugar ");
        	System.out.println("-1. Sortir ");
            System.out.println("Introdueix un número: ");

            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Jugar");
                    break;
                case -1:
                    continuar = 2;
                    break;
                default:
                    System.err.println("Introdueix un número vàlid");
                    break;
            }
        }

        System.out.println("Has sortit del programa");
        sc.close();
    }
}





