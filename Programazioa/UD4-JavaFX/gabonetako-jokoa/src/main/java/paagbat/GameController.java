package paagbat;

import java.io.IOException;
import javafx.fxml.FXML;

public class GameController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
