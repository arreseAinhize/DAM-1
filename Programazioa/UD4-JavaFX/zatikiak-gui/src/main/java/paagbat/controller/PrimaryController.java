package paagbat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import paagbat.model.Zatikia;

public class PrimaryController {

    @FXML
    private TextField zat1Zenba;
    @FXML
    private TextField zat1Izenda;
    @FXML
    private TextField zat2Zenba;
    @FXML
    private TextField zat2Izenda;
    @FXML
    private Button eragMota;
    @FXML
    private Button eragEmaitza;
    @FXML
    private Label zat3Zenba;
    @FXML
    private Label zat3Izenda;
    @FXML
    private Label errorMSG;

    private String currentOperation = "+"; // Operación actual (suma por defecto)

    @FXML
    private void eragAldatu() {
        switch (currentOperation) {
            case "+":
                currentOperation = "-";
                eragMota.setText("-"); // Cambiar texto del botón
                break;
            case "-":
                currentOperation = "*";
                eragMota.setText("*");
                break;
            case "*":
                currentOperation = "/";
                eragMota.setText("/");
                break;
            default:
                currentOperation = "+";
                eragMota.setText("+");
                break;
        }
    }

    @FXML
    public void emaitza() {
        try {
            Zatikia zat1 = new Zatikia(Integer.parseInt(zat1Zenba.getText()), Integer.parseInt(zat1Izenda.getText()));
            Zatikia zat2 = new Zatikia(Integer.parseInt(zat2Zenba.getText()), Integer.parseInt(zat2Izenda.getText()));
            switch (currentOperation) {
                case "-":
                    Zatikia zatKendu = Zatikia.kendu(zat1, zat2);
                    zat3Zenba.setText(String.valueOf(zatKendu.getZenbakitzailea()));
                    zat3Izenda.setText(String.valueOf(zatKendu.getIzendatzailea()));
                    break;
                case "*":
                    Zatikia zatBiderkatu = Zatikia.biderkatu(zat1, zat2);
                    zat3Zenba.setText(String.valueOf(zatBiderkatu.getZenbakitzailea()));
                    zat3Izenda.setText(String.valueOf(zatBiderkatu.getIzendatzailea()));
                    break;
                case "/":
                    Zatikia zatZatitu = Zatikia.zatiketa(zat1, zat2);
                    zat3Zenba.setText(String.valueOf(zatZatitu.getZenbakitzailea()));
                    zat3Izenda.setText(String.valueOf(zatZatitu.getIzendatzailea()));
                    break;
                default:
                    Zatikia zatBatu = Zatikia.batu(zat1, zat2);
                    zat3Zenba.setText(String.valueOf(zatBatu.getZenbakitzailea()));
                    zat3Izenda.setText(String.valueOf(zatBatu.getIzendatzailea()));
                    break;
            }
        } catch (NumberFormatException e) {
            errorMSG.setText("Karratuetan zenbakiak sartu behar dira.");
        }
    }
}   
