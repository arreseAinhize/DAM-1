package paagbat.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.base.Erabiltzailea;
import paagbat.model.base.Saioa;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Login {
    @FXML
    TextField txtfieldKontua;
    @FXML
    TextField textfieldPasahitza;
    @FXML
    Label errorLabel;
    @FXML
    Button buttonSartu;


    public void handleLogin() throws IOException{
        String kontua = txtfieldKontua.getText();
        String pasahitza = textfieldPasahitza.getText();
        System.out.println("Login prozesua hasi da");
        errorLabel.setText("");
        

        if(txtfieldKontua.getText().isEmpty() || textfieldPasahitza.getText().isEmpty()){
            errorLabel.setText("Kontua edo pasahitza hutsik dago");
            return;
        }

        Erabiltzailea erabiltzailea = App.erabiltzaileenAtzipena.logingErabiltzailea(kontua, pasahitza);

        if(erabiltzailea == null){
            errorLabel.setText("Kontua edo pasahitza okerra da");
            return;
        }else{
            App.erabiltzaileenAtzipena.loginLogs(erabiltzailea.getKontua());
            App.saioa = new Saioa(erabiltzailea.getKontua());
            App.saioa.setKontua(erabiltzailea.getKontua());
            App.setRoot("Nagusia");
        }
    }
}
