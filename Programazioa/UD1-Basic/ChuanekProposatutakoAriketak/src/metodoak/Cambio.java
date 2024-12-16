package metodoak;
import java.util.Scanner;
import java.util.Arrays;
public class Cambio {
    public static void main(String[] args) {
        int[] array1,array2,arrayCambio;
        int length1,length2;
        Scanner in = new Scanner(System.in);
        System.out.print("Lehenengo arrayak zenbateko luzeera izango du? ");
        length1 = in.nextInt();
        array1 = new int[length1];        
        arrayCambio = new int[length1];
        System.out.print("Bigarren arrayak zenabteko luzeera izango du? ");
        length2 = in.nextInt();
        array2 = new int[length2];
        if (array1.length > 0) {
            System.out.print("Enter the value of all items (separated by space): ");
            for (int i = 0; i < array1.length; ++i) {
                array1[i] = in.nextInt();
            }
        }
        if (array2.length > 0) {
            System.out.print("Enter the value of all items (separated by space): ");
            for (int i = 0; i < array2.length; ++i) {
                array2[i] = in.nextInt();
            }
        }
        in.close();
        System.out.println("Aldaketa ahurretik:");
        System.out.println("Array 1: " +Arrays.toString(array1)+"\n"+"Array 2: "+Arrays.toString(array2));

        if(swap(array1,array2) == true){
            arrayCambio = array1;
            array1 = array2;
            array2 = arrayCambio;
            System.out.println("Aldaketaren ostean:");
            System.out.println("Array 1: " +Arrays.toString(array1)+"\n"+"Array 2: "+Arrays.toString(array2));
        }else{
            System.out.println("Ezin izan da aldaketarik egin.");
        }
        
    }
    public static boolean swap(int[] array1, int[] array2){
        boolean swap = false;
        if(array1.length == array2.length){
            swap = true;
        }
        return swap;
    }
}
