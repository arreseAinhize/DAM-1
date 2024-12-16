package hasierakoak;
import java.util.Scanner;

public class A19TimeTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Sartu taulare tamaina: ");
        int size = in.nextInt();

        // CABECERA
        System.out.printf(" * |");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        // SEPARADOR
        System.out.print("---+");
        for (int i = 1; i <= size; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Tabla de multiplicar
        for (int row = 1; row <= size; row++) {
            // Encabezado
            System.out.printf("%2d |", row);
            // Celdas
            for (int col = 1; col <= size; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();
        }
        in.close();
    }
}
