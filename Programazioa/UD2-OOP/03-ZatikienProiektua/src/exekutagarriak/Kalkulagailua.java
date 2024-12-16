package exekutagarriak;

import model.Zatikia;

import java.util.Scanner;

public class Kalkulagailua {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean egiaztapena = false;
        Zatikia zat1 = new Zatikia();
        Zatikia zat2 = new Zatikia();
        Zatikia emaitza = new Zatikia();
        char ikurra;

        System.out.println("KALKULAGAILUA \n =====================");
        do {
            System.out.print("Sartu lehen zatikia: ");
            String sarrera = in.nextLine();
            if (isNumeric(sarrera) == true) {
                zat1 = new Zatikia(sarrera);
                egiaztapena = true;
            } else {
                System.out.println("Zenbaki bat sartu behar duzu X/Y formatuan!");
            }
        } while (egiaztapena != true);

        egiaztapena = false;
        do {
            System.out.print("Sartu bigarren zatikia: ");
            String sarrera = in.nextLine();
            if (isNumeric(sarrera) == true) {
                zat2 = new Zatikia(sarrera);
                egiaztapena = true;
            } else {
                System.out.println("Zenbaki bat sartu behar duzu X/Y formatuan!");
            }
        } while (egiaztapena != true);
        do {
            System.out.print("Aukeratu eragiketa (+ edo x): ");
            ikurra = in.nextLine().charAt(0);
        } while (isCorrectCharacter(ikurra) != true);

        if (ikurra == '+') {
            emaitza = Zatikia.batu(zat1, zat2);
        } else if (ikurra == 'x' || ikurra == 'X') {
            emaitza = Zatikia.biderkatu(zat1, zat2);
        } else {
            System.out.println("Sartutako ikurrarekin ezin da eragiketarik egin.");
            System.out.println("Sartutako ikurra + edo x izan behar da!");
        }

        emaitza.sinplificatu();
        System.out.println(zat1.toString() + " " + ikurra + " " + zat2.toString() + " = " + emaitza);
        in.close();
    }

    public static boolean isNumeric(String cadenaString) {
        String[] cadena = cadenaString.split("/");
        try {
            Integer.parseInt(cadena[0]);
            Integer.parseInt(cadena[1]);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean isCorrectCharacter(char ikurra) {
        boolean ikurZuzena = false;
        if (ikurra == '+') {
            ikurZuzena = true;
        } else if (ikurra == 'x' || ikurra == 'X') {
            ikurZuzena = true;
        }
        return ikurZuzena;
    }
}
