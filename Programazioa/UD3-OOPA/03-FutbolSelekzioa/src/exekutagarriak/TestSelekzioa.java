package exekutagarriak;

import model.*;
import java.util.Scanner;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestSelekzioa {
    public static void main(String[] args) {
        Selekzioa euskalSel = new Selekzioa("Euskadi");
        Scanner in = new Scanner(System.in);

        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUA");
            System.out.println("====================================");
            System.out.println("*  1. Kideen datuak ikusi");
            System.out.println("*  2. Kideen datuak ikusi taldekatuta");
            System.out.println("*  3. Kideak alfabetikoki inprimatu");
            System.out.println("*  4. Aldaketa");
            System.out.println("*  5. Bilatu abizenetik");
            System.out.println("*  6. Futbolariak alfabetikoki inprimatu");
            System.out.println("*  7. Irten\n");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    System.out.println("====================================");
                    euskalSel.kideakBistaratu();
                    break;
                case 2:
                    System.out.println("====================================");
                    euskalSel.kideakTaldekatutaBistaratu();
                    break;
                case 3:
                    System.out.println("====================================");
                    break;
                case 4:
                    System.out.println("====================================");
                    break;
                case 5:
                    System.out.println("====================================");
                    System.out.println("Sartu abizena:");
                    String abizena = in.next();
                    
                    if(euskalSel.getKideenAbizenak().equals(abizena)){

                    }

                    break;
                case 6:
                    System.out.println("====================================");
                    break;
                case 7:
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }

        } while (aukera != 5);
        in.close();
    }
}
