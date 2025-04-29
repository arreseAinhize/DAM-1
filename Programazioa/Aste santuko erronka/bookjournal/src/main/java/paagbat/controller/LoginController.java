/**
 * LoginController klaseak erabiltzaileari saioa hasteko aukera eskaintzen dio.
 * 
 * FXML interfazeko bi eremu nagusi kudeatzen ditu: erabiltzaile-izena eta pasahitza sartzeko testu-eremuak.
 * Erabiltzailea sartzen saiatzen da SqlConnector.loginUser(String, String) metodoaren bidez.
 * 
 * Arrakastaz autentikatzen bada, aplikazioa "RatingSystem" pantailara eramaten du.
 * Autentikazioa huts egiten bada, errore-mezua bistaratzen du.
 * 
 * Halaber, erabiltzaile berria erregistratzeko pantailara joateko botoi bat ere badu.
 */
package paagbat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;

import paagbat.App;
import paagbat.model.Erabiltzailea;
import paagbat.model.SqlConnector;
import paagbat.model.base.User;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /**
 * Saioa hasteko botoia sakatzean exekutatzen da.
 * Erabiltzaile-izena eta pasahitza irakurtzen ditu eta datu-basean bilatzen du erabiltzaile horren informazioa.
 * 
 * Erabiltzailea existitzen bada eta pasahitza zuzena bada, saioa hasten da eta erabiltzailea aplikazioko
 * hurrengo pantailara eramaten da. Bestela, errore-mezua bistaratzen da.
 * 
 * @throws IOException pantaila aldatzean errore bat gertatzen bada
 */
    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = SqlConnector.loginUser(username, password);

        if (user != null) {
            Erabiltzailea.setCurrentUser(user);
            App.setRoot("RatingSystem");
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Errorea (Login hutsa)");
            alert.setHeaderText(null);
            alert.setContentText("Erabiltzailea edo pasahitza ez da zuzena.");
            alert.showAndWait();
        }
    }

    /**
 * Erregistratzeko botoia sakatzean exekutatzen da.
 * Erabiltzailea erregistratzeko pantailara eramaten du ("Singup").
 * 
 * @throws IOException pantaila aldatzean errore bat gertatzen bada
 */
    @FXML
    private void handleSingup() throws IOException {
        App.setRoot("Singup");
    }
}
