package paagbat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import paagbat.model.Eragiketa;


public class PrimaryController {
    private String operator = "";
    @FXML
    private TextField textEragiketaEnter;
    @FXML
    private Button deleteButton,deleteOneButton,emaitzaButton;
    @FXML
    private Button porcentajebutton,zatiketaButton,biderketaButton,kenketaButton,gehiketaButton;
    @FXML
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    @FXML
    private Label eragiketaAtera,emaitzaAtera;
    
    @FXML
    private void operatorAukeratu(ActionEvent actionEvent){
        operator = ((Button) actionEvent.getSource()).getText();
        emaitzaAtera.setText(emaitzaAtera.getText() + operator);
    }

    @FXML
    private void digitoaAukeratu(ActionEvent actionEvent){
        String digit = ((Button) actionEvent.getSource()).getText().trim();
        if (emaitzaAtera.getText().length() == 0) {
            emaitzaAtera.setText(digit);
        } else {
            emaitzaAtera.setText(emaitzaAtera.getText() + digit);
        }
    }


    @FXML
    private void emaitzaBiztaratu(){
        eragiketaAtera.setText("");
        double result = 0;
        String eragiketa = "";
        Eragiketa eragiketak;
        if (emaitzaAtera.getText().length() == 0) {
            eragiketa = textEragiketaEnter.getText();
            eragiketak =  new Eragiketa(eragiketa);
        }else{
            eragiketa = emaitzaAtera.getText();
            eragiketak =  new Eragiketa(eragiketa);
        }
        if (operator.equals("+")) {
            result = eragiketak.batuketa(eragiketak.getZenb1(),eragiketak.getZenb2());
        } else if (operator.equals("-")) {
            result = eragiketak.kenketa(eragiketak.getZenb1(),eragiketak.getZenb2());
        } else if (operator.equals("*")) {
            result = eragiketak.biderketa(eragiketak.getZenb1(),eragiketak.getZenb2());
        } else if (operator.equals("/")) {
            result = eragiketak.zatiketa(eragiketak.getZenb1(),eragiketak.getZenb2());
        }else if(operator.equals("%")){
            result = eragiketak.ehunekoa(eragiketak.getZenb1());
        }
        emaitzaAtera.setText("");
        eragiketaAtera.setText(eragiketa + "=" + result);
    }

    @FXML
    private void deleteOne(){
        String currentText = emaitzaAtera.getText();
        if (!currentText.isEmpty()) {
            emaitzaAtera.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    private void delete(){
        eragiketaAtera.setText(operator);
        emaitzaAtera.setText("");
        operator = "";
    }

    // private double kalkuluak(Eragiketa eragiketak){
    //     double result = 0;
    //     if (operator.equals("+")) {
    //         result = eragiketak.batuketa(eragiketak.getZenb1(),eragiketak.getZenb2());
    //     } else if (operator.equals("-")) {
    //         result = eragiketak.kenketa(eragiketak.getZenb1(),eragiketak.getZenb2());
    //     } else if (operator.equals("*")) {
    //         result = eragiketak.biderketa(eragiketak.getZenb1(),eragiketak.getZenb2());
    //     } else if (operator.equals("/")) {
    //         result = eragiketak.zatiketa(eragiketak.getZenb1(),eragiketak.getZenb2());
    //     }else if(operator.equals("%")){
    //         result = eragiketak.ehunekoa(eragiketak.getZenb1());
    //     }
    //     return result;
    // }
}
