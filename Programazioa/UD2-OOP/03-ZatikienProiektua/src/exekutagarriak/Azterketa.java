package exekutagarriak;
import java.util.Scanner;
import java.util.Random;
import model.Zatikia;

public class Azterketa {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int galZenba = 1,nota=0;
        String galIzena = ". GALDERA";
        System.out.println("AZTERKETA");
        System.out.println("==============");
        System.out.println(" Gogoratu emaitza, X/Y formatuan sartu behar dela.");
        do{
            System.out.println(galZenba + galIzena);
            nota += galdera();
            galZenba++;
        }while(galZenba <= 10);
        System.out.println("Hartu arnasa azterketa zuzentzen dugun bitartean.....");
        Thread.sleep(2000);
        System.out.println("NOTA: "+nota);
    }
    
    public static boolean egiaztatu(Zatikia z1, Zatikia z2, char erag, Zatikia zErantzuna){
        boolean emaitza =false;
        if(erag == '+'){
            if (zErantzuna.hamartarBaliokidea() == Zatikia.batu(z1,z2).hamartarBaliokidea()){
                emaitza = true;
            }
        }else if (erag == '*'){
            if (zErantzuna.hamartarBaliokidea() == Zatikia.biderkatu(z1,z2).hamartarBaliokidea()){
                emaitza = true;
            }
        }
        return emaitza;
    }

    public static int galdera(){
        Random auzaRandom = new Random();

        Zatikia zat1 = new Zatikia();
        Zatikia zat2 = new Zatikia();
        char[] ikurrak = {'+','*'};
        int puntuak = 0;

        char ikurra = ikurrak[auzaRandom.nextInt(ikurrak.length)];
        System.out.print(zat1.toString() +" "+ikurra+" " +zat2.toString()+ " = ");
        String sarrera = in.nextLine();
        Zatikia emaitzaErabiltzailea = new Zatikia(sarrera);
        
        boolean egiaztapena = egiaztatu(zat1, zat2, ikurra, emaitzaErabiltzailea);

        if (egiaztapena == true){
            puntuak++;
        }
        return puntuak;
    }
}

/*
 * ZATIKIAK AUZAS SORTEKO ERAK:
 * 
 *  1. Modua:
 *      Zatikia zat1 = new Zatikia();
 *      Zatikia zat2 = new Zatikia();
 * 
 *  2. Modua:
 *      Zatikia zat1 = new Zatikia(auzaRandom.nextInt(10)+1,auzaRandom.nextInt(10)+1);
 *      Zatikia zat2 = new Zatikia(auzaRandom.nextInt(10)+1,auzaRandom.nextInt(10)+1);
 * 
 *  3. Modua:
 *      zat1.setZenbakitzaile(auzaRandom.nextInt(10)+1);
 *      zat1.setIzendatzaile(auzaRandom.nextInt(10)+1);
 *      zat2.setZenbakitzaile(auzaRandom.nextInt(10)+1);
 *      zat2.setIzendatzaile(auzaRandom.nextInt(10)+1);
 */
