package paagbat.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import paagbat.app.App;

public class HomeController {

    @FXML
    private void startGameEasy() throws IOException {
        App.setRoot("/paagbat/fxml/easyAzalpen");
    }

    @FXML
    private void startGameMedium() throws IOException {
        App.setRoot("/paagbat/fxml/mediumAzalpen");
    }

    @FXML
    private void startGameHard() throws IOException {
        App.setRoot("/paagbat/fxml/hardAzalpen");
    }
}
