package hasierakoak;

import java.util.Scanner;   // For keyboard input


public class A11SphereComputation  {
    public static void main(String[] args) {
        float radius;
        double surfaceArea,volume;
        Scanner inf = new Scanner(System.in);

        // Prompt and read inputs
        System.out.print("Enter the radius: ");
        radius = inf.nextFloat();  // read input as float
        inf.close();

        // Kalkuluak
        surfaceArea = 4 * Math.PI * radius * radius;
        volume = 4 /3 * Math.PI * radius * radius * radius;   

        // Print results using printf() with the following format specifiers:
        //   %.2f 2 decimal ataratzen ditu doublean.
        //   %n salta de linea
        System.out.printf("Surface area is: %.2f%n", surfaceArea);
        System.out.printf("Volume is: %.2f%n", volume);
    }
}

