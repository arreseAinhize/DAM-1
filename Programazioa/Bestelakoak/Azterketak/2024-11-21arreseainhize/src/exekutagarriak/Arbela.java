package exekutagarriak;

import java.util.Scanner;

public class Arbela {
/**
 *    Metodo honek karratu bat marrazten du kontsolan.
 *  Horretarako erabiltzilearei pitzela (marrazteko karekteraea) eta
 *  tamaina sartzeko eskatzen dizkio.
*/
        public static void main(String[] args) {

        char pintzela,balioztatu;
        int tamaina,ertza,karratuZenbakia = 1;

        Scanner in = new Scanner(System.in);
        System.out.println("KARRATUA MARRAZTEKO ARBELA");
        System.out.println("==========================");
        do {
            System.out.println(karratuZenbakia + ". KARRATUA:");
            System.out.println("------------------");

            System.out.print("Zein pintzelekin nahi duzu marraztu? ");
            pintzela = in.next().toUpperCase().charAt(0);

            System.out.print("Zein tamainako karratua izango da? ");
            tamaina= in.nextInt();
            
            System.out.print("Ertza izatea nahi baduzu esan zenbatekoa, bestela, idatzi 0: ");
            ertza = in.nextInt();

            if(ertza != 0){
                KarratuaMarraztu(pintzela, tamaina, ertza);
            }else{
                KarratuaMarraztu(pintzela, tamaina);
            }

            System.out.print("Beste karratu bat marraztu nahi duzu? (B/E) ");
            balioztatu = in.next().toUpperCase().charAt(0);

            karratuZenbakia++;
        } while (balioztatu == 'B');
        System.out.print("Eskerrik asko arbela erabiltzearren.");

        in.close();
    }

/** 
 *  Karraua hutsunerik gabe bueltatzen duen metodoa.
*/
    public static void KarratuaMarraztu(char pintzela, int tamaina){
        for (int col = 1; col <= tamaina; col++) {
            for (int row = 1; row <= tamaina; row++) {
                System.out.print(pintzela + " ");
            }
            System.out.println();
        }
    }

/** 
 *  Karraua hutzenearekin bueltatzen duen metodoa.
*/
    public static void KarratuaMarraztu(char pintzela, int tamaina, int ertza){
        for (int col = 1; col <= tamaina; col++) {
            for (int row = 1; row <= tamaina; row++) {
                if ((((row <= ertza) ||(row> tamaina-ertza)) || row == tamaina || ((col <= ertza) || (col > tamaina-ertza)) || col == tamaina)) {
                    System.out.print(pintzela+" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
