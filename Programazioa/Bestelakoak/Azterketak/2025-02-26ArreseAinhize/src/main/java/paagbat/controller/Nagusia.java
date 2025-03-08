package paagbat.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import paagbat.App;
import paagbat.model.base.Herria;
import paagbat.model.base.KostakoHerria;

public class Nagusia {
        
    @FXML
    TextArea tAreaHerriak;

    @FXML
    protected void initialize() {
        textAreaBete();                    
    }

    @FXML
    void handleTxertatu() throws IOException {
        App.setRoot("Txertatu");
    }

    @FXML
    void handleEzabatu() throws IOException {
        App.setRoot("Ezabatu");
    }

    @FXML
    void handleIrten() throws IOException {
        Platform.exit();
    }

    /** Textareari herrien zerrendako balio oso numeratuak ezartzen dizkio. Ikus irudia.  */
    private void textAreaBete(){
        // OSATU EZAZU Ahal duzun neurrian toStringak aprobetxatuz.
        int herriKop = 1;
        String testuaBistaratu = "";
        for (Herria herria : App.herriak.getHerrienZerrenda()) {
                testuaBistaratu +=herriKop + "- ";
                if (herria instanceof KostakoHerria) {
                    testuaBistaratu += ((KostakoHerria)herria).toStringKonpletoagoa();
                    herriKop++;
                } else {
                    testuaBistaratu += herria.toString() + "\n";
                    herriKop++;                }
            tAreaHerriak.setText(testuaBistaratu);
        }
    }
}