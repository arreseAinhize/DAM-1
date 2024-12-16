package paagbat;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PrimaryController {
    @FXML
    private TextField zenbBat;
    @FXML
    private TextField zenbBi;
    @FXML
    private Button eragMota;
    @FXML
    private Button eragEgin;
    @FXML
    private Label eragEmaitza;

    private String currentOperation = "+"; // Operación actual (suma por defecto)

    DecimalFormat decimalFormat = new DecimalFormat("###.###"); // 2 decimal places

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
            int zenb1 = Integer.parseInt(zenbBat.getText());
            int zenb2 = Integer.parseInt(zenbBi.getText());
            int zenb3 = 0;
            double zenbDouble3 = 0;
            switch (currentOperation) {
                case "-":
                    zenb3 = zenb1 - zenb2;
                    eragEmaitza.setText(Integer.toString(zenb3)); // Cambiar texto del botón
                    break;
                case "*":
                    zenb3 = zenb1 * zenb2;
                    eragEmaitza.setText(Integer.toString(zenb3));
                    break;
                case "/":
                    zenbDouble3 = (double) zenb1 / zenb2;
                    eragEmaitza.setText(decimalFormat.format(zenbDouble3));
                    break;
                default:
                    zenb3 = zenb1 + zenb2;
                    eragEmaitza.setText(Integer.toString(zenb3));
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Zenbaki bat sartu behar da.");
        }
    }
}
