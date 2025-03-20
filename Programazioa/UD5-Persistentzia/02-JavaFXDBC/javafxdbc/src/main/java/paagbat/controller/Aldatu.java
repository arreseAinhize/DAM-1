package paagbat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.base.Herria;

public class Aldatu {
    @FXML
    VBox vBoxHerriak;

    @FXML
    Label lbMezua,lbIzena,lbProbintzia;

    @FXML
    TextField txfIzena, txfProbintzia;

    @FXML
    CheckBox chkNombre, chkProvincia, chkAmbos; 

    private List<CheckBox> checkBoxes = new ArrayList<>();

    /** Herri bakoitzeko checkbox bat sortuko da. */
    @FXML
    protected void initialize() {
        List<String> herriak = App.herriak.getHerriIzenak();
        for (String herria : herriak) {
            CheckBox checkBox = new CheckBox(herria);
            checkBoxes.add(checkBox);
            vBoxHerriak.getChildren().add(checkBox);

            // Evento para manejar la selección
            checkBox.setOnAction(e -> manejarSeleccion(checkBox));
        }

        // Ocultar botones al inicio
        chkNombre.setVisible(false);
        chkProvincia.setVisible(false);
        chkAmbos.setVisible(false);
        txfIzena.setVisible(false);
        txfProbintzia.setVisible(false);

        chkNombre.setOnAction(e -> manejarOpciones(chkNombre));
        chkProvincia.setOnAction(e -> manejarOpciones(chkProvincia));
        chkAmbos.setOnAction(e -> manejarOpciones(chkAmbos));
    }

    private void manejarSeleccion(CheckBox seleccionado) {
        if (seleccionado.isSelected()) {
            for (CheckBox cb : checkBoxes) {
                if (cb != seleccionado) {
                    cb.setDisable(true);
                }
            }

            // Mostrar opciones de cambio
            chkNombre.setVisible(true);
            chkProvincia.setVisible(true);
            chkAmbos.setVisible(true);
        } else {
            for (CheckBox cb : checkBoxes) {
                cb.setDisable(false);
            }

            // Ocultar todo
            chkNombre.setVisible(false);
            chkProvincia.setVisible(false);
            chkAmbos.setVisible(false);
            txfIzena.setVisible(false);
            txfProbintzia.setVisible(false);

        }
    }

    private void manejarOpciones(CheckBox seleccionado) {
        // Desmarcar los otros CheckBoxes para que solo uno esté activo
        if (seleccionado.isSelected()) {
            if (seleccionado == chkNombre) {
                chkProvincia.setSelected(false);
                chkAmbos.setSelected(false);
                txfIzena.setVisible(true);
                txfProbintzia.setVisible(false);
                lbMezua.setText("Sartu izen berria:");
                lbIzena.setText("Izena: ");
                lbProbintzia.setText("");
            } else if (seleccionado == chkProvincia) {
                chkNombre.setSelected(false);
                chkAmbos.setSelected(false);
                txfIzena.setVisible(false);
                txfProbintzia.setVisible(true);
                lbMezua.setText("Sartu probintzia berria:");
                lbIzena.setText("");
                lbProbintzia.setText("Probintzia: ");
            } else if (seleccionado == chkAmbos) {
                chkNombre.setSelected(false);
                chkProvincia.setSelected(false);
                txfIzena.setVisible(true);
                txfProbintzia.setVisible(true);
                lbMezua.setText("Sartu izen eta probintzia berriak:");
                lbIzena.setText("Izena: ");
                lbProbintzia.setText("Probintzia: ");
            }
        } else {
            // Si se deselecciona, ocultar los TextArea
            txfIzena.setVisible(false);
            txfProbintzia.setVisible(false);
            lbMezua.setText("");
            lbIzena.setText("");
            lbProbintzia.setText("");
        }
    }

    @FXML
    void handleAldatu() throws IOException {
        boolean herriaAukeratu = false;
        
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                herriaAukeratu = true;
                String herriaIzena = checkBox.getText();  // Obtener el nombre del pueblo seleccionado
    
                if (chkNombre.isSelected()) {
                    // Obtener el nuevo nombre del TextField
                    String izenBerria = txfIzena.getText().trim();
                    if (!izenBerria.isEmpty()) {
                        App.herriak.aldatuIzena(herriaIzena, izenBerria);
                        lbMezua.setText("Izena aldatu da: " + izenBerria);
                    } else {
                        lbMezua.setText("Izena hutsik dago!");
                    }
                } 
                else if (chkProvincia.isSelected()) {
                    // Obtener la nueva provincia del TextField
                    String probintziaBerria = txfProbintzia.getText().trim();
                    if (!probintziaBerria.isEmpty()) {
                        App.herriak.aldatuProbintzia(herriaIzena, probintziaBerria);
                        lbMezua.setText("Probintzia aldatu da: " + probintziaBerria);
                    } else {
                        lbMezua.setText("Probintzia hutsik dago!");
                    }
                } 
                else if (chkAmbos.isSelected()) {
                    // Obtener ambos valores
                    String izenBerria = txfIzena.getText().trim();
                    String probintziaBerria = txfProbintzia.getText().trim();
    
                    if (!izenBerria.isEmpty() && !probintziaBerria.isEmpty()) {
                        Herria herriBerria = new Herria(izenBerria, probintziaBerria);
                        App.herriak.aldatuHerria(herriaIzena, herriBerria);
                        lbMezua.setText("Herria eguneratua: " + izenBerria + ", " + probintziaBerria);
                    } else {
                        lbMezua.setText("Izena eta Probintzia bete behar dira!");
                    }
                }
            }
        }
    
        if (!herriaAukeratu) {
            lbMezua.setText("Ez da herria aukeratu.");
        }
    }
    

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Nagusia");
    }
}
