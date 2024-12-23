package paagbat.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import paagbat.app.App;

public class HomeController {
    @FXML
    private void startGameEasy() throws IOException {
        App.setRoot("/paagbat/fxml/orokorraAzalpen");
    }

    @FXML
    private void startGameMedium() throws IOException {
        App.setRoot("/paagbat/fxml/gipuzkoaAzalpen");
    }

    @FXML
    private void startGameHard() throws IOException {
        App.setRoot("/paagbat/fxml/bizkaiAzalpen");
    }

    @FXML
    private void startGameIparralde() throws IOException {
        App.setRoot("/paagbat/fxml/iparraldeAzalpen");
    }
}