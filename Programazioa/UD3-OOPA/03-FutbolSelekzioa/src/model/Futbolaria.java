package model;

import model.enumerazioa.*;

public class Futbolaria extends Kidea{
    private int dortsala;
    private Demarkazioa demarkazioa;

    public Futbolaria(){
        
    }

    public Futbolaria(int id, String izena, String abizena, int adina, int dortsala){
        super(id, izena, abizena, adina);
        this.dortsala = dortsala;
    }

    public Futbolaria(int id, String izena, String abizena, int adina, int dortsala, Demarkazioa demarkazioa){
        super(id, izena, abizena, adina);
        this.dortsala = dortsala;
        this.demarkazioa = demarkazioa;
    }

    public int getDortsala(){
        return dortsala;
    }

    public Demarkazioa getDemarkazioa(){
        return demarkazioa;
    }

    public void setDortsala(int dortsala){
        this.dortsala = dortsala;
    }

    public void setDemarkazioa(Demarkazioa demarkazioa){
        this.demarkazioa = demarkazioa;
    }

    @Override
    public String toString() {
        return "Futbolaria {id = " + id + ", izena = " + izena + ", abizena = " + getAbizena() + ", adina = " + getAdina() + ", dortsala = " + dortsala + ", demarkazioa = " + demarkazioa + "}";
    }

    public void entrenatu(){
        System.out.println("Entrenatu egin dute.");
    }

    public void partidaJolastu(){
        System.out.println("Partidu bat jolastu dute.");
    }
    
}
