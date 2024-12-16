package exekutagarriak;

import java.util.Scanner;
import java.util.Random;
import model.Zatikia;

public class Ariketa {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Random auzaRandom = new Random();

        Zatikia zat1 = new Zatikia();
        Zatikia zat2 = new Zatikia();
        char[] ikurrak = { '+', '*' };
        boolean balidatu = false;

        System.out.println("-----------");
        System.out.println(" ARIKETAK");
        System.out.println("-----------");
        System.out.println(" Gogoratu emaitza, X/Y formatuan sartu behar dela.");

        do {
            zat1.setZenbakitzaile(auzaRandom.nextInt(10) + 1);
            zat1.setIzendatzaile(auzaRandom.nextInt(10) + 1);

            zat2.setZenbakitzaile(auzaRandom.nextInt(10) + 1);
            zat2.setIzendatzaile(auzaRandom.nextInt(10) + 1);

            char ikurra = ikurrak[auzaRandom.nextInt(ikurrak.length)];
            System.out.print(zat1.toString() + " " + ikurra + " " + zat2.toString() + " = ");
            String sarrera = in.nextLine();
            Zatikia emaitzaErabiltzailea = new Zatikia(sarrera);
            if (egiaztatu(zat1, zat2, ikurra, emaitzaErabiltzailea) == true) {
                balidatu = true;
                System.out.println("OSO ONDO!!");
            } else if (egiaztatu(zat1, zat2, ikurra, emaitzaErabiltzailea) == false) {
                balidatu = false;
                System.out.println("Saiatu berriz");
            }
        } while (balidatu == false);
        in.close();
    }

    public static boolean egiaztatu(Zatikia z1, Zatikia z2, char erag, Zatikia zErantzuna) {
        boolean emaitza = true;
        if (erag == '+') {
            if (zErantzuna.hamartarBaliokidea() == Zatikia.batu(z1, z2).hamartarBaliokidea()) {
                emaitza = true;
            } else {
                emaitza = false;
            }
        } else if (erag == '*') {
            if (zErantzuna.hamartarBaliokidea() == Zatikia.biderkatu(z1, z2).hamartarBaliokidea()) {
                emaitza = true;
            } else {
                emaitza = false;
            }
        }
        return emaitza;
    }
}