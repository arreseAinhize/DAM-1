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
import paagbat.model.base.KostakoHerria;

public class Txertatu {
    //HerrienZerak herrienZerak = new HerrienZerak();
    private List<TextField> hondartzaField = new ArrayList<>();

    @FXML
    VBox vBoxHerriarenDatuak;

    @FXML
    TextField txfIzena;

    @FXML
    TextField txfProbintzia;

    @FXML
    CheckBox chkKostakoa;

    @FXML
    Label lbMezua;

    @FXML
    protected void initialize() {
        System.out.println(App.herriak.getHerrienZerrenda());
    }

    /** Herria txertatzeko botoia sakatzerakoan exekutatzen da metodo hau.
     *  Lehengo eta behin izena eta probintzia eremuak beteta dauden egiaztatuko da eta beteta 
     *  ez badaude, mezua aterako da lbMezua labelean.
     *  Herri hori dagoeneko zerrendan baldin badago, mezu egokia idatziko da mezuen labelean.
     *  Baldintza biak beteta, eszenako datuekin herri edo kostako herri berri bat gehituko da 
     *  herrien zerrendan. Eta eszena nagusira itzuliko gara.
     * */
    @FXML
    public void handleTxertatu() throws IOException {
        // OSATU EZAZU
        String izena = txfIzena.getText();
        String probintzia = txfProbintzia.getText();

        if (izena.isEmpty() || probintzia.isEmpty()) {
            lbMezua.setText("Izena eta Probintzia eremuak osatuta izan behar dira.");
            return;  // Evita que el código siga ejecutándose
        }

        if (App.herriak.herriaBaDago(izena)) {
            lbMezua.setText("Herria aurretik sortua dago.");
            return;
        }

        if (chkKostakoa.isSelected()) {
            String[] hondartzaIzenak = new String[3]; 

            int index = 0;

            for (TextField field : hondartzaField) {
                String hondartzaIzena = field.getText().trim();

                if (hondartzaIzena != null && !hondartzaIzena.isEmpty()) {
                    if (index < 3) {
                        hondartzaIzenak[index++] = hondartzaIzena;
                    }
                }
            }

            App.herriak.add(new KostakoHerria(izena, probintzia, hondartzaIzenak));
        } else {
            App.herriak.add(new Herria(izena, probintzia));
        }

        lbMezua.setText("Herria ondo txertatu da!");
    }
    
    /** Kostakoa CheckBoxa markatzerakoan, hiru TextField gehituko dira
     *  herriaren hondartzak gehitu ahal izateko. (Ezingo ditugu hiru hondartza baino gehiago gehitu) 
     *  Kostakoa CheckBoxa ezmarkatzerakoan, hiru TextField-ak ezabatuko dira.
     */
    @FXML
    void handleKostakoa() throws IOException {
        // OSATU EZAZU
        if (chkKostakoa.isSelected()) {
            for (int i = 0; i < 3; i++) {
                TextField hondartzaText = new TextField();
                hondartzaField.add(hondartzaText);
                vBoxHerriarenDatuak.getChildren().add(hondartzaText);
            }
        } else {
            // Eliminar los TextFields cuando se desmarca el CheckBox
            vBoxHerriarenDatuak.getChildren().removeAll(hondartzaField);
            hondartzaField.clear();
        }
    }

    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Nagusia");
    }

}
