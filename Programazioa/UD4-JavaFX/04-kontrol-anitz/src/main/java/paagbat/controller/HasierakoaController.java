package paagbat.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import paagbat.App;

public class HasierakoaController {
    @FXML
    void handleCheckBox() throws IOException {
        App.setRoot("CheckBox");
    }

    @FXML
    void handleChoiceBox() throws IOException {
        App.setRoot("ChoiceBox");
    }

    @FXML
    void handleTextArea() throws IOException {
        App.setRoot("TextArea");
    }

    @FXML
    void handleTableView() throws IOException {
        App.setRoot("TableView");
    }

    @FXML
    void handleLabelak() throws IOException {
        App.setRoot("Zenbakiak");
    }

}
