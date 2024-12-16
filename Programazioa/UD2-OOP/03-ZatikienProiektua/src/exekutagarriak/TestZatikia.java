package exekutagarriak;

import java.util.Scanner;

import model.Zatikia;

public class TestZatikia {
    public static void main(String[] args) {
        Zatikia zat = new Zatikia(); // <-- Metodo statikoak erabiltzeko
        Scanner in = new Scanner(System.in);
        System.out.print("Sartu zatiki bi espazio batez bananduta eta nik handiena zein den esango dizut: ");
        String sarrera = in.nextLine();

        // Zatikien sarrera banatzea
        String[] zatikiak = sarrera.split(" ");
        if (zatikiak.length != 2) {
            System.out.println("Mesedez, sartu bi zatiki espazio batez bananduta (adibidez: 3/2 4/6).");
            return;
        }

        // Zatikia objektuak sortzea
        Zatikia zatiki1 = new Zatikia(zatikiak[0]); // Lehen zatikia
        Zatikia zatiki2 = new Zatikia(zatikiak[1]); // Bigarren zatikia

        // Konparaketa
        if (zatiki1.isBiggerThan(zatiki2)) {
            System.out.println(zatiki1 + " zatikia " + zatiki2 + " zatikia baino handiagoa da.");
        } else if (zatiki2.isBiggerThan(zatiki1)) {
            System.out.println(zatiki2 + " zatikia " + zatiki1 + " zatikia baino handiagoa da.");
        } else {
            System.out.println("Bi zatikiak berdinak dira.");
        }

        // Biderketa
        System.out.println("Zatikien biderkadura: "+zat.biderkatu(zatiki1, zatiki2));
        
        //Batuketa
        System.out.println("Zatikien batuketa: " +zat.batu(zatiki1, zatiki2));
        zatiki1.batu(zatiki2);

        //MKT eta ZKH
        System.out.println("Zatikien izendatzaileen MKT: "+zat.mkt(zatiki1.getIzendatzailea(), zatiki2.getIzendatzailea()));
        System.out.println("Zarikien izendatzaileen ZKH: "+zat.zkh(zatiki1.getIzendatzailea(), zatiki2.getIzendatzailea()));
        
        //Faktorizazioa
        System.out.print("1. zatikiaren faktorizazioa: ");
        int[] emaitzak = zat.faktorizatu((int)zatiki1.hamartarBaliokidea());
        for(int i = 0; i<emaitzak.length;i++){
            System.out.print(emaitzak[i]);
        }

        in.close();
    }
}
