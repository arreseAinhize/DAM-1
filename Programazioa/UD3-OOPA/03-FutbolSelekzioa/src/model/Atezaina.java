package model;
public class Atezaina extends Futbolaria{
    private int geratutakoGolak = 0;

    public Atezaina(){

    }

    public Atezaina(int id, String izena, String abizena, int adina, int dortsala, int geratutakoGolak){
        super(id, izena, abizena, adina, dortsala);
        this.geratutakoGolak = geratutakoGolak;
    }

    public void golaGeratu(){
        System.out.println("Atezainak " + geratutakoGolak + "gol gelditu ditu denboraldi honentan.");
    }

    public String toString(){
        return "Atezaina{id = " + id + ", izena = " + izena + ", abizena = " + getAbizena() + ", adina = " + getAdina() + ", dortsala = " + getDortsala() + ", geratutakoGolak= " + geratutakoGolak + "}";
    }
}
