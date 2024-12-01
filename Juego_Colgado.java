package Entregables1;

import java.util.Scanner;  // Importa la classe Scanner per llegir dades des de l'entrada de l'usuari

public class Juego_Colgado {  // Inici de la classe principal anomenada Main
    public static void main(String[] args) {
        // Declarar variables
        int menu = 0; // Variable menu amb un valor de 0 per previnir errors. L'utilitzaré per eligir una opció del switch-case.
        boolean continuar = true; // Utilitzo la variable boolean amb el nom continuar amb valor true. L'utilitzare per a saber si vui continuar el bucle while o finalitzar-lo
        Scanner sc = new Scanner(System.in); // Creo Scanner
        int rondes = 0;

        while (continuar == true) { // Utilitzo un bucle while continuar amb un valor true fins que el valor sigui
            // false
            System.out.println("Menu ");
            System.out.println(" 1. Jugar ");
            System.out.println("-1. Sortir ");
            System.out.println("Introdueix un número: ");

            menu = sc.nextInt();// Pregunto quin valor voldrá per a variable menú

            switch (menu) {// Utilitzo un switch-case per a que llegeixi la variable de menu, per a diferents casos
                case 1:// Quan el valor de la variable menu sigui = 1
                    int jugadores = 0;

                    while (jugadores < 2) {
                        System.out.println("Quants jugadors? ");
                        jugadores = sc.nextInt();

                        if (jugadores < 2) {
                            System.err.println("Introdueix un número vàlid (Mínim 2 jugadors)");
                        }
                    }

                    // Preguntar rondes
                    System.out.println("Quantes ronades vols jugar?");
                    rondes = sc.nextInt();

                    for (int i = 0; i < rondes; i++) {
                        jugarPartida(jugadores); // Crido la funció jugar per tenir els menus separats
                    }

                    break;

                case -1:// Quan el valor de la variable menu sigui = -1
                    continuar = false;// Quan la variable int menu = -1. Que el bucle while finalitza al cambiar el
                    // valor a false.
                    break;

                default:// Quan el valor introduït no sigui 1 o -1 doni un missatge d'error
                    System.err.println("Introdueix un número vàlid");
                    break;
            }
        }

        System.out.println("Has sortit del programa"); // Quan el valor de la variable menu es -1 provocant que el valor "continuar" sigui false
        sc.close(); // Tanco Scanner

    }

    // Creo una funció
    public static void jugarPartida(int njugadors) {
        Scanner sc = new Scanner(System.in);
        int intents = 6;
        String palabra = "";

        // Preguntar paraula secreta
        System.out.println("Introduzca la palabra secreta");
        palabra = sc.next();

        // Partida
        for (int i = 0; i < intents; i++) {
            for (int n = 0; n < njugadors; n++) {
                System.out.println("Ronda " + (i + 1) + " jugador " + njugadors);
            }
        }

    }
}