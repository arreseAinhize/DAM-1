package paagbat.model.base;

public class Erabiltzailea {
    private String kontua;
    private String izena;
    private String abizena;
    private int adina;
    private String rola;
    private String pasahitza;

    /**
     * Konstruktore honek atributoen balio guztiak jasoko ditu parametro gisa.
     */
    
    public Erabiltzailea(String kontua, String izena, String abizena, int adina, String rola, String pasahitza) {
        this.kontua = kontua;
        this.izena = izena;
        this.abizena = abizena;
        this.adina = adina;
        this.rola = rola;
        this.pasahitza = pasahitza;
    }

    /**
     * Konstruktore honek *kontua* atributoa izena eta abizenaren arabera
     * kalkulatzen du.
     * Ikasleen kontua abizena eta izena puntu batez elkartuz lortzen da. Adibidez,
     * 'monasterio.julen'
     * Irakasleen kontua izenaren lehen karaktereari abizena lotuz lortzen da.
     * Adibidez, 'iurkidi'
     */
    public Erabiltzailea(String izena, String abizena, int adina, String rola) {
       this.izena = izena;
       this.abizena = abizena;
       this.adina = adina;
       this.rola = rola;
       this.kontua = izena.charAt(0) + abizena; /*izenaren lehen karakterea hartzeko*/
    }

    /**
     * Konstruktore honek atributo guztiak hasieratzen ditu.
     */
    public Erabiltzailea(String kontua, String pasahitza) {
        this.kontua = kontua;
        this.pasahitza = pasahitza;
    }

    public String getKontua() {
        return kontua;
    }

    public String getIzena() {
        return izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public int getAdina() {
        return adina;
    }

    public String getRola() {
        return rola;
    }
    public String getPasahitza() {
        return pasahitza;
    }
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }
    public void setKontua(String kontua) {
        this.kontua = kontua;
    }

    /** Metodo honek objetuaren atributu guztiak bueltatzen ditu komaz bananduta. */
    @Override
    public String toString() {
        return kontua + ", " + izena + ", " + abizena + ", " + adina + ", " + rola + ", " + pasahitza;
    }

}
