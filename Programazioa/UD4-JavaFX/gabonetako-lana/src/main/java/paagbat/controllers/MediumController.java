package paagbat.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import paagbat.app.App;

public class MediumController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("/paagbat/fxml/home");
    }
}