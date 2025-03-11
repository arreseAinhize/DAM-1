package paagbat.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
//import dambat.model.base.Herria;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import paagbat.App;
import paagbat.model.HerriakAccess;
import paagbat.model.base.Herria;

//https://github.com/imadariaga/datu-atzipena2019/blob/master/UD0/Ikasleak/src/controller/IkasleenTaulaController.java
public class TableViewController implements Initializable {
    HerriakAccess atzipena = new HerriakAccess();

    @FXML
    TextField tfHerria;
    @FXML
    TextField tfProbintzia;
    
    @FXML
    TableView<Herria> tableViewHerriak;
    @FXML
    private TableColumn<Herria,String> tableColumnHerria;
    @FXML
    private TableColumn<Herria, String> tableColumnProbintzia;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Herria> herrienObservableLista = FXCollections.observableArrayList(atzipena.getHerriak());

        //Zutabeen zabalera portzentuala definitu        
        tableColumnHerria.prefWidthProperty().bind(tableViewHerriak.widthProperty().multiply(0.6));
        tableColumnProbintzia.prefWidthProperty().bind(tableViewHerriak.widthProperty().multiply(0.4));       

        // TableView-ko lerroak ObservableList-arekin lotuko ditugu
        tableViewHerriak.setItems(herrienObservableLista);

        // // Zutabe bakoitza zein atributorekin dagoen lotuta definituko dugu (zutabeko
        // // zeldak zein atributorekin beteko diren)
        tableColumnHerria.setCellValueFactory(new PropertyValueFactory<Herria, String>("herria"));// ObservableListaren elementu
        tableColumnProbintzia.setCellValueFactory(new PropertyValueFactory<Herria, String>("probintzia"));
        
        // // Table view elementua fxml-an editable dela adierazita daukagula, zelden
        // // editatzeak ondo funtzionatzeko:
//        idCol.setCellFactory(TextFieldTableCell.<HerriaProbintziaz, Integer>forTableColumn(new IntegerStringConverter()));
        // idCol.setOnEditCommit((TableColumn.CellEditEvent<HerriaProbintziaz, Integer> t) -> {
        //     ((HerriaProbintziaz) t.getTableView().getItems().get(
        //             t.getTablePosition().getRow())).setId(t.getNewValue());
        // });

        // izenaCol.setCellFactory(TextFieldTableCell.<HerriaProbintziaz>forTableColumn());
        // izenaCol.setOnEditCommit((TableColumn.CellEditEvent<HerriaProbintziaz, String> t) -> {
        //     ((HerriaProbintziaz) t.getTableView().getItems().get(
        //             t.getTablePosition().getRow())).setIzena(t.getNewValue());
        // });

    }

    @FXML
    void handleGehitu() {

        try {
            Herria herria = new Herria( tfHerria.getText(), tfProbintzia.getText());

            tableViewHerriak.getItems().add(herria);

            System.out.println("Herri berria gehitu duzu.");
        } catch (NumberFormatException ex) {
           // System.out.println("Kodea eta adina zenbakiak izan behar dute.");
           // lbMezua.setText("Kodea eta adina zenbakiak izan behar dute.");
        }
        ;
    }
    @FXML
    void handleAtzera() throws IOException {
        App.setRoot("Hasierakoa");
    }
}
