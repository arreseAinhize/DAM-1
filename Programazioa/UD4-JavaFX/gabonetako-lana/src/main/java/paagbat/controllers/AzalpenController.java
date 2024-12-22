package paagbat.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import paagbat.app.App;

public class AzalpenController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("/paagbat/fxml/home");
    }
    @FXML
    private void switchToEasy() throws IOException {
        App.setRoot("/paagbat/fxml/orokorraGame");
    }
    @FXML
    private void switchToMedium() throws IOException {
        App.setRoot("/paagbat/fxml/gipuzkoaGame");
    }
    @FXML
    private void switchToHard() throws IOException {
        App.setRoot("/paagbat/fxml/bizkaiaGame");
    }
}