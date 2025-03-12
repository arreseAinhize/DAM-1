package paagbat.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import paagbat.model.base.Herria;

/** HerriakAcess klaseko objetuak sortu nahi ez baditugu,
 * beste klase honetako member estatikoekin lan egin ahalko genuke.
 * Edo bata edo bestea erabiliko genituzke.
 */ 
public class HerriakAccessStatic {

    private static List<Herria> herriak;

    public static void herriakHasieratu() { 
        herriak = Arrays.asList(new Herria("Eibar","Gipuzkoa"),
                                new Herria("Zaldibar","Bizkaia"));
    }   
    
    public static List<Herria> getHerriak() {
        return herriak;
    }

    public static List<String> getHerriIzenak(){
        List<String> herriIzenak = new ArrayList<>();
        for (Herria herriIzena:herriak){
            herriIzenak.add(herriIzena.getHerria());
        }
        return herriIzenak;
    }

    public static void setHerriak(List<Herria> herriBerriak) {
        herriak = herriBerriak;
    }


}