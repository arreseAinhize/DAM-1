package metodoak;
import java.util.Scanner;
public class Busqueda {
    public static void main(String[] args) {
        int key;
        Scanner in = new Scanner(System.in);
        int[] items = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100};  

        System.out.print("Enter the number you want to search: ");
        key = in.nextInt();
        in.close();
        
        System.out.println("The position of the number on the array is (if it return -1, means that the numbers is not on the array): " + search(items, key));
    }
    public static int search(int[] array, int key){
        int search = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == key) {
                search = i;
            }
        }
        return search;
    }

}
