package exekutagarriak;

import model.HerrienAtzipenak;
import model.base.Herria;
import java.util.Scanner;

public class HerriaTxertatu {
    public static void main(String[] args) throws Exception {
        HerrienAtzipenak herrienAtzipena = new HerrienAtzipenak("localhost","HerrienDBa","Herriak","ikaslea","ikaslea");
        Scanner in = new Scanner(System.in);
        if(herrienAtzipena.konektatu() != null){
            System.out.print("Sartu Herri izena: ");
            String HerriIzena = in.next();
            System.out.print("Sartu Herriaren probintzia: ");
            String HerriProbintzia = in.next();

            Herria herriBerria = new Herria(HerriIzena,HerriProbintzia);
            herrienAtzipena.txertatu(herriBerria);
            herrienAtzipena.erakutsiDatuak();
        }else{
            System.out.println("Ez zara konektatua");
        }
        in.close();
    }
}
