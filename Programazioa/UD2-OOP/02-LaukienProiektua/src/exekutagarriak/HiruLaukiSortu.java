package exekutagarriak;
import model.Laukia;

public class HiruLaukiSortu {
    public static void main(String[] args) { // Program entry point
        // Declare and Construct an instance of the Circle class called c1
        Laukia l1 = new Laukia(7, 1); 
        Laukia l2 = new Laukia(2,2); // Use 3rd constructor
        Laukia l3 = new Laukia(2, 6); // Use 3rd constructor
        System.out.println("Hiru lauki sortu dituzu:");
        System.out.println(l1.toString() + " Mota: " + l1.getMota());
        System.out.println(l2.toString() + " Mota: " + l2.getMota());
        System.out.println(l3.toString() + " Mota: " + l3.getMota());

    }
}
