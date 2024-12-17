package paagbat;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController {
    @FXML
    private Label emaitzaAtera;
    @FXML
    private Button deleteButton;
    @FXML
    private Button deleteOneButton;
    @FXML
    private Button komaButton;
    @FXML
    private Button zatiketaButton;
    @FXML
    private Button biderketaButton;
    @FXML
    private Button porcentajebutton;
    @FXML
    private Button kenketaButton;
    @FXML
    private Button gehiketaButton;
    @FXML
    private Button emaitzaButton;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    @FXML
    private void deleteOne() throws IOException {
        System.out.println("deleteOne");
    }

    @FXML
    private void delete() throws IOException {
        System.out.println("delete");
    }

    @FXML
    private void zatiketaKalkulua() throws IOException {
        System.out.println("zatiketaKalkulua");
    }

    @FXML
    private void biderketaKalkulua() throws IOException {
        System.out.println("biderketaKalkulua");
    }

    @FXML
    private void kenketaKalkulua() throws IOException {
        System.out.println("kenketaKalkulua");
    }

    @FXML
    private void gehiketaKalkulua() throws IOException {
        System.out.println("gehiketaKalkulua");
    }

    @FXML
    private void emaitzaBiztaratu() throws IOException {
        System.out.println("emaitzaBiztaratu");
    }

    @FXML
    private void porcentajeKalkulua() throws IOException {
        System.out.println("porcentajeKalkulua");
    }

    private void digitoaAukeratu(ActionEvent actionEvent) throws IOException {

        switch (((Button) actionEvent.getSource()).getText()) {

            case
                    "1":

                    emaitzaAtera.setText(emaitzaAtera.getText() + 1);

                break;

            case "2":

            emaitzaAtera.setText(emaitzaAtera.getText() + 1);

                break;
        }
    }

}
