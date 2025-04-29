package paagbat.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.Erabiltzailea;
import paagbat.model.RatingValue;
import paagbat.model.ReadingLogItem;
import paagbat.model.ReviewBook;
import paagbat.model.SqlConnector;
import paagbat.model.base.User;
import paagbat.model.enums.Genre;

public class BookReviewController {

    @FXML
    private ComboBox<String> comboBoxRating; // Puntuazio aukerak

    @FXML
    private ComboBox<Genre> comboBoxGenre; // Genero aukerak

    @FXML
    private TextField izenburuaText; // Liburuaren izenburua

    @FXML
    private TextField idazleaText; // Idazlearen izena

    @FXML
    private TextField dataText; // Irakurritako data tartea

    @FXML
    private TextField orriakText; // Liburuaren orrialde kopurua

    @FXML
    private TextArea notesText; // Erabiltzailearen iritzia

    @FXML
    private CheckBox fisikoaCheck; // Formatu fisikoa

    @FXML
    private CheckBox ebookCheck; // Ebook formatua

    @FXML
    private CheckBox audioCheck; // Audiobook formatua

    private ReadingLogItem selectedBook = ReviewBook.getSelectedItem(); // Hautatutako liburua
    private User user = Erabiltzailea.getCurrentUser(); // Uneko erabiltzailea

    /**
     * Hasierako metodoa. Pantaila kargatzean deitzen da.
     * Balorazio aukerak eta generoak ComboBox-en betetzen ditu eta formularioa
     * aurrez hautatutako liburuarekin betetzen du (baldin badago).
     */
    @FXML
    public void initialize() {
        if (user == null)
            return; // Segurtasun kontrola

        // Erabiltzailearentzat puntuazio balioak kargatu
        RatingValue rating = SqlConnector.getRatingForUser(user.getId());
        if (rating != null) {
            comboBoxRating.getItems().addAll(
                    rating.getStar1(),
                    rating.getStar2(),
                    rating.getStar3(),
                    rating.getStar4(),
                    rating.getStar5());
        } else {
            comboBoxRating.setValue(null); // Ez badu, utzi hutsik edo beste balio bat
        }

        // Generoak gehitu
        comboBoxGenre.getItems().addAll(Genre.values());

        // Bete balio lehenetsiak
        comboBoxRating.setValue("Zabaldu");
        comboBoxGenre.setValue(Genre.OTHER);
        dataText.setText("yyyy/mm/dd - yyyy/mm/dd");

        // Hautatutako liburua badago, datuak kargatu
        if (selectedBook != null) {
            setBookData(selectedBook);
        } else {
            System.out.println("Ez dago hautatutako libururik.");
        }
    }

    /**
     * Formularioan hautatutako liburuaren datuak kargatzen ditu.
     *
     * @param book Hautatutako liburua {@link ReadingLogItem} moduan
     */
    public void setBookData(ReadingLogItem book) {
        System.out.println("Liburuaren datuak kargatzen: " + book.getTitle());

        comboBoxGenre.setValue(Genre.valueOf(book.getGenre().toUpperCase()));
        izenburuaText.setText(selectedBook.getTitle());
        idazleaText.setText(selectedBook.getAuthor());

        if (selectedBook.getStartDate() == null || selectedBook.getEndDate() == null) {
            dataText.setText("yyyy/mm/dd - yyyy/mm/dd");
        } else {
            dataText.setText(selectedBook.getStartDate() + " - " + selectedBook.getEndDate());
        }

        orriakText.setText("" + selectedBook.getBaseBook().getDuration());
        notesText.setText(SqlConnector.getReviewText(book.getBookID(), user.getId()));
    }

