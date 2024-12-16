package hasierakoak;

/**
 * Trying if-else statement and modulus (%) operator.
 */
public class A02CheckOddEven {   // Save as "CheckOddEven.java"
   public static void main(String[] args) {  // Program entry point
      int number = 1;       // Set the value of "number" here!
      System.out.println("The number is " + number);
      if ( number % 2 == 0 ) {
         System.out.println( "it's even number" );   // Numeros pares
      } else {
         System.out.println( "it's odd number" );   // Numeros impares
      }
      System.out.println( "bye!" );
   }
}