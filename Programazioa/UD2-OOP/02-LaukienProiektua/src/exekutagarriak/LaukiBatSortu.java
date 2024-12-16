package exekutagarriak;
import java.util.Scanner;
import model.Laukia;

public class LaukiBatSortu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Laukia l1 = new Laukia();
        System.out.print("Sartu laukiaren zabalera: ");
        l1.setZabalera(in.nextInt());
        System.out.print("Sartu laukiaren altuera: ");
        l1.setAltuera(in.nextInt());
        // Sortutako laukia printeatu
        System.out.println("Lauki " + l1.getMota() + " sortu duzu: => " + l1.toString());
    
        //Laukia marraztu
        System.out.println("Hona marrazkia beteta:");
        l1.marraztuBeteta();

        System.out.println("Hona marrazkia hutsik:");
        l1.marraztuHutzik();

        System.out.println("LAUKI BETEA:");
        System.out.print(l1.laukiBetea());
        // laukiBetea -- toString metodoa moduan printeatu egin behar da.

        System.out.print("Zein ikurrekin nahi duzu laukia bete? ");
        l1.marraztuBeteta(in.next().charAt(0));
        in.close();

    }
}
