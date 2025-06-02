package paagbat.controller;

import java.io.IOException;
import java.time.chrono.Era;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paagbat.App;
import paagbat.model.ErabiltzaileenAtzipena;
import paagbat.model.base.Erabiltzailea;



public class Nagusia {

    int filtroa = 0;

    ErabiltzaileenAtzipena erabiltzaileenAtzipena = new ErabiltzaileenAtzipena("localhost", "root", "", "ErabiltzaileenDatuBasea", "erabiltzaileak");
        
    @FXML
    Label lbIzenburua;
    @FXML
    Label UserLabel;
    @FXML
    TextArea tAreaErabiltzaileak;

    Erabiltzailea erabiltzailea = null;
    

    @FXML
    protected void initialize() {
        textAreaBete(filtroa);  
        if (App.saioa != null) {
            UserLabel.setText("Ongi etorri: " + App.saioa.getKontua());
        }                  
    }

    /** TXERTATU botoia sakatzerakoan exekutatzen da metodo hau. 
     * Txertatu eszena kargatzen du.
     */
    @FXML
    void handleTxertatu() throws IOException {
        App.setRoot("Txertatu");
    }
    @FXML
    void handlePasahitza() throws IOException {
        App.setRoot("Pasahitza");
    }
    @FXML
    void handleLogs() throws IOException {
        App.setRoot("Logs");
    }

    /**
     * 
     * FILTRATU botoia sakatzean exekutatzen da metodo hau.
     * Botoia sakatzen den bakoitzean egoera batetik hurrengora pasatuko gara ziklikoki, hau da, hirugarrenetik lehenera pasatuz.
     * - 1.egoera: Erabiltzaileak izenburua, taulako erregistro guztiak bistaratuko dira textArean
     * - 2.egoera: Ikasleak izenburua, ikasleak bakarrik   
     * - 3.egoera: Irakasleak izenburua, irakasleak bakarrik
     *  
     */
    @FXML
    void handleFiltratu() throws IOException {
        filtroa++;
        if(filtroa == 0){
            lbIzenburua.setText("Erabiltzaileak");
        }else if(filtroa == 1){
            lbIzenburua.setText("Ikasleak");
        }else if(filtroa == 2){
            lbIzenburua.setText("Irakasleak");
        }
        else{
            filtroa = 0;
            lbIzenburua.setText("Erabiltzaileak");
        }
        textAreaBete(filtroa);
    }

    @FXML
    void handleIrten() throws IOException {
        erabiltzaileenAtzipena.logoutLogs(App.saioa.getKontua());
        // Platform.exit();
        App.setRoot("Login");
    }

    /**
     * TextArea betetzen du filtroak dioenaren arabera
     * @param filtroa 0: denak, 1: ikasleak, 2: irakasleak
     */
    private void textAreaBete(int filtroa){
        tAreaErabiltzaileak.clear();
        tAreaErabiltzaileak.appendText("Kontua, Izena, Abizena, Adina, Rola" + "\n");
        tAreaErabiltzaileak.appendText("==============================" + "\n");
        List<Erabiltzailea> erabiltzailek = null;
        if(filtroa == 0){
            erabiltzailek = erabiltzaileenAtzipena.getErabiltzaileak();
        }else if(filtroa == 1){
            erabiltzailek = erabiltzaileenAtzipena.getRolBatekoErabiltzaileak("ikaslea");
        }else if(filtroa == 2){
            erabiltzailek = erabiltzaileenAtzipena.getRolBatekoErabiltzaileak("irakaslea");
        }
        if (erabiltzailek != null) {
            for (Erabiltzailea erabiltzailea : erabiltzailek) {
                tAreaErabiltzaileak.appendText(erabiltzailea.toString() + "\n");
            }
            tAreaErabiltzaileak.appendText("==============================" + "\n");
            tAreaErabiltzaileak.appendText("" + erabiltzailek.size() + " erabiltzaile erregistro aurkitu dira." + "\n");
        }
    }    
}
