package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.HerriakAccess;

public class CheckBoxController {
    HerriakAccess atzipena = new HerriakAccess();

    @FXML
    VBox vBoxHerriak;


    @FXML
    Label lbGuztira;
    
    @FXML
    Label lbEzagunak;


    @FXML
    protected void initialize() {
        lbEzagunak.setText("0");
        List<String> herriak = atzipena.getHerriIzenak();
        for (String herria : herriak) {
            CheckBox checkBox = new CheckBox(herria);
            vBoxHerriak.getChildren().add(checkBox);
            checkBox.setOnMouseClicked(event -> {
                int balioa;
                if (((CheckBox) event.getSource()).isSelected()) 
                    balioa = 1;
                else
                    balioa=-1;
                
                lbEzagunak.setText(String.valueOf(Integer.parseInt(lbEzagunak.getText()) + balioa));
            });
        }
        lbGuztira.setText(String.valueOf(herriak.size()));
     
        
    }

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Hasierakoa");
    }



    
    // private void selectCount() throws IOException {

    // atzipena.irakurriDatuBakarra();
    // }

    // @FXML
    // private void insert() throws IOException {
    // atzipena.txertatu(tfTxertatu.getText());
    // atzipena.irakurriDatuAnitzak();
    // }

    // @FXML
    // private void select() throws IOException {
    // atzipena.irakurriDatuAnitzak();
    // }

    // @FXML
    // private void update() throws IOException {
    // atzipena.aldatu(tfUpdate1.getText(), tfUpdate2.getText());
    // atzipena.irakurriDatuAnitzak();
    // }

    // @FXML
    // private void delete() throws IOException {
    // atzipena.ezabatu(tfEzabatu.getText());
    // atzipena.irakurriDatuAnitzak();
    // }

}
