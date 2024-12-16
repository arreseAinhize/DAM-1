package hasierakoak.oinarria;
/*
 * sum's all the running integers from 1 and 1000, that are divisible by 3, 5 or 7, but NOT by 15, 21, 35 or 105.
 */
public class Condicional1 {  
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 1000; i++) { // hace un bucle hasta al 1000
            if ((i % 3 == 0 || i % 5 == 0 || i % 7 == 0) && //Coge por buenas las opciones divididas entre 3-5-7
                    !(i % 15 == 0 || i % 21 == 0 || i % 35 == 0 || i % 105 == 0)) { //Descarta las opciones divididas entre 15-21-35-105
                sum += i;
            }

            /*
             * B MODUA:
             * 
             * if ((i % 3 == 0 || i % 5 == 0 || i % 7 == 0) && //Coge por buenas las opciones divididas entre 3-5-7
                    (i % 15 == 0 || i % 21 == 0 || i % 35 == 0 || i % 105 == 0)) { //Descarta las opciones divididas entre 15-21-35-105
                //Ez du ezer egingo!
                }else{
                sum += i;
                }
             */
        }
        System.out.println("La suma de los numeros es: " + sum);
    }
}