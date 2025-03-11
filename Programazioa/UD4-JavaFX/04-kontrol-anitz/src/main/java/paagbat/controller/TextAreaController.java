package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.HerriakAccess;

public class TextAreaController {
    HerriakAccess atzipena = new HerriakAccess();

    @FXML
    TextArea tAreaHerriak;

    @FXML
    VBox vBoxHerriak;

    @FXML
    protected void initialize() {
        List<String> herriak = atzipena.getHerriIzenak();
        for (String herria : herriak) {
            tAreaHerriak.appendText(herria+"\n");
        }            
    }

    // @FXML
    // void handleEguneratu() throws IOException {
    //     atzipena.getHerriak().add(new Herria())
    //     App.setRoot("Hasierakoa");
    // }
    
    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Hasierakoa");
    }


}
