package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import paagbat.App;
import paagbat.model.HerriakAccess;

public class ChoiceBoxController {
    HerriakAccess atzipena = new HerriakAccess();

    @FXML
    ChoiceBox<String> choiceBoxHerriak;

    @FXML
    ComboBox<String> comboBoxHerriak;

    @FXML
    protected void initialize() {
        List<String> herriak = atzipena.getHerriIzenak();
        for (String herria : herriak) {
            choiceBoxHerriak.getItems().add(herria);
        }
        for (String herria : herriak) {
            comboBoxHerriak.getItems().add(herria);
        }

    }

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Hasierakoa");
    }


}
