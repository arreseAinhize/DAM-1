package paagbat.model.base;

/** POJO klase bat. */
public class Herria {

    private String herria;
    private String probintzia;
    public Herria(String herria, String probintzia) {
        this.herria = herria;
        this.probintzia = probintzia;
    }
    public String getHerria() {
        return herria;
    }
    public String getProbintzia() {
        return probintzia;
    }
    public void setHerria(String herria) {
        this.herria = herria;
    }
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public String toString() {
        return herria + " (" + probintzia + ")";
    }
    

}
