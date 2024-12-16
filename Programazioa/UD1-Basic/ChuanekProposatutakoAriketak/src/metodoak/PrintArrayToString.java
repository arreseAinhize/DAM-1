package metodoak;
import java.util.Arrays;
public class PrintArrayToString {
    public static String arrayToString(int[] array){
        return Arrays.toString(array);
    }   
    
    public static void main(String[] args) {
        // Declare Arrays
        int[] intArryEmpt={};  
        int[] intArrySing={5};  
        int[] intArryMult={5,10,15,20,25}; 
                
        System.out.println("INT ARRYS");
        System.out.println("Empty array: "+ arrayToString(intArryEmpt));
        System.out.println("One-element array: "+ arrayToString(intArrySing));
        System.out.print("N-element array: "+ arrayToString(intArryMult));
    }
}
