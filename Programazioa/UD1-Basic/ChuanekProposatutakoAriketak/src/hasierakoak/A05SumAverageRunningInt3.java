package hasierakoak;
/**
 * Compute the sum and average of running integers from a lowerbound to an upperbound using loop.
 */
public class A05SumAverageRunningInt3 {   // Save as "SumAverageRunningInt.java"
   public static void main (String[] args) {
      // Define variables
      int sum = 0;          // The accumulated sum, init to 0
      double average;       // average in double
      final int LOWERBOUND = 111;
      final int UPPERBOUND = 8899;
      
      // int number = LOWERBOUND;  <-- No es necesario
      //int count = -1; // empezamos a contar desde 0, no desde -1 
      int count = 0;
      for(int i =  LOWERBOUND ; i<=UPPERBOUND;i++){
         // sum += number; <-- No utilizar number, tenemos la variable de i
         // ++number; <-- no es necesario utilizarlo
         sum += i; // <-- utilizando el variable i es mas que suficiente
         ++count;
      }
      
      average = (double)sum / UPPERBOUND;

      System.out.println("La suma total de los numeros entre " + LOWERBOUND + " y " + UPPERBOUND + ", es: " + sum );
      System.out.println("El average es :" + average + " y hay " + count + " numeros entre " + LOWERBOUND + " y " + UPPERBOUND);
   }
}