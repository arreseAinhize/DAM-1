package aceptaelreto;
import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int entrada ;
        entrada = in.nextInt();
        in.close();
        for(int i = 1; i <= entrada ; i++){      
            System.out.println("Hola mundo!");
        }
    }
}
