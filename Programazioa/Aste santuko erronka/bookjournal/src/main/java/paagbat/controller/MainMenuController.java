package paagbat.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import paagbat.App;
import paagbat.model.Erabiltzailea;

public class MainMenuController {
        // Pantaila aldaketarako metodoak (menu botoiak)

    /**
     * Saioa amaitu eta login pantailara bideratzen du.
     * 
     * @throws IOException Pantaila aldaketak errore bat gertatuz gero.
     */
    @FXML
    private void handleLogOut() throws IOException {
        Erabiltzailea.clear();
        App.setRoot("Login");
    }

    /**
     * Estatistikak pantailara bideratzen du.
     * 
     * @throws IOException Pantaila aldaketak errore bat gertatuz gero.
     */
    @FXML
    private void handleStats() throws IOException {
        App.setRoot("Stats");
    }

    /**
     * Balorazio sistemara bideratzen du.
     * 
     * @throws IOException Pantaila aldaketak errore bat gertatuz gero.
     */
    @FXML
    private void handleRating() throws IOException {
        App.setRoot("RatingSystem");
    }

    /**
     * Irakurketa erregistroa pantailara bideratzen du.
     * 
     * @throws IOException Pantaila aldaketak errore bat gertatuz gero.
     */
    @FXML
    private void handleLog() throws IOException {
        App.setRoot("RedingLog");
    }

    /**
     * Desira zerrenda pantailara bideratzen du.
     * 
     * @throws IOException Pantaila aldaketak errore bat gertatuz gero.
     */
    @FXML
    private void handleWish() throws IOException {
        App.setRoot("WishList");
    }

    /**
     * Liburuaren berrikuspenak pantailara bideratzen du.
     * 
     * @throws IOException Pantaila aldaketak errore bat gertatuz gero.
     */
    @FXML
    private void handleReview() throws IOException {
        App.setRoot("BookReview");
    }
}
