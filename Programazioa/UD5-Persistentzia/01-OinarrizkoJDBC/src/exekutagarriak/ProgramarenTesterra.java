package exekutagarriak;

import java.util.List;
import java.util.Scanner;
import model.HerrienAtzipenak;
import model.base.Herria;

/**
 * Programaren testatzaile klasea, erabiltzaileak hainbat aukeratan datu-baseko 
 * herrien informazioa kudeatzeko eta erakusteko aukera ematen du.
 */
public class ProgramarenTesterra {
    // Menuko aukera gustiak egin ahal izateko, ikaslea erabiltzaileak hurrengo baimenak izan behar ditu datu basean: SELECT, INSERT eta DELETE.
    private static HerrienAtzipenak atzipenak = new HerrienAtzipenak("localhost", "HerrienDBa", "Herriak", "ikaslea", "ikaslea");
    private static Scanner in = new Scanner(System.in);

    /**
     * Programaren hasiera. Menuko aukerak erakusten ditu eta erabiltzaileak 
     * aukeratutako ekintza exekutatzea kudeatzen du.
     * @param args Programaren argumentuak (ez da erabiltzen).
     */
    public static void main(String[] args) throws InterruptedException {
    
        int aukera;
        while (true) {
            kontsolaGarbitu();
            System.out.println("\n=========================================");
            System.out.println("              MENU NAGUSIA         ");
            System.out.println("=========================================");
            System.out.println(" 1 - Herri berri bat txertatu");
            System.out.println(" 2 - Herriak bistaratu");
            System.out.println(" 3 - Probintzia bateko herriak bistaratu");
            System.out.println(" 4 - Herri baten probintzia erakutsi");
            System.out.println(" 5 - Herri guztien izenak bistaratu");
            System.out.println(" 6 - Herri bat ezabatu");
            System.out.println(" 7 - Menua itxi");
            System.out.println("=========================================");
            System.out.print("Aukeratu aukera: ");

            aukera = in.nextInt();
            in.nextLine();

            switch (aukera) {
                case 1:
                    herriaTxertatu();
                    Thread.sleep(2000);
                    break;
                case 2:
                    herriakBistaratu();
                    Thread.sleep(2000);

                    break;
                case 3:
                    probintziakoHerriakBistaratu();
                    Thread.sleep(2000);

                    break;
                case 4:
                    herriarenProbintziaErakutsi();
                    Thread.sleep(2000);

                    break;
                case 5:
                    herriGuztienIzenakBistaratu();
                    Thread.sleep(2000);

                    break;
                case 6:
                    herriaEzabatu();
                    Thread.sleep(2000);

                    break;
                case 7:
                    System.out.println("Programatik irteten...");
                    in.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Aukera okerra! Saiatu berriro.");
                    Thread.sleep(2000);

                    break;
            }
        }
    
    }
    
    // Metodoen definizioak

    /**
     * Erabiltzaileak sartutako herri berri bat datu-basean txertatzen du.
     */
    public static void herriaTxertatu() {
        System.out.print("Sartu herriaren izena: ");
        String herria = in.nextLine();
        System.out.print("Sartu probintziaren izena: ");
        String probintzia = in.nextLine();
        atzipenak.txertatu(new Herria(herria, probintzia));
    }

    /**
     * Datu-basean dauden herriak bistaratzen ditu.
     */
    public static void herriakBistaratu() {
        atzipenak.erakutsiDatuak();
    }

    /**
     * Erabiltzaileak sartutako probintziako herriak bistaratzen ditu.
     */
    public static void probintziakoHerriakBistaratu() {
        System.out.print("Sartu probintziaren izena: ");
        String probintzia = in.nextLine();
        List<String> herriak = atzipenak.getProbintziaBatekoHerriak(probintzia);
        if (herriak.isEmpty()) {
            System.out.println("Ez dago herririk probintzia honetan.");
        } else {
            System.out.println(probintzia + " probintziako herriak:");
            for (String herria : herriak) {
                System.out.println("- " + herria);
            }
        }
    }

    /**
     * Erabiltzaileak sartutako herriaren probintzia erakusten du.
     */
    public static void herriarenProbintziaErakutsi() {
        System.out.print("Sartu herriaren izena: ");
        String herria = in.nextLine();
        String probintzia = atzipenak.getProbintzia(herria);
        if (probintzia != null) {
            System.out.println(herria + " herria " + probintzia + " probintzian dago.");
        } else {
            System.out.println("Ez da aurkitu herri hau datu-basean.");
        }
    }

    /**
     * Datu-baseko herri guztien izenak bistaratzen ditu.
     */
    public static void herriGuztienIzenakBistaratu() {
        List<String> herriak = atzipenak.getHerriIzenak();
        if (herriak.isEmpty()) {
            System.out.println("Ez dago herririk datu-basean.");
        } else {
            System.out.println("Datu-baseko herriak:");
            for (String herria : herriak) {
                System.out.println("- " + herria);
            }
        }
    }

    /**
     * Erabiltzaileak sartutako herri bat datu-basean ezabatzen du.
     */
    public static void herriaEzabatu() {
        System.out.print("Sartu ezabatu nahi duzun herriaren izena: ");
        String herria = in.nextLine();
        System.out.print("Sartu probintziaren izena: ");
        String probintzia = in.nextLine();
        atzipenak.ezabatu(new Herria(herria, probintzia));
    }

    /**
     * Programaren kontsola garbitsen du.
     */
    public static void kontsolaGarbitu() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}
