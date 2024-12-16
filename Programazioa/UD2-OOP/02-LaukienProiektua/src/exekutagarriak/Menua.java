package exekutagarriak;

import java.util.Scanner;
import model.Laukia;

public class Menua {
    // (static) Sartute errorie ez emoteko eta funcionetan dau XD
    private static final int LAUKI_KOP = 10; // Max 10 lauki gorde/sortu
    private static int sortutakoak = 0; // Sortuta dekoguzan lauki kopuruak jakiteko
    private static Laukia[] laukiak = new Laukia[LAUKI_KOP]; // "Laukien" arraya (nunun gorde bihar die.)
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int aukera = 0;
        do {
            System.out.println("\nZER EGIN NAHI DUZU?");
            System.out.println("==========================");
            System.out.println("1.- Lauki berria sortu\n2.- Laukien taula ikusi\n3.- Lauki bat marraztu\n4.- Lauki handiena bilatu\n5.- Irten\n");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    if (sortutakoak >= LAUKI_KOP) {
                        System.out.println("Ezin dituzu lauki gehiago sortu.");
                    } else {
                        sortu();
                    }
                    break;
                case 2:
                    imprimatu();
                    break;
                case 3:
                    marraztu();
                    break;
                case 4:
                    handiena();
                    break;
                case 5:
                    System.out.println("Eskerrik asko zure denborarengatik, AGUR!");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriro.");
            }
        } while (aukera != 5);
    }
    // (static) Sartute errorie ez emoteko eta funcionetan dau XD
    // Lauki berri bat sortu 
    public static void sortu() {
        Laukia l1 = new Laukia();
        System.out.print("Sartu laukiaren zabalera: ");
        l1.setZabalera(in.nextInt());
        System.out.print("Sartu laukiaren altuera: ");
        l1.setAltuera(in.nextInt());
        laukiak[sortutakoak++] = l1;
        System.out.println("Lauki " + l1.getMota() + " sortu duzu: => " + l1.toString());
    }
    // Taula imprimatu
    public static void imprimatu() {
        if (sortutakoak == 0) {
            System.out.println("Ez dago lauki sorturik.");
            return;
        }else{
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Laukia", "Zabalera", "Altuera", "Azalera", "Perimetroa", "Mota");
            System.out.println("==============================================================");
            for (int i = 0; i < sortutakoak; i++) {
                System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10s\n", i + 1, laukiak[i].getZabalera(), laukiak[i].getAltuera(), laukiak[i].getAzalera(), laukiak[i].getPerimetroa(), laukiak[i].getMota());
            }
        }
    }
    // Laukia Marraztu
    public static void marraztu() {
        if (sortutakoak == 0) {
            System.out.println("Ez dago lauki sorturik.");
            return;
        }else{
            System.out.println("Zein lauki nahi duzu marraztu? (1-" + sortutakoak + ")");
            int index = in.nextInt() - 1;
            if (index >= 0 && index < sortutakoak) {
                System.out.println("Beteta ala hutsik (B/H)?");
                char nola = in.next().charAt(0);
                if(nola == 'B' || nola == 'b'){
                    laukiak[index].marraztuBeteta();
                }else if(nola == 'H' || nola == 'h'){
                    laukiak[index].marraztuHutzik();
                }else{
                    System.out.println("Ezi da era horretara marraztu!");
                }
            } else {
                System.out.println("Lauki zenbakia okerra.");
            }
        }
    }
    // Lauki handia bilatu
    public static void handiena() {
        if (sortutakoak == 0) {
            System.out.println("Ez dago lauki sorturik.");
            return;
        }
        Laukia handiena = Laukia.getTheBiggest(laukiak);
        System.out.println("Laukirik handiena: " + handiena.toString());
    }
}