    /**
     * "Gorde" botoia sakatzean deitzen da.
     * Datuak egiaztatzen ditu eta dena ondo badago, {@code datuakbidali()} deitzen
     * du.
     * Ondoren, formularioa garbitu eta "RedingLog" pantailara itzultzen da.
     *
     * @throws IOException pantaila aldatzean errore bat gertatzen bada
     */
    @FXML
    private void handleGorde() throws IOException {
        String dateRange = dataText.getText();
        String rating = comboBoxRating.getValue();
        boolean hasFormat = fisikoaCheck.isSelected() || ebookCheck.isSelected() || audioCheck.isSelected();
        String notes = notesText.getText();

        // Data egiaztatu
        if (dateRange == null || dateRange.trim().equals("") || dateRange.equals("yyyy/mm/dd - yyyy/mm/dd")
                || !dateRange.contains(" - ")) {
            erakutziAlerta("Datu okerra",
                    "Data txarto sartu da.\nHurrengo formatua izan behar du: yyyy/mm/dd - yyyy/mm/dd");
            return;
        }

        // Puntuazioa egiaztatu
        if (rating == null || rating.trim().isEmpty()) {
            erakutziAlerta("Puntuazio falta", "Mesedez, aukeratu puntuazio bat.");
            return;
        }

        // Formatu bat aukeratu den egiaztatu
        if (!hasFormat) {
            erakutziAlerta("Formatu falta", "Mesedez, hautatu gutxienez formatu bat (fisikoa, ebook edo audiobook).");
            return;
        }

        // Iritzia egiaztatu
        if (notes == null || notes.trim().isEmpty()) {
            erakutziAlerta("Iritzia hutsik", "Mesedez, idatzi zure iritzia.");
            return;
        }

        // Datuak gorde
        datuakbidali();
        ReviewBook.clear();
        App.setRoot("RedingLog");
    }

    /**
     * Erabiltzailearen balorazioa eta iritzia datu-basean gordetzen ditu.
     * Formularioaren datuak hartzen ditu eta
     * {@link SqlConnector#insertOrUpdateReview} deitzen du.
     */
    private void datuakbidali() {
        User user = Erabiltzailea.getCurrentUser();
        if (user == null || selectedBook == null)
            return;

        String reviewText = notesText.getText();
        String rating = comboBoxRating.getValue();
        String format = getSelectedFormat();
        String genre = comboBoxRating.getValue(); // Hemen agian comboBoxGenre.getValue().name() izan behar du
        String dateRange = dataText.getText();
        String startDate = "";
        String endDate = "";

        // Data-formatuen banaketa eta egokitzapena
        if (dateRange != null && (dateRange.contains(" - ") || dateRange.contains("-"))) {
            if (dateRange.contains(" - ")) {
                String[] parts = dateRange.split(" - ");
                if (parts.length == 2) {
                    startDate = parts[0].trim().replace("/", "-");
                    endDate = parts[1].trim().replace("/", "-");
                }
            } else if (dateRange.contains("-")) {
                String[] parts = dateRange.split("-");
                if (parts.length == 2) {
                    startDate = parts[0].trim().replace("/", "-");
                    endDate = parts[1].trim().replace("/", "-");
                }
            }
        }

        SqlConnector.insertOrUpdateReview(selectedBook.getBookID(), user.getId(), reviewText, rating, format, genre,
                startDate, endDate);
    }

    /**
     * Hautatutako formatuaren arabera balioa itzultzen du.
     * 
     * @return Liburuaren formatu hautatua (FISICO, EBOOK edo AUDIOBOOK)
     */
    private String getSelectedFormat() {
        if (fisikoaCheck.isSelected())
            return "FISICO";
        if (ebookCheck.isSelected())
            return "EBOOK";
        if (audioCheck.isSelected())
            return "AUDIOBOOK";
        return "FISICO"; // lehenetsia
    }

    /**
     * Abisu bat bistaratzen du titulu eta mezu zehatz batekin.
     *
     * @param titulo Alertaren izenburua
     * @param mezua  Alertan erakutsiko den mezua
     */
    private void erakutziAlerta(String titulo, String mezua) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mezua);
        alert.showAndWait();
    }

    /**
     * Pantaila aldaketak: botoien ekintzak
     * 
     * @throws IOException pantaila aldatzean errore bat gertatzen bada
     */

    @FXML
    private void handleLogOut() throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void handleStats() throws IOException {
        App.setRoot("Stats");
    }

    @FXML
    private void handleRating() throws IOException {
        App.setRoot("RatingSystem");
    }

    @FXML
    private void handleLog() throws IOException {
        App.setRoot("RedingLog");
    }

    @FXML
    private void handleWish() throws IOException {
        App.setRoot("WishList");
    }

    @FXML
    private void handleReview() throws IOException {
        App.setRoot("BookReview");
    }
}
