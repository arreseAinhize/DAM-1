package exekutagarriak;

import java.util.Scanner;
import model.Pelikula;

public class TestPelikula {
/**
 *    Metodo honek erabiltzaileak sarturiko pelikuletatik luzeena kontsolaratuko du.
 *  Horretarako erabiltzailearei pelikularen izenburua, estrenaildi urtea eta iraupera.
 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String izenburua, pelikulaDatuak;
        int urtea, iraupena;

        Pelikula p1 = new Pelikula();
        System.out.print("Idatzi gogoko duzun pelikula baten izenburua? ");
        p1.setIzenburua(in.nextLine());
        System.out.print("Zein urtetakoa da? ");
        p1.setUrtea(in.nextInt());
        System.out.print("Eta iraupena badakizu? ");
        p1.setIraupena(in.nextInt());
        Pelikula p2 = new Pelikula();
        System.out.print("Orain beste pelikula bat baina lerro bakarrean, komaz bananduta: ");
        pelikulaDatuak = in.next();
        String[] peli = pelikulaDatuak.split(",");
        izenburua = peli[0];
        urtea = Integer.parseInt(peli[1]); // Zenbakitzailea gordetzen da
        iraupena = Integer.parseInt(peli[2]);
        p2.setIzenburua(izenburua);
        p2.setUrtea(urtea);
        p2.setIraupena(iraupena);

        System.out.println("Lehen pelikula: " + p1.toString());
        System.out.println("Bigarren pelikula: " + p2.toString());

        if(p1.isLongerThan(p2)){
            System.out.println("Lehenengo pelikula bigarrena baino luzeagoa da.");
        }else{
            System.out.println("Bigarren pelikula lehenengoa baino luzeagoa da.");

        }
        in.close();
    }
}
