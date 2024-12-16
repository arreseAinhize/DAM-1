package arrayak;
import java.util.Scanner;
public class A02PrintArrayInStars {
    public static void main(String[] args) {
        // Declare variables
        Scanner in = new Scanner(System.in);
        final int NUM_ITEMS;
        int[] items;  // Declare array name, to be allocated after NUM_ITEMS is known

        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();
        // Allocate the array
        items = new int[NUM_ITEMS];
        // Prompt and read the items into the "int" array, if array length > 0
        if (items.length > 0) {
            System.out.print("Enter the value of all items (separated by space): ");
            for (int i = 0; i < items.length; ++i) {
                items[i] = in.nextInt();
            }
        }
        in.close();
        // Print array in "index: number of stars" using a nested-loop
        // Take note that rows are the array indexes and columns are the value in that index
        for (int row = 0; row < items.length; ++row) {  // row
            System.out.print(row + ": ");
            // Print value as the number of stars
            for (int column = 1; column <= items[row]; ++column) {  // column
                System.out.print("*");
            }
            if (row == 0) {
                // Print the first item without a leading commas
                System.out.println(" ("+items[0]+ ")");
            } else {
                // Print the subsequent items with a leading commas
                System.out.println(" ("+items[row]+")");
            }
        }
    }
}
