package paagbat;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EragiketakController {

    @FXML
    private Label diruKopurua; // Este es el Label donde se muestra el valor.

    @FXML
    private Button gehituBat; // Este es el botón que al hacer clic sumará 1.

    @FXML
    private Button kenduBat;
    
    @FXML
    private Button eragiketa;

    // Método que incrementa el valor en el Label.
    @FXML
    public void plusOne() {
        // Convertir el texto del Label a un número entero.
        int sales = Integer.parseInt(diruKopurua.getText());

        // Incrementar el número.
        sales++;

        // Asignar el nuevo valor al Label.
        diruKopurua.setText(Integer.toString(sales));
    }

    @FXML
    public void minusOne() {
        // Convertir el texto del Label a un número entero.
        int sales = Integer.parseInt(diruKopurua.getText());

        // Incrementar el número.
        sales--;

        // Asignar el nuevo valor al Label.
        diruKopurua.setText(Integer.toString(sales));
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void eragiketa(ActionEvent event) {
        System.out.println("Botón '=' pulsado");
        // Aquí puedes poner la lógica para realizar la operación.
    }
}
