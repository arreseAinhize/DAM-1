package hasierakoak;
/**
 * Compute the sum and average of running integers from a lowerbound to an upperbound using loop.
 */
public class A05SumAverageRunningInt4 {   // Save as "SumAverageRunningInt.java"
   public static void main (String[] args) {
      // Define variables
      int sum = 0;          // The accumulated sum, init to 0
      final int LOWERBOUND = 1;
      final int UPPERBOUND = 100;

      for(int i =  LOWERBOUND ; i<=UPPERBOUND;i++){
         sum += i * i; // Calcula el cuadro de cada posicion de i y los va sumando
      }
      
      System.out.println("La suma de los cuadrados de los numeros entre " + LOWERBOUND + " y " + UPPERBOUND + ", es: " + sum);
   }
}