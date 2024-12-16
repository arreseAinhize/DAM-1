package metodoak;
import java.util.Arrays;
public class Vuelta {
    public static void main(String[] args) {
        int[] arrayOfi = {1,2,3,4};
        System.out.println(Arrays.toString(arrayOfi));

        reverse(arrayOfi);

        System.out.print("Reversed array: ");
        printReverseArray(arrayOfi);
    }

    public static void reverse(int[] array){
        for (int fIdx = 0, bIdx = array.length - 1; fIdx < bIdx; ++fIdx, --bIdx) {
        // Swap array[fIdx] and array[bIdx]
        // Only need to transverse half of the array elements
        int temp = array[fIdx];
        array[fIdx] = array[bIdx];
        array[bIdx] = temp;
        }
    }

    public static void printReverseArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
