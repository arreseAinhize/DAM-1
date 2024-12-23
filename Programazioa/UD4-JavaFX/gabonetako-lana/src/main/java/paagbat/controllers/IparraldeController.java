package paagbat.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import paagbat.app.App;

public class IparraldeController {

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

    private int questionIndex = 0;
    private int score = 0;

    private final String[][] questions = {
        {"Zein herritan egiten da ohituraz Maskaradak?", "Maule-Lextarre", "Donibane Lohizune", "Baiona", "Biarritz", "1","01.jpg","",""},
        {"Zein izen du Zuberoako maskaradetan egiten den dantza solemne hau?", "Godalet Dantza", "Ezpata Dantza", "Mutxikoak", "Kontrapas", "1","02.jpg","",""},
        {"Zein tresna erabiltzen dira Lapurdiko Zinta Dantzan?", "Ezpatak", "Makil txikiak",  "Zintak","Arkuak", "3","03.jpg","",""},
        {"Zein da Zuberoako dantza dramatiko ezagunenetako bat?", "Maskaradak", "Aurresku", "Kaskarot", "Esku Dantza", "1","04.jpg","",""},
        {"Zein herritan ospatzen dira ohituraz Kaskarotak?",  "Ziburu", "Maule-Lextarre","Donibane Lohizune", "Hendaia", "3","05.jpg","",""},
        {"Zein izen du dantza honetan,\nbikoteak elkarri aurrez aurre dantzatzen dioten dantza solemnean?",  "Zinta Dantza", "Txakolin Dantza", "Agurra","Mutxikoak", "4","06.jpg","",""},
        {"Zein elementu erabiltzen dituzte Lapurdiko Zinta Dantzan?", "Zintak", "Ezpatak", "Makil txikiak", "Arkuak", "1","07.jpg","",""},
        {"Zer dantza egiten da ohituraz Baionako festetan?", "Fandangoa", "Txulalai", "Soka Dantza", "Ezpata Joko", "3","08.jpg","",""},
        {"Zein izen du ohituraz Iparraldeko kalejiretan egiten den dantza?",  "Aurresku","Txulalai", "Esku Dantza", "Kontrapas", "2","09.jpg","",""},
        {"Zein izen du Zuberoako maskaradetan pertsonaien artean egiten den dantza hau?", "Godalet Dantza", "Ezpata Dantza", "Agurra", "Zinta Dantza", "1","10.jpg","",""}
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
            // String imagePath = "/paagbat/images/bizkaia/" + currentQuestion[6]; // Ajusta la ruta
            // Image image = new Image(getClass().getResourceAsStream(imagePath));
            // easyImg.setImage(image);
        } else {
            endQuiz();
        }
    }

    private void clearQuestion() {
        easyImg.setImage(null); // Limpiar la imagen
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
        questionLabel.setText("Galdetegia bukatu da!\n Zure puntuazioa: " + score+"/"+questions.length);
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



