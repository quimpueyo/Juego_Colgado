package Entregables1;

import java.util.Scanner; 

public class Juego_Colgado { 
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

            menu = sc.nextInt(); // Pregunto quin valor voldrá per a variable menú

            switch (menu) { // Utilitzo un switch-case per a que llegeixi la variable de menu, per a diferents casos
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
                        System.out.println("Partida " + (i + 1)); // Mostrar partida actual
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
        // Declarem variables que volsrem utilitzar
        Scanner sc = new Scanner(System.in);
        int intents = 6;
        String palabra = "";
        String lletra = "";

        // Preguntar paraula secreta
        System.out.println("Admin: Introduzca la palabra secreta");
        palabra = sc.next();

        // Inicializamos el array de la palabra secreta con la longitud correcta
        char[] paraulaAmagada = new char[palabra.length()];

        // Mostrar paraula amagada per guions
        for (int p = 0; p < palabra.length(); p++) {
            paraulaAmagada[p] = '_';
        }

        System.out.println("Paraula: " + new String(paraulaAmagada));

        // Partida
        for (int i = 0; i < intents; i++) {
            boolean jugadorHaGuanyat = false;  //Per controlar si algun jugador ha guanyat en aquesta ronda.

            for (int n = 0; n < njugadors; n++) {//bucle per iterar a través de tots els jugadors.
                if (jugadorHaGuanyat) {// Si un jugador ha guanyat, es surt del bucle i s'acaba la ronda.
                    break;
                }
                // Si s'ha arribat a l'intent 5 (el sisè intent, perquè l'índex comença a 0), el jugador perd.
                if (i == 5) {
                    System.out.println("Jugador " + (n + 1) + " has perdut, no tens mé sintents");
                    break;// Surt del bucle perquè el jugador ha perdut.
                } else {
                    if (palabra.equals(new String(paraulaAmagada))) {// Si no és l'intent 5, es comprova si la paraula amagada coincideix amb la paraula secreta.
                        System.out.println("Jugador " + (n + 1) + " ha trobat la paraula. La paraula secreta era " + palabra);
                        jugadorHaGuanyat = true;
                        break;// Surt del bucle, ja que el jugador ha guanyat.
                    } else {
                        // Preguntar una paraula (per si no coincideix)
                        System.out.println("Jugador " + (n + 1) + " dis una lletra");
                        lletra = sc.next();

                        for (int x = 0; x < palabra.length(); x++) { //bucle per verificar cada lletra de la paraula secreta.
                            char ara = palabra.charAt(x);//Obté la lletra de la paraula secreta a la posició 'x'.

                            if (Character.toString(ara).equals(lletra)) {// si la lletra introduïda pel jugador coincideix amb la lletra de la paraula secreta, s'actualitza la paraula amagada.
                                paraulaAmagada[x] = ara;
                            }
                        }
                    }

                    System.out.println("Paraula " + new String(paraulaAmagada));
                }
            }

            if (jugadorHaGuanyat) { //si algun jugador ha guanyat, s'acaba el bucle principal de la partida.
                break;
            }
        }
    }
}