package model;
import java.util.ArrayList;

import model.enumerazioa.*;

public class Selekzioa {
    private ArrayList<Kidea> kideak = new ArrayList();
    private int azkenId = 0;
//    private Herria herria;

    public Selekzioa(String herrialdea) {
        if (herrialdea.equals("Euskadi")) {
//            this.herria = Herria.eus;
            kideak.add(new Futbolaria(++azkenId, "Unai", "Bustinza", 28, 2, Demarkazioa.DEF));
            kideak.add(new Futbolaria(++azkenId, "Mikel", "Balenziaga", 32, 3, Demarkazioa.DEF));
            kideak.add(new Futbolaria(++azkenId, "Asier", "Illarramendi", 30, 4, Demarkazioa.MED));
            kideak.add(new Futbolaria(++azkenId, "Iñigo", "Martínez", 29, 5, Demarkazioa.DEF));
            kideak.add(new Futbolaria(++azkenId, "Mikel", "San José", 31, 6, Demarkazioa.MED));
            kideak.add(new Futbolaria(++azkenId, "Gaizka", "Larrazabal", 23, 7, Demarkazioa.DEF));
            kideak.add(new Futbolaria(++azkenId, "Manu", "García", 34, 8, Demarkazioa.MED));
            kideak.add(new Futbolaria(++azkenId, "Aritz", "Aduriz", 39, 9, Demarkazioa.DEL));
            kideak.add(new Futbolaria(++azkenId, "Javier", "Eraso", 30, 10, Demarkazioa.MED));
            kideak.add(new Futbolaria(++azkenId, "Asier", "Villalibre", 23, 11, Demarkazioa.DEL));
            kideak.add(new Futbolaria(++azkenId, "Aihen", "Muñoz", 23, 12, Demarkazioa.DEF));
            kideak.add(new Futbolaria(++azkenId, "Iago", "Herrerín", 32, 13, Demarkazioa.POR));
            kideak.add(new Futbolaria(++azkenId, "Aritz", "Elustondo", 26, 14, Demarkazioa.MED));
            kideak.add(new Futbolaria(++azkenId, "Jesús", "Areso", 21, 15, Demarkazioa.DEF));
            kideak.add(new Futbolaria(++azkenId, "Iñigo", "Vicente", 23, 16, Demarkazioa.DEL));
            kideak.add(new Futbolaria(++azkenId, "Daniel", "Vivian", 21, 17, Demarkazioa.MED));
            kideak.add(new Entrenatzailea(++azkenId, "Javier", "Clemente", 0, "F1"));
            kideak.add(new Entrenatzailea(++azkenId, "Joseba", "Núñez", 0, "F2"));
            kideak.add(new Entrenatzailea(++azkenId, "Markel", "Lautadahandi", 0, "F3"));
            kideak.add(new Masajista(++azkenId, "Iñaki", "Sertxiberrieta", 0, "Fisioterapeuta", 0));
            kideak.add(new Kidea(++azkenId, "Ander", "Etxeburu", 0));
            kideak.add(new Atezaina(++azkenId, "Aitor", "Fernández", 29, 1, 8));
        } else if (herrialdea.equals("Rumania")) { // https://en.wikipedia.org/wiki/Romania_national_football_team#Players
            //herria = Herria.ro;
            kideak.add(new Futbolaria(++azkenId, "Horatiu", "Moldovan", 25, 1, Demarkazioa.POR));
        } else
            System.out.println("Selekzio honen daturik ez daukagu momentuz. Kide gabe sortuko da.");
    }
    
    public void kideakBistaratu(){
        for(int i = 0; i < kideak.size(); ++i){
            System.out.println(kideak.get(i));
        }
    }

    public void futbolariakBistaratu(){
        for(Kidea k : kideak){
            if(k instanceof Futbolaria){
                System.out.println(k);
            }
        }
    }

    public void kideakTaldekatutaBistaratu(){
        int countF = 0;
        int countE = 0;
        int countM = 0;
        int countK = 0; 

        for(Kidea k : kideak){
            if (k instanceof Futbolaria || k instanceof Atezaina) {
                countF++;
            } else if (k instanceof Entrenatzailea) {
                countE++;
            } else if (k instanceof Masajista) {
                countM++;
            } else {
                countK++;
            }
        }

        System.out.println("FUTBOLARIAK\n-------------------");
        for(Kidea k : kideak){
            if (k instanceof Futbolaria || k instanceof Atezaina) {
                System.out.println(k);
            }
        }
        System.out.println("Guztira: " + countF + " futbolari");

        System.out.println();

        System.out.println("ENTRENATZAILEAK\n----------------");
        for(Kidea k : kideak){
            if (k instanceof Entrenatzailea) {
                System.out.println(k);
            }
        }
        System.out.println("Guztira: " + countE + " entrenatzaile");

        System.out.println();

        System.out.println("MASAJISTAK\n------------------");
        for(Kidea k : kideak){
            if (k instanceof Masajista) {
                System.out.println(k);
            }
        }
        System.out.println("Guztira: " + countM + " masajista");

        System.out.println();

        System.out.println("BESTELAKOAK\n---------------");
        for(Kidea k : kideak){
            if (k instanceof Kidea && !(k instanceof Futbolaria) && !(k instanceof Masajista) && !(k instanceof Entrenatzailea)) {
                System.out.println(k);
            }
        }
        System.out.println("Guztira: " + countK + " bestelakoak");
    }

    public ArrayList<Kidea> getKideak(){
        return kideak;
    }

    public ArrayList<String> getKideenAbizenak(){
        ArrayList<String> abizenak = new ArrayList<>();
        for(Kidea k : kideak){
            abizenak.add(k.getAbizena());
        }

        return abizenak;
    }

    public int kideBerria(Kidea k){
        kideak.add(k);
        return k.getId();
    }

    public int kideaEzabatu(int id){
        for(Kidea k : kideak){
            if (k.getId() == id) {
                kideak.remove(k);
                return 1; //ondo engin bada
            }
        }
        return 0; //id horrekin ez bada inor aurkitu
    }
}