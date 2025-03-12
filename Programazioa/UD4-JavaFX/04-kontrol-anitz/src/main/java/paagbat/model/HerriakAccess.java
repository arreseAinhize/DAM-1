package paagbat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import paagbat.model.base.Herria;

/** Klase honetan datu-basea atzituko genuke.
 * Guk momentuz, datuak zerrenda baten izango ditugu.
 */ 
public class HerriakAccess {

    private List<Herria> herriak;

    public HerriakAccess() { 
        herriak = Arrays.asList(new Herria("Eibar","Gipuzkoa"),
                                new Herria("Ermua","Bizkaia"));
    }
    
    public List<Herria> getHerriak() {
        return herriak;
    }

    public List<String> getHerriIzenak(){
        List<String> herriIzenak = new ArrayList<>();
        for (Herria herriIzena:herriak){
            herriIzenak.add(herriIzena.getHerria());
        }
        return herriIzenak;
    }

    public void setHerriak(List<Herria> herriak) {
        this.herriak = herriak;
    }


}