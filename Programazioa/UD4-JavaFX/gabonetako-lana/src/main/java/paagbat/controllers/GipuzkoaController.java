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

public class GipuzkoaController {
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
        {"Non ospatzen da ohituraz Gipuzkoako Dantzari Eguna?", "Tolosa", "Azpeitia", "Donostia", "Ordizia", "3","01.jpeg","",""},
        {"Zein izen du hurrengo dantzak? adi musikari", "Zinta Dantza", "Agurra", "Kontrapas", "Aurrezku", "2","02.jpg","Musika","Agurra.mp3"},
        {"Zer tresna erabiltzen dira Gipuzkoako makil-dantzan?", "Makilak", "Ezpatak", "Zestak", "Arkuak", "1","03.jpeg","",""},
        {"Non egiten da ohituraz Uztailaren 31ko San Inazio Dantza?", "Azpeitian", "Oñatin", "Zumarragan", "Eibarren", "1","04.jpg","",""},
        {"Zein izen du dantza hau, bi makil txikirekin dantzatzen dena?", "Ezpata Dantza", "Txakolin Dantza", "Makil Txiki", "Aurresku", "3","05.jpg","",""},
        {"Non egiten dira ohituraz Erromeria-dantzak Gipuzkoan?", "Seguran", "Getarian", "Tolosa eta Oiartzunen", "Zarautz eta Usurbilen", "3","06.jpg","",""},
        {"Zein izen du hurrengo dantzak? adi musikari", "Zinta Dantza", "Txakolin Dantza", "Kontrapas", "Makil Txiki", "1","07.jpeg","Musika","ZintaDantzaG.mp3"},
        {"Zein da gaur egun Gipuzkoan dagoen dantza tradizionalik zaharrena?", "Soka Dantza", "Esku Dantza", "Txulalai", "Ezpata Joko", "4","08.jpg","",""},
        {"Zein izen du hurrengo dantzak?", "Ezpata Dantza", "Aurresku", "Arku Dantza", "Kaskarot", "3","09.jpg","",""},
        {"Zein izen du hurrengo dantzak? adi musikari", "Zinta Dantza", "Txakolin Dantza", "Kontrapas", "Makil Txiki", "4","10.jpeg","Musika","MakilTxikiG.mp3"},
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
            String imagePath = "/paagbat/images/giputxi/" + currentQuestion[6]; // Ajusta la ruta
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
        questionLabel.setText("Galdetegia bukatu da!\n Zure puntuazioa: " + score +"/"+questions.length);
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