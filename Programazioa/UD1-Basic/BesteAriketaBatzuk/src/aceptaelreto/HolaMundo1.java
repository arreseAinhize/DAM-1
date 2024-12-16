/*
 *  La entrada consta de una única línea que contiene un número n, 0 ≤ n ≤ 5, que indica cuántos mensajes hay que emitir.
 */
package aceptaelreto;
import java.util.Scanner;

public class HolaMundo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int entrada ;
        boolean validation = false;        

        do{
            System.out.print("Zenbat esaldi nahi dituzu?(1-5) ");
            entrada = in.nextInt();
            if(0 < entrada && entrada <=5){
                for(int i = 1; i <= entrada ; i++){      
                    System.out.println("Hola Mundo!");
                }
                validation = true;
            }else{
                System.out.println("Error! Ez da posible esaldi kantitate horai ateratzea! zahiatu berriro.");
            }
        }while (!validation);
        in.close();
    }
}
