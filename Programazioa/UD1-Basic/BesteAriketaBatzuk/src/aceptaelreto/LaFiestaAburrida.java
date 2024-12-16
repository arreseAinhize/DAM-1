package aceptaelreto;

import java.util.Scanner;

public class LaFiestaAburrida {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int numPersonas = in.nextInt();
      in.nextLine();

      for (int i = 0; i < numPersonas; i++) {
         String linea = in.nextLine();

         String[] partes = linea.split(" ");
         String nombre = partes[1];

         System.out.println("Hola, " + nombre + ".");
      }

      in.close();
   }
}