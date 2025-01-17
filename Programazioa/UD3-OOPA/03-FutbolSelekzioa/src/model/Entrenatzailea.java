package model;
public class Entrenatzailea extends Kidea{
    private String idFederazioa;

    public Entrenatzailea(int id, String izena, String abizena, int adina, String idFederazioa){
        super(id, izena, abizena, adina);
        this.idFederazioa = idFederazioa;
    }

    public String getIdFederazioa(){
        return idFederazioa;
    }

    public void setIdFederazioa(String idFederazioa){
        this.idFederazioa = idFederazioa;
    }

    public void entrenamenduaZuzendu(){

    }

    public void partidaZuzendu(){
        
    }

    @Override
    public String toString() {
        return "Entrenatzailea {id = " + id + ", izena = " + izena + ", abizena = " + getAbizena() + ", adina = " + getAdina() + ", idFederazioa = " + idFederazioa + "}";
    }

    
}
