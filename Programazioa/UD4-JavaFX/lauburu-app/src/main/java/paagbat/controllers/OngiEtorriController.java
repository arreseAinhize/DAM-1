package paagbat.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;

import java.io.IOException;
import paagbat.app.App;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class OngiEtorriController {
    @FXML
    private Label OngiLabel;
    @FXML
    private Label textLabel;

    @FXML
    private Button startBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Button idiomBtn;

    @FXML
    private void switchToHasiera() throws IOException {
        App.setRoot("/paagbat/fxml/home");
    }

    @FXML
    public void initialize() {
        // Centrar el título "ONGI ETORRI"
        AnchorPane.setTopAnchor(OngiLabel, 80.0);
        AnchorPane.setLeftAnchor(OngiLabel, 0.0);
        AnchorPane.setRightAnchor(OngiLabel, 0.0);
        OngiLabel.setAlignment(Pos.CENTER);

        // Centrar el texto debajo del título
        AnchorPane.setTopAnchor(textLabel, 180.0);
        AnchorPane.setLeftAnchor(textLabel, 0.0);
        AnchorPane.setRightAnchor(textLabel, 0.0);
        textLabel.setAlignment(Pos.CENTER);

        // Centrar el botón "Hasi jokoa" en la parte inferior
        AnchorPane.setBottomAnchor(startBtn, 20.0);
        AnchorPane.setLeftAnchor(startBtn, 295.5);
        AnchorPane.setRightAnchor(startBtn, 295.5);
        startBtn.setAlignment(Pos.CENTER);

        // Botón de idioma en la esquina superior izquierda
        AnchorPane.setTopAnchor(idiomBtn, 20.0);
        AnchorPane.setLeftAnchor(idiomBtn, 20.0);

        // Botón de home en la esquina superior derecha
        AnchorPane.setTopAnchor(homeBtn, 20.0);
        AnchorPane.setRightAnchor(homeBtn, 20.0);

    }
}
