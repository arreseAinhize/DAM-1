package paagbat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    private Button closeButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToEragiketak() throws IOException {
        App.setRoot("eragiketak");
    }
    public void closeApp() {
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
    }
}