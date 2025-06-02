package paagbat.model;
import paagbat.model.base.Erabiltzailea;
import paagbat.model.enums.ErabiltzaileMota;

public class Irakasleak extends Erabiltzailea {

    private ErabiltzaileMota rola;

    /**
     * Konstruktore honek atributoen balio guztiak jasoko ditu parametro gisa.
     */
    public Irakasleak(String izena, String abizena, int adina, ErabiltzaileMota rola) {
        super(izena, abizena, adina);
        this.rola = ErabiltzaileMota.IRAKASLEA;
        super.setKontua("" + izena.charAt(0) + abizena);
    }
    public Irakasleak(String kontua,String izena, String abizena, int adina, String Pasahitza, ErabiltzaileMota rola) {
        super(izena, abizena, adina);
        this.rola = ErabiltzaileMota.IRAKASLEA;
        super.setKontua(kontua);
        super.setPasahitza(Pasahitza);
    }

    public ErabiltzaileMota getRola() {
        return rola;
    }
    
    public void setRola(ErabiltzaileMota rola) {
        this.rola = rola;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + rola;
    }
}
