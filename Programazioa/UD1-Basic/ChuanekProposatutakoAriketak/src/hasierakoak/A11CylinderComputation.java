package hasierakoak;
import java.util.Scanner;

public class A11CylinderComputation {
    public static void main(String[] args) {
        float radius,height;
        double surfaceArea,volume,baseArea;
        Scanner inf = new Scanner(System.in);

        // Prompt and read inputs
        System.out.print("Enter the radius: ");
        radius = inf.nextFloat();  // read input as float
        System.out.print("Enter the height: ");
        height = inf.nextFloat();
        inf.close();

        // Kalkuluak
        baseArea = Math.PI * radius * radius;
        surfaceArea = 2.0 * Math.PI * radius + 2.0 * baseArea;
        volume = baseArea * height;  

        // Print results using printf() with the following format specifiers:
        //   %.2f 2 decimal ataratzen ditu doublean.
        //   %n salta de linea
        System.out.printf("Base area is: %.2f%n", baseArea);
        System.out.printf("Surface area is: %.2f%n", surfaceArea);
        System.out.printf("Volume is: %.2f%n", volume);
    }
}
