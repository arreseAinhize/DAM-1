package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import paagbat.App;

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
    void handleAldatu() throws IOException {
        App.setRoot("Aldatu");
    }

    @FXML
    void handleIrten() throws IOException {
        Platform.exit();
    }

    /** Textareari herrien zerrendako balio oso numeratuak ezartzen dizkio. Ikus irudia.  */
    private void textAreaBete(){
        // OSATU EZAZU Ahal duzun neurrian toStringak aprobetxatuz.
        List<String> herriak = App.herriak.erakutsiDatuak();
        String herriakBistaratu = "";
        int herriKop = 1;    
        for (String herria : herriak) {
            herriakBistaratu += herriKop + ".- " + herria + "\n"; // Concatenación
            herriKop++;
        }
        tAreaHerriak.setText(herriakBistaratu);
    }
}