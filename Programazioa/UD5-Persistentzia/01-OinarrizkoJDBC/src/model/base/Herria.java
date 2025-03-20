package model.base;

/**
 * Herria klasea herri baten informazioa gordetzeko erabiltzen da.
 * Herriaren izena eta bere probintzia gordetzen ditu.
 */
public class Herria {

    private String herriIzena;
    private String probintzia;

    /**
     * Herria klasearen eraikitzailea.
     * Herri baten izena eta probintzia ezartzen ditu.
     * @param herriIzena Herriaren izena.
     * @param probintzia Herriaren probintzia.
     */
    public Herria(String herriIzena, String probintzia) {
        this.herriIzena = herriIzena;
        this.probintzia = probintzia;
    }

    /**
     * Herriaren izena lortzen du.
     * @return Herriaren izena.
     */
    public String getHerriIzena() {
        return herriIzena;
    }

    /**
     * Herriaren probintzia lortzen du.
     * @return Herriaren probintzia.
     */
    public String getProbintzia() {
        return probintzia;
    }

    /**
     * Herriaren izena eta probintzia formatu laburtuan bueltatzen du.
     * Adibidez: "Bilbo (Bizkaia)"
     * @return Herriaren izena eta probintzia.
     */
    public String getHerria() {
        return herriIzena + " (" + probintzia + ")";
    }

    /**
     * Herriaren izena ezartzen du.
     * @param herria Herriaren izen berria.
     */
    public void setHerriIzena(String herria) {
        this.herriIzena = herria;
    }

    /**
     * Herriaren probintzia ezartzen du.
     * @param probintzia Herriaren probintzia berria.
     */
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    /**
     * Herriaren informazioa testu gisa bueltatzen du.
     * @return Herriaren izena eta probintzia formatu laburtuan.
     */
    @Override
    public String toString() {
        return herriIzena + " (" + probintzia + ")";
    }

}
