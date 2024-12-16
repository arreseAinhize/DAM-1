package model;

public class Pelikula {
    private String izenburua;
    private int urtea, iraupena;

    public Pelikula() {

    }
    //HOBETO:
    // public Pelikula(String izenburua, int urtea,int iraupena) {
    //     this.izenburua = izenburua;
    //     this.urtea = urtea;
    //     this.iraupena = iraupena;
    // }


    /**
     * GET metodoak
     * Pelikularen Izenburu,Urte eta Iraupen balioak eskuratzeko metodoak.
     */
    public String getIzenburua() {
        return izenburua;
    }

    public int getUrtea() {
        return urtea;
    }

    public int getIraupena() {
        return iraupena;
    }

    /**
     * SETTER metodoak
     * Pelikularen Izenburu,Urte eta Iraupen balio berriak ezartzeko metodoak.
     */
    public void setIzenburua(String izenburuBerria) {
        izenburua = izenburuBerria;
    }

    public void setUrtea(int urteBerria) {
        urtea = urteBerria;
    }

    public void setIraupena(int iraupenBerria) {
        iraupena = iraupenBerria;
    }

    /**
     * toString metodoa
     * pelikularen izenburua eta estrenaildi urtea bueltatzen ditu String formatuan.
     */
    public String toString() {
        return izenburua + " (" +urtea +")";
    }

    /**
     * isLongerThan Metodoa
     * Pelikula luzeena (pelikularen iraupenaren arabera)  bueltatzen du.
     */
    public boolean isLongerThan(Pelikula p){
        return this.getIraupena() > p.getIraupena();
    }

    /**
     * ZAHARRENA METODOA
     * Pelikula zaharrena zein den bueltatzen dun peikularen estrenaildi urtea kontuan izanda.
     */
    public static Pelikula zaharrena(Pelikula[] pelikulak){
        if(pelikulak == null || pelikulak.length ==0){
            return null; //Lk no tiene valor alguno esta mas vacio que mis ganas de vivir :>
        }

        Pelikula zaharrena = pelikulak[0];
        
        for (int i = 1; i < pelikulak.length; i++) {
            if (pelikulak[i] != null && pelikulak[i].getUrtea()<zaharrena.getUrtea()) { 
            // lk[i] ez bada null ETA handiena baino handiagoa bada:
            zaharrena = pelikulak[i]; // Handienari balio berria heman.
            }
        }
        return zaharrena;
    }
}
