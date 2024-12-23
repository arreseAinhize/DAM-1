package paagbat.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import paagbat.app.App;

public class BizkaiaController {
    @FXML
    private ImageView easyImg;

    @FXML
    private Label questionLabel;

    @FXML
    private Button playquizbtn;

    @FXML
    private Button playquizbtn1;

    @FXML
    private Button playquizbtn2;

    @FXML
    private Button playquizbtn3;

    @FXML
    private Button playquizbtn4;

    private MediaPlayer mediaPlayer;
    private int questionIndex = 0;
    private int score = 0;

    private final String[][] questions = {
        {"Non ospatuko da 2025ko bizkaiko dantzari eguna?", "Zornotza", "Lekeitio", "Sestao", "Basauri", "2","04.jpg","",""},
        {"Zein izen du hurrengo dantzak? adi musikari", "Makil joko", "Ezpata nagusi", "Txotxongilo", "Ezpata txiki", "2","02.jpg","Musika","ezpataNagusi.mp3"},
        {"Zein izen du hurrengo dantzak?", "Agintariena", "Agurra", "Aurrezkua", "Zeharkakoa", "1","01.jpg","",""},
        {"Zer tresna erabiltzen dira dantzari-dantzan?", "Ezpatak eta makilak", "Arkuak", "Makilak", "Zestak", "1","05.jpg","",""},
        {"Zein izen du hurrengo dantzak? adi musikari", "Makil joko", "Ezpata nagusi", "Txotxongilo", "Ezpata txiki", "1","08.jpg","Musika","makil.mp3"},
        {"Zein izen du hurrengo dantzak?", "Kontrapas", "Sagar dantza", "Zinta dantza", "Kaskarot", "3","03.jpg","",""},
        {"Non egiten dira ohituraz Erregelak dantzak?", "Lekeitio eta Ondarroan", " Bakion eta Mungian", "Gernika eta Garain", "Basauri eta Karrantzan", "3","06.jpg","",""},
        {"Non egiten da ohituraz Karmen eguneko dantza?", "Mungian", "Bakion","Ermun","Markina-Xeimein", "4","07.jpg","",""},
        {"Zein izen du hurrengo dantzak? adi musikari", "Arku dantza", "Ibarzabal arku dantza", "Gorulari", "Zinta dantza", "2","09.jpg","Musika","ibarzabal.mp3"},
        {"Jarraitu letra:\nGolpe golpe golpeka, josi ta josi, josi ta josi,\ngolpe golpe golpeka josi ta josi ___ _______", "Nik zapatak", "Bi zapatak", "Hik zapatak", "Guk zapatak", "2","10.jpg","Musika","golpegolpe.mp3"}
    };

    @FXML
    public void initialize() { 
        loadQuestion();
    }

    @FXML
    private void switchToHome(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int selectedOption = -1;

        if (clickedButton == playquizbtn) {
            selectedOption = 4;
        } else if (clickedButton == playquizbtn1) {
            selectedOption = 3;
        } else if (clickedButton == playquizbtn2) {
            selectedOption = 2;
        } else if (clickedButton == playquizbtn3) {
            selectedOption = 1;
        }

        checkAnswer(selectedOption);
    }

    private void loadQuestion() {
        clearQuestion();
        playquizbtn4.setDisable(true);
        if (questionIndex < questions.length) {
            String[] currentQuestion = questions[questionIndex];
            questionLabel.setText(currentQuestion[0]); // Pregunta
            playquizbtn3.setText(currentQuestion[1]); // Opción 1
            playquizbtn2.setText(currentQuestion[2]); // Opción 2
            playquizbtn1.setText(currentQuestion[3]); // Opción 3
            playquizbtn.setText(currentQuestion[4]); // Opción 4
            String imagePath = "/paagbat/images/bizkaia/" + currentQuestion[6]; // Ajusta la ruta
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            easyImg.setImage(image);
            if (currentQuestion[7].contains("Musika")) {
                try {
                    String soundPath = "/paagbat/sounds/" + currentQuestion[8]; // Ajusta la ruta
                    Media sound = new Media(getClass().getResource(soundPath).toString());
                    mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                } catch (Exception e) {
                    System.err.println("Error loading sound: " + e.getMessage());
                }
            }
        } else {
            endQuiz();
        }
    }

    private void clearQuestion() {
        easyImg.setImage(null); // Limpiar la imagen
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose(); // Libera los recursos del MediaPlayer
            mediaPlayer = null; // Establece el MediaPlayer a nulo para la próxima pregunta
        }
    }

    private void checkAnswer(int selectedOption) {
        int correctAnswer = Integer.parseInt(questions[questionIndex][5]);

        if (selectedOption == correctAnswer) {
            score++;
        }

        questionIndex++;
        loadQuestion();
    }

    private void endQuiz() {
        questionLabel.setText("Galdetegia bukatu da!\n Zure puntuazioa: " + score+"/10");
        playquizbtn.setText("");
        playquizbtn1.setText("");
        playquizbtn2.setText("");
        playquizbtn3.setText("");
        playquizbtn.setDisable(true);
        playquizbtn1.setDisable(true);
        playquizbtn2.setDisable(true);
        playquizbtn3.setDisable(true);
        playquizbtn4.setDisable(false);
    }
    
    @FXML
    private void returHome() throws IOException{
        App.setRoot("/paagbat/fxml/home");
    }
}