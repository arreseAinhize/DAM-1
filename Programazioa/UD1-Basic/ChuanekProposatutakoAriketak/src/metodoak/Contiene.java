package metodoak;
import java.util.Scanner;
public class Contiene {
    public static void main(String[] args) {
        final int key = 81;
        Scanner in = new Scanner(System.in);
        final int NUM_ITEMS;
        int[] items;  
        
        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();

        items = new int[NUM_ITEMS];

        if (items.length > 0) {
            System.out.print("Enter the value of all items (separated by space): ");
            for (int i = 0; i < items.length; ++i) {
                items[i] = in.nextInt();
            }
        }
        in.close();
        
        System.out.println("The array contains the given key? " + contains(items, key));

    }
    public static boolean contains(int[] array, int key){
        boolean contains = false;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == key) {
                contains = true;
            }
        }
        return contains;
    }
}
