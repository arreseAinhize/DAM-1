package paagbat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.base.Herria;

public class Ezabatu {
    @FXML
    VBox vBoxHerriak;

    @FXML
    Label lbMezua;

    int aukeratuak = 0;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    
    /** Herri bakoitzeko checkbox bat sortuko da. */
    @FXML
    protected void initialize() {
        // OSATU EZAZU
        List<String> herriak = App.herriak.getHerriIzenak();
        for (String herria : herriak) {
            CheckBox checkBox = new CheckBox(herria);
            checkBoxes.add(checkBox);  // CheckBox erreferentzia gorde
            vBoxHerriak.getChildren().add(checkBox);
        }
    }

    /** Hautatutako herriak ezabatuko dira zerrendatik.
     * Zure esku egiaztapenak egitea.
    */
    @FXML
    void handleEzabatu() throws IOException {
        // OSATU EZAZU
        boolean herriaAukeratu = false;
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                herriaAukeratu = true;

                String herriaIzena = checkBox.getText();  // Aukeratutako herriaren izena lortu

                String herriProbintzia = App.herriak.getProbintzia(herriaIzena);

                // Hemen herriaren izenarekin zerbait egin dezakezu, adibidez, zerrendatik ezabatu
                App.herriak.ezabatu(new Herria(herriaIzena,herriProbintzia));// Adibide gisa, herria ezabatzen da

                // CheckBox-a ere ezabatu dezakezu nahi izanez gero
                vBoxHerriak.getChildren().remove(checkBox);
            }
        }
    
        if (!herriaAukeratu) {
            lbMezua.setText("Ez da herririk aukeratu.");
        } else {
            lbMezua.setText("Herria ondo ezabatuta.");
        }
    }

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Nagusia");
    }

}
