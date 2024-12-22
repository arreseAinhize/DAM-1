package paagbat.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import paagbat.app.App;

public class EasyController {
    @FXML
    private ImageView easyImg;

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("/paagbat/fxml/home");
    }

    public void initialize() {
        easyImg.setImage(new Image(App.class.getResourceAsStream("/paagbat/images/01.JPG"))); //argazkia gehitzeko lerroa
    }
}