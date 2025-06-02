package paagbat.model;

import paagbat.model.enums.ErabiltzaileMota;
import paagbat.model.base.Erabiltzailea;
public class Ikasleak extends Erabiltzailea {
    private ErabiltzaileMota rola;

    /**
     * Konstruktore honek atributoen balio guztiak jasoko ditu parametro gisa.
     */
    public Ikasleak(String izena, String abizena, int adina, ErabiltzaileMota rola) {
        super(izena, abizena, adina);
        this.rola = ErabiltzaileMota.IKASLEA;
        super.setKontua("" + izena.charAt(0) + abizena);
    }
    public Ikasleak(String kontua, String izena, String abizena, int adina, String Pasahitza, ErabiltzaileMota rola) {
        super(izena, abizena, adina);
        super.setKontua(kontua);
        super.setPasahitza(Pasahitza);
        this.rola = ErabiltzaileMota.IKASLEA;
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
