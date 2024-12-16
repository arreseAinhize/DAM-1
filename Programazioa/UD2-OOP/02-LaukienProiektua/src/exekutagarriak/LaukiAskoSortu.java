package exekutagarriak;
import java.util.Scanner;
import model.Laukia;

public class LaukiAskoSortu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Pregunta cuántos cuadrados se quieren crear
        System.out.println("Zenbat lauki sortu nahi dituzu? ");
        int lKop = in.nextInt();
        
        // Crea un array para almacenar los objetos Laukia
        Laukia[] laukiak = new Laukia[lKop];
        
        // Bucle para crear cada lauki
        for(int i = 0; i < lKop; i++) {
            laukiak[i] = new Laukia();
            System.out.println((i + 1) + ". laukiaren datuak:");
            
            System.out.print("Zabalera: ");
            laukiak[i].setZabalera(in.nextInt());
            System.out.print("Altuera: ");
            laukiak[i].setAltuera(in.nextInt());
        }
        in.close();

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Laukia", "Zabalera", "Altuera", "Azalera", "Perimetroa", "Mota");
        System.out.println("==============================================================");
        // Bucle para mostrar los datos de cada lauki
        for (int i = 0; i < lKop; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10s\n",i+1,laukiak[i].getZabalera(),laukiak[i].getAltuera(),laukiak[i].getAzalera(), laukiak[i].getPerimetroa(),laukiak[i].getMota());
        }
    }
}
