package metodoak;
import java.util.Arrays;

public class CopiaDe {
    public static void main(String[] args) {
        int[] arrayOfi ={5,4,6,7,8,9};
        System.out.println("Inicial INT array: " + Arrays.toString(arrayOfi));
        System.out.println("Copy array: " + Arrays.toString(copyOf(arrayOfi)));
    }
    public static int[] copyOf(int[] array){
        int[] copyArray;
        copyArray = new int[array.length];
        for(int i = 0; i<array.length;i++){
            for(int x = 0; x<copyArray.length;x++){
                copyArray[i]=array[i];
            }
        }
        return copyArray;
    }
}
