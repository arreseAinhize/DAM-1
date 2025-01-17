package exekutagarriak;

import model.*;
import java.util.Scanner;

public class ZirkuluaSortu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double erradioa, altuera;
        String mota, kolorea;

        System.out.print("Zirkulu arrunta edo zilindroa sortu nahi duzu(a/z)? ");
        mota = in.next();

        if(mota.toLowerCase().charAt(0) == 'a'){
            System.out.print("Zein izango da bere erradioa? ");
            erradioa = in.nextDouble();
            System.out.print("Zein izango da bere kolorea? ");
            kolorea = in.next();

            Circle c1 = new Circle(erradioa, kolorea);
            System.out.println("\n Hauek dira sortutako ZIRKULUAren ezaugarriak:");
            System.out.println("   Erradioa: "+ c1.getRadius());
            System.out.println("   Kolorea: "+ c1.getColor());
            System.out.println("   Azalera: "+ c1.getArea());

        }else if(mota.toLowerCase().charAt(0) == 'z'){
            System.out.print("Zein izango da bere erradioa? ");
            erradioa = in.nextDouble();
            System.out.print("Zein izango da bere kolorea? ");
            kolorea = in.next();
            System.out.print("Zein izango da bere altuera? ");
            altuera = in.nextDouble();

            Cylinder cy1 = new Cylinder(altuera, erradioa, kolorea);
            System.out.println("\n Hauek dira sortutako ZIRKULUAren ezaugarriak:");
            System.out.println("   Erradioa: "+ cy1.getRadius());
            System.out.println("   Kolorea: "+ cy1.getColor());
            System.out.println("   Altuera: "+ cy1.getHeight());
            System.out.println("   Azalera: "+ cy1.getArea());
            System.out.println("   Bolumena: "+ cy1.getVolume());

        }else{
            System.out.println("ERROR, AUKERA OKERRA");
        }
        in.close();
    }
}