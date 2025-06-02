package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import paagbat.App;
import paagbat.model.base.Saioa;

public class Logs {
    int filtroaM = 0;
    int filtroaE = -1;
    @FXML
    private TextArea tAreaErabiltzaileak;
    @FXML
    private Label lbIzenburua;
    @FXML
    protected void initialize() {
        textAreaBete(filtroaM);                    
    }

    @FXML
    public void handleIrten() throws IOException{
        App.setRoot("Nagusia");
    }
    
    @FXML
    public void handleFiltratuE() throws IOException{
        int erabiltzaileKopurua = App.erabiltzaileenAtzipena.getErabiltzaileKopurua();
        filtroaE++;
        List<Saioa> saioak = null;

        if (filtroaE >= erabiltzaileKopurua) {
            filtroaE = -1;
            lbIzenburua.setText("Logs-ak");
            saioak = App.erabiltzaileenAtzipena.getSaioak();
        } else {
            List<String> kontuak = App.erabiltzaileenAtzipena.getKontuak();
            String kontua = kontuak.get(filtroaE);
            lbIzenburua.setText(kontua + "-ren Saioak");
            saioak = App.erabiltzaileenAtzipena.getErabiltzaileBakoitzarenSaioak(kontua);
        }

        // Mostrar los logs en el TextArea (esto se ejecuta siempre)
        tAreaErabiltzaileak.clear();
        tAreaErabiltzaileak.appendText("Kontua, Sarrera Data, Irteera Data" + "\n");
        tAreaErabiltzaileak.appendText("==============================" + "\n");
        if (saioak != null) {
            for (Saioa saioa : saioak) {
                tAreaErabiltzaileak.appendText(saioa.toString() + "\n");
            }
        }
    }

    @FXML
    public void handleFiltratuM() throws IOException{
        filtroaM--;
        if(filtroaM == 0){
            lbIzenburua.setText("Logs-ak");
        }else if(filtroaM == -1){
            lbIzenburua.setText("Ikasleen Logs-ak");
        }else if(filtroaM == -2){
            lbIzenburua.setText("Irakasleen Logs-a");
        }else{
            filtroaM = 0;
            lbIzenburua.setText("Logs-ak");
        }
        textAreaBete(filtroaM);
    }


    private void textAreaBete(int filtroa){
        tAreaErabiltzaileak.clear();
        tAreaErabiltzaileak.appendText("Kontua, Sarrera Data, Irteera Data" + "\n");
        tAreaErabiltzaileak.appendText("==============================" + "\n");
        List<Saioa> saioak = null;
        if(filtroa == 0){
            saioak = App.erabiltzaileenAtzipena.getSaioak();
        }else if(filtroa == -1){
            saioak = App.erabiltzaileenAtzipena.getRolBatekoSaioak("ikaslea");
        }else if(filtroa == -2){
            saioak = App.erabiltzaileenAtzipena.getRolBatekoSaioak("irakaslea");
        }
        for(Saioa saioa : saioak){
            tAreaErabiltzaileak.appendText(saioa.toString() + "\n");
        }
    } 
}
