package hasierakoak;
/**
 * Trying nested-if and switch-case statements.
 */
public class A04PrintDayInWord  {   // Save as "PrintNumberInWord.java"
   public static void main(String[] args) {
      int number = 5;  // Set the value of "number" here!

      // Using nested-if
      System.out.println("Nested-if <- erabiliz:");
      if (number == 1) {   // Use == for comparison
         System.out.println( "ASTELEHENA" );
      } else if ( number == 2 ) {
         System.out.println("ASTEARTE / MARTITZENA");

      } else if ( number == 3 ) {
         System.out.println("ASTEAZKENA / EGUENA");

      } else if(number == 4){
         System.out.println("OSTEGUNA / EGUAZTENA");

      } else if (number == 5) {
         System.out.println("OSTIRALA / BARIKUA");

      }else if (number == 6) {
         System.out.println("LARUNBATA / ZAPATUA");

      }else if (number == 7) {
         System.out.println("IGANDEA / DOMEKA");
      }else{
         System.out.println("Ez da balio duen egun bat!");
      }

      number = 9;
      System.out.println(" ");
      System.out.println("Switch-case-default <- erabiliz:");
      // Using switch-case-default
      switch(number) {
         case 1: 
            System.out.println( "ASTELEHENA" ); break;  // Don't forget the "break" after each case!
         case 2: 
            System.out.println( "ASTEARTE / MARTITZENA" ); break;
         case 3: 
            System.out.println( "ASTEAZKENA / EGUENA" ); break;
         case 4: 
            System.out.println( "OSTEGUNA / EGUAZTENA" ); break;
         case 5:
            System.out.println("OSTIRALA / BARIKUA"); break;
         case 6:
            System.out.println("LARUNBATA / ZAPATUA");break;
         case 7:
            System.out.println("IGANDEA / DOMEKA");break;
         default: System.out.println( "Ez da balio duen egun bat!" ); 
      }
   }
}