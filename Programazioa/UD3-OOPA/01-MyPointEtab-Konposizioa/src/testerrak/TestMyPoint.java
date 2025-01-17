package testerrak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import model.MyPoint;

public class TestMyPoint {
    public static void main(String[] args) {
        System.out.println("a) Hitu puntu sortu:");
        MyPoint p0 = new MyPoint();
        MyPoint p1 = new MyPoint(2, 1);
        MyPoint p2 = new MyPoint(4, 0);
        System.out.println(" p0 => " + p0.toString() +"\n p1 => " + p1.toString() + "\n p2 => " + p2.toString());

        System.out.println("\nb) Distantziak koordenatu-jatorriarekiko:");
        System.out.println(" p0 => " + p0.distance() +"\n p1 => " + p1.distance() + "\n p2 => " + p2.distance());

        System.out.println("\nc) Distantziak euren artean:");
        System.out.println(" p0tik p1ra => " + p0.distance(p1) +"\n p0tik p2ra => " + p0.distance(p2) + "\n p1tik p2ra => " + p1.distance(p2));
        System.out.println("c.2)  p1 puntuaren datuak getXY() metodoa erabilita:");
        System.out.println(Arrays.toString(p1.getXY()));
        
        System.out.println("\nd) Sortu 200 puntuko array bat. Eta automatikoki bete:");
        MyPoint[] puntuenArraya = new MyPoint[200];
        System.out.print("puntuenArraya => [ ");
        for(int i=0; i< 200;i++){
            puntuenArraya[i] = new MyPoint(0, 0); // arraya bete
            puntuenArraya[i].setXY(i + 1, i + 1); // Baloreak ezarri
            System.out.print(puntuenArraya[i].toString() + ", ");
        }
        System.out.println("]");

        System.out.println("\ne) Sortu 100 puntuko arrayLista:");
        ArrayList<MyPoint> puntuenArrayList = new ArrayList<>(100);
        System.out.print("puntuenArraya => [ ");
        for(int i=1; i<= 100;i++){
            puntuenArrayList.add(new MyPoint(0, 0)); // arraya bete
            puntuenArrayList.get(i).setXY(i, i); // Baloreak ezarri
            System.out.print(puntuenArrayList.get(i).toString() + ", ");
        }
        System.out.println("]");

        System.out.println("\nf) Sortu ausazko 5 puntuko sorta (0-9 tartean):");
        Random auzaRandom = new Random();
        System.out.println("\ne) Sortu 100 puntuko arrayLista:");
        ArrayList<MyPoint> bostPuntuenArrayList = new ArrayList<>(5);
        System.out.print("puntuenArraya => [ ");
        for(int i=0; i< 5;i++){
            bostPuntuenArrayList.add(new MyPoint(0, 0)); // arraya bete
            bostPuntuenArrayList.get(i).setXY(auzaRandom.nextInt(10),auzaRandom.nextInt(10)); // Baloreak ezarri
            System.out.print(bostPuntuenArrayList.get(i).toString() + ", ");
        }
        System.out.println("]");
    }
}