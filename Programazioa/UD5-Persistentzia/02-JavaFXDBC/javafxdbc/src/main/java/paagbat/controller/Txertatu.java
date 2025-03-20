package paagbat.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.base.Herria;

public class Txertatu {
    @FXML
    VBox vBoxHerriarenDatuak;

    @FXML
    TextField txfIzena;

    @FXML
    TextField txfProbintzia;

    @FXML
    Label lbMezua;

    @FXML
    protected void initialize() {
        System.out.println();
        App.herriak.erakutsiDatuak();
    }

    /** Herria txertatzeko botoia sakatzerakoan exekutatzen da metodo hau.
     *  Lehengo eta behin izena eta probintzia eremuak beteta dauden egiaztatuko da eta beteta 
     *  ez badaude, mezua aterako da lbMezua labelean.
     *  Herri hori dagoeneko zerrendan baldin badago, mezu egokia idatziko da mezuen labelean.
     *  Baldintza biak beteta, eszenako datuekin herri edo kostako herri berri bat gehituko da 
     *  herrien zerrendan. Eta eszena nagusira itzuliko gara.
     * */
    @FXML
    public void handleTxertatu() throws IOException {
        // OSATU EZAZU
        String izena = txfIzena.getText();
        String probintzia = txfProbintzia.getText();

        if (izena.isEmpty() || probintzia.isEmpty()) {
            lbMezua.setText("Izena eta Probintzia eremuak osatuta izan behar dira.");
            return;  // Evita que el código siga ejecutándose
        }
        App.herriak.txertatu(new Herria(izena, probintzia));
        lbMezua.setText("Herria ondo txertatu da!");
    }

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Nagusia");
    }

}
