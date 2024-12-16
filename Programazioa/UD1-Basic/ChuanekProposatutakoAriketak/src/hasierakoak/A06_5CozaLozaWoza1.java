package hasierakoak;
public class A06_5CozaLozaWoza1 { // Save as "CozaLozaWoza.java"
   public static void main(String[] args) {
      final int LOWERBOUND = 1, UPPERBOUND = 110;
      for (int number = LOWERBOUND; number <= UPPERBOUND; ++number) {
      //    if (number % 3 == 0 && number % 5 == 0) {
      //       System.out.print("CozaLoza ");
      //    }else if(number % 3 == 0 && number % 7 == 0){
      //       System.out.print("CozaWoza ");
      //    } else if (number % 11 == 0) {
      //       if (number % 3 == 0) {
      //          System.out.print("Coza ");
      //          System.out.println();
      //       } else {
      //          System.out.print(number);
      //          System.out.println();
      //       }
      //    } else if (number % 5 == 0) {
      //       System.out.print("Loza ");
      //    } else if (number % 7 == 0) {
      //       System.out.print("Woza ");
      //    } else if (number % 3 == 0) {
      //       System.out.print("Coza ");
      //    } else {
      //       System.out.print(number + " ");
      //    }

         if (number % 3 == 0 && number % 5 == 0) {
            System.out.print("CozaLoza ");
         }
         if(number % 3 == 0 && number % 7 == 0){
            System.out.print("CozaWoza ");
         }
         if (number % 11 == 0) {
            if (number % 3 == 0) {
               System.out.print("Coza ");
               System.out.println();
            } else {
               System.out.print(number);
               System.out.println();
            }
         }
         if (number % 5 == 0) {
            System.out.print("Loza ");
         }
         if (number % 7 == 0) {
            System.out.print("Woza ");
         }
         if (number % 3 == 0) {
            System.out.print("Coza ");
         } else {
            System.out.print(number + " ");
         }
      }
   }
}