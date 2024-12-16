package hasierakoak;
import java.util.Scanner;

public class A17SquarePattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size;

        System.out.println("Select the size of the square: ");
        size= in.nextInt();
        in.close();
        // Outer loop to print each of the rows
        for (int row = 1; row <= size; row++) {  // row = 1, 2, 3, ..., size
            // Inner loop to print each of the columns of a particular row
            for (int col = 1; col <= size; col++) {  // col = 1, 2, 3, ..., size
            System.out.print( "* " );   // Use print() without newline inside the inner loop
            //......
            }
            // Print a newline after printing all the columns
            System.out.println();
        }
    }
}
