package paagbat.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.ErabiltzaileenAtzipena;
import paagbat.model.Ikasleak;
import paagbat.model.base.Erabiltzailea;
import paagbat.model.enums.ErabiltzaileMota;
import paagbat.model.Irakasleak;
import paagbat.model.Ikasleak;

public class Txertatu {

    ErabiltzaileenAtzipena erabiltzaileenAtzipena = new ErabiltzaileenAtzipena("localhost", "root", "", "ErabiltzaileenDatuBasea", "erabiltzaileak");

    @FXML
    VBox vBoxErabiltzailearenDatuak;

    @FXML
    TextField txfIzena;

    @FXML
    TextField txfAbizena;

    @FXML
    TextField txfAdina;

    @FXML
    TextField txfRola;

    @FXML
    Label lbMezua;

    /**
     * Eszenaren XML fitxategia kargatu eta berehala exekutatzen da metodo hau,
     * baina,
     * *Txertatu* eszena honetan ez da ezer berezirik exekutatu behar.
     */
    @FXML
    protected void initialize() {
        // EZ EGIN EZER HEMEN
    }

    /**
     * Txertatu botoia sakatzean exekutatzen da metodo hau.
     * - Izena, abizena edo adina hutsik badaude, mezuen labelean "Daturen bat falta
     * zaizu." esaldia agertu behar da.
     * - Adina zenbakia ez bada, mezuen labelean "Adina zenbakia izan behar da."
     * esaldia agertuko da.
     * - Rola ikaslea edo irakaslea ez bada, mezuen labelean: "Rola, ikaslea edo
     * irakaslea izan behar da."
     * - Aurreko baldintzak guztiak betetzen badira, erabiltzailea datu-basean txertatuko da
     *   (rola hutsik badago, 'ikaslea' rolarekin).
     *      - Ezin izan bada erregistroa taulan txertatuErroreren bat badago mezuen labelean: "Ezin izan da erabiltzailea datu-basean txertatu"
     * 
     *      - Txertaketa zuzena izan bada, Nagusia eszenara itzuliko da.
     */
    @FXML
    public void handleTxertatu() throws IOException {
        Erabiltzailea erabiltzailea = null;
        if(txfIzena.getText().isEmpty() || txfAbizena.getText().isEmpty() || txfAdina.getText().isEmpty() ){
            lbMezua.setText("Daturen bat falta zaizu.");
        }
        if(txfAdina.getText().isEmpty() && Integer.parseInt(txfAdina.getText()) == 0){
            lbMezua.setText("Adina zenbakia izan behar da.");
        }
        if(txfRola.getText().isEmpty() || !txfRola.getText().equals("ikaslea") && !txfRola.getText().equals("irakaslea")){
            lbMezua.setText("Rola, ikaslea edo irakaslea izan behar da.");
        }
        else{
            if(txfRola.getText().equals("ikaslea")){
                // Ikaslea
                erabiltzailea = new Ikasleak(txfIzena.getText(), txfAbizena.getText(), Integer.parseInt(txfAdina.getText()), ErabiltzaileMota.valueOf(txfRola.getText().toUpperCase()));

            }else if(txfRola.getText().equals("irakaslea")){
                erabiltzailea = new Irakasleak(txfIzena.getText(), txfAbizena.getText(), Integer.parseInt(txfAdina.getText()), ErabiltzaileMota.valueOf(txfRola.getText().toUpperCase()));

            }else{
                erabiltzailea = new Erabiltzailea(txfIzena.getText(), txfAbizena.getText(), Integer.parseInt(txfAdina.getText()));
            }
            int txertatua = erabiltzaileenAtzipena.txertatu(erabiltzailea);
            if(txertatua == 0){
                App.setRoot("Nagusia");
            }
            else{
                lbMezua.setText("Ezin izan da erabiltzailea datu-basean txertatu");
            }
        }
    }

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Nagusia");
    }
}
