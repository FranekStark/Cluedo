import touple.Ort;
import touple.Spieler;
import touple.Taeter;
import touple.Waffe;
import touple.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpielControler {
    static BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
    static Spiel spiel = new Spiel();

    public static void main(String args[]) throws IOException {
        printMain();
        while (true) {
            char c = in.readLine().charAt(0);
            switch (c) {
                case 'n':
                    spiel = new Spiel();
                    break;
                case '1': {
                    System.out.println("Spieler: ");
                    String spieler = in.readLine();
                    System.out.println("Karte: ");
                    String karteS = in.readLine();
                    Karte karteE = null;
                    try {
                        karteE = Taeter.valueOf(karteS);
                    } catch (IllegalArgumentException e) {

                    }
                    try {
                        karteE = Ort.valueOf(karteS);
                    } catch (IllegalArgumentException e) {

                    }
                    try {
                        karteE = Waffe.valueOf(karteS);
                    } catch (IllegalArgumentException e) {

                    }

                    spiel.spielerZeigtKarteSichtbar(new Spieler(spieler), karteE);
                }
                break;
                case '2': {
                    System.out.print("Spieler: ");
                    String spieler = in.readLine();
                    System.out.print("Täter: ");
                    Taeter t = Taeter.valueOf(in.readLine());
                    System.out.print("Ort: ");
                    Ort o = Ort.valueOf(in.readLine());
                    System.out.print("Waffe: ");
                    Waffe w = Waffe.valueOf(in.readLine());

                    spiel.spielerZeigtKarteGeheim(new Spieler(spieler), o, w, t);
                }
                break;
                case '3': {
                    System.out.print("Spieler: ");
                    String spieler = in.readLine();
                    System.out.print("Täter: ");
                    Taeter t = Taeter.valueOf(in.readLine());
                    System.out.print("Ort: ");
                    Ort o = Ort.valueOf(in.readLine());
                    System.out.print("Waffe: ");
                    Waffe w = Waffe.valueOf(in.readLine());
                    spiel.spielerHatKeineKarte(new Spieler(spieler), o, w, t);
                }
                break;
                case 'r':
                    spiel.substituiereDurchEindeutige();
                    spiel.entferneWertloseInfos();
                    spiel.substitutionDurchNegativeInfos();
                    spiel.ueberfuehreMnachE();
                    spiel.reduktion();
                    System.out.flush();
                    printMain();
                    break;

            }
        }
    }

    private static void printMain() {

        System.out.println("Cluedo eingabe: ");
        System.out.println("[n]: neues Spiel, [1]: Fall 1, [2]: Fall 2, [3]: Fall 3");
        System.out.println("=======================================================");
        System.out.println("Eindeutig: ");
        spiel._eindeutig.toString();

        System.out.println("=======================================================");
        System.out.println("Mehrdeutig:");
        spiel._mehrdeutig.toString();

        System.out.println("=======================================================");
        System.out.println("Negation:");
        spiel._negational.toString();


    }
}
