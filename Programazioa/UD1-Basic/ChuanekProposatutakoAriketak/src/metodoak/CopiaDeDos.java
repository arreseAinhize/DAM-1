package metodoak;
import java.util.Arrays;
import java.util.Scanner;
public class CopiaDeDos {
    public static void main(String[] args) {
        int[] arrayOfi ={5,4,6,7,8,9};
        int luzera;
        Scanner in = new Scanner(System.in);
        System.out.print("Zenbateko luzeera izatea nahi buzu array berriak? ");
        luzera = in.nextInt();
        in.close();
        System.out.println("Inicial INT array: " + Arrays.toString(arrayOfi));
        System.out.println("Copy array: " + Arrays.toString(copyOf(arrayOfi,luzera)));
    }
    public static int[] copyOf(int[] array, int newLength){
        int[] copyArray;
        copyArray = new int[newLength];
        if(newLength>array.length){
            
        }
        for(int i = 0; i<copyArray.length;i++){
            for(int x = 0; x<array.length;x++){
                    copyArray[i]=array[i];
            }
            if (copyArray.length>array.length) {
                copyArray[i]=0;
            }    
        }
        return copyArray;
    }
}
