package arrayak;
// import java.util.Arrays; // Array.blablabla erabilitzeko
import java.util.Scanner;
public class A03GradesStatistics02 {
    public static void main(String[] args) {
        //Declare variables
        final int NUM_ITEMS;
        int[] items;  // Declare array name, to be allocated after NUM_ITEMS is known
        int sum = 0,min=0,max=100;
        double average = 0;

        //Empezar a pedir notas
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();
        // Allocate the array
        items = new int[NUM_ITEMS];
        // Prompt and read the items into the "int" array, if array length > 0
        if (items.length > 0) {
            for (int i = 0; i < items.length; ++i) {
                i++;
                System.out.print("Enter the grade for student " + i + " (0-100):");
                i--;
                items[i] = in.nextInt();
                sum += items[i];
                if(items[i]>max){ // max = Arrays.stream(items).max().getAsInt();
                    max = items[i];
                }
                if(items[i]<min){ // min = Arrays.stream(items).min().getAsInt();
                    min = items[i];
                }
            }
        }
        in.close();
        average = (double)sum/items.length;
        System.out.printf("The average is: %.2f\n",average);//dos decimales
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}