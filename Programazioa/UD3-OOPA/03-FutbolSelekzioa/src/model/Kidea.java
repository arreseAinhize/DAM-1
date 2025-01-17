package model;
public class Kidea {
    protected int id;
    protected String izena;
    private String abizena;
    private int adina;
    
    public Kidea(){

    }
    
    public Kidea(int id, String izena, String abizena, int adina){
        this.id = id;
        this.izena = izena;
        this. abizena = abizena;
        this.adina = adina;
    }

    public int getId(){
        return id;
    }

    public String getIzena(){
        return izena;
    }

    public String getAbizena(){
        return abizena;
    }

    public int getAdina(){
        return adina;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setIzena(String izena){
        this.izena = izena;
    }

    public void setAbizena(String abizena){
        this.abizena = abizena;
    }

    public void setAdina(int adina){
        this.adina = adina;
    }

    @Override
    public String toString() {
        return "Kidea { id = " + id + ", izena = " + izena + ", abizena = " + abizena + ", adina = " + adina + "}";
    }

    public void eltartu(){

    }

    public void bidaiatu(){
        
    }
}
