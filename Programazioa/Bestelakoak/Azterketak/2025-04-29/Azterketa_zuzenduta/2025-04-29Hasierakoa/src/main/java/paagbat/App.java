package paagbat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paagbat.model.ErabiltzaileenAtzipena;
import paagbat.model.base.Saioa;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static ErabiltzaileenAtzipena erabiltzaileenAtzipena = new ErabiltzaileenAtzipena("localhost", "root", "", "ErabiltzaileenDatuBasea", "Erabiltzaileak");
    public static Saioa saioa;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("Login"),700,700);
        scene.getStylesheets().add(getClass().getResource("css/ModenaAldatua.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("ErabiltzaileenDatuBasea (MariaDB zerbidore lokalaren bezeroa)");
        
    //    stage.setFullScreen(true);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}