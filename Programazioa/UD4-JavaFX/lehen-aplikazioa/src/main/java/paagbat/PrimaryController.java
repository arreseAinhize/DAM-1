package paagbat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrimaryController {
    @FXML
    private Button closeButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToEragiketak() throws IOException {
        App.setRoot("eragiketak");
    }
    @FXML
    private void switchToKalkulagailuaBat() throws IOException {
        App.setRoot("kalkulagailuabat");
    }
    // Método que cierra la aplicación.
    @FXML
    public void closeApp() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
