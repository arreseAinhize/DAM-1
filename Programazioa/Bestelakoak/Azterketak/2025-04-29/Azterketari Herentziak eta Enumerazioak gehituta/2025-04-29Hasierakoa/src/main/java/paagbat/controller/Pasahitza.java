package paagbat.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import paagbat.App;
import paagbat.model.ErabiltzaileenAtzipena;

public class Pasahitza {
    @FXML
    private TextField TFpasahitzZarra;
    @FXML
    private TextField TFpasahitzBerria1;
    @FXML
    private TextField TFpasahitzBerria2;
    @FXML
    private Label errorLabel;

    ErabiltzaileenAtzipena erabiltzaileenAtzipena = new ErabiltzaileenAtzipena("localhost", "root", "", "ErabiltzaileenDatuBasea", "Erabiltzaileak");


    @FXML
    public void handleAldatu() throws IOException{
        String pasahitzZarra = TFpasahitzZarra.getText();
        String pasahitzBerria1 = TFpasahitzBerria1.getText();
        String pasahitzBerria2 = TFpasahitzBerria2.getText();

        if(pasahitzZarra.isEmpty() || pasahitzBerria1.isEmpty() || pasahitzBerria2.isEmpty()){
            errorLabel.setText("Daturen bat falta zaizu.");
            return;
        }
        if(pasahitzBerria1.equals(pasahitzBerria2) != true){
            errorLabel.setText("Pasahitzak ez dira berdinak.");
            return;
        }
        if(pasahitzZarra.equals(pasahitzBerria1)){
            errorLabel.setText("Pasahitz berria ez da aldatu.");
            return;
        }
        if(!erabiltzaileenAtzipena.pasahitzKonprobatu(App.saioa.getKontua(), pasahitzZarra)){
            errorLabel.setText("Pasahitz zaharra ez da zuzena.");
            return;
        }

        if(erabiltzaileenAtzipena.pasahitzaAldatu(App.saioa.getKontua(), pasahitzZarra, pasahitzBerria1) == true){
            errorLabel.setText("Pasahitz ondo aldatu da.");
            return;
        }
    }

    @FXML
    public void handleAtzera() throws IOException{
        App.setRoot("Nagusia");
    }
}
