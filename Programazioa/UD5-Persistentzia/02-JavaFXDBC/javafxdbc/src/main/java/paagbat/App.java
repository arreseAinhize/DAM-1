package paagbat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paagbat.model.HerrienAtzipenak;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static HerrienAtzipenak herriak = new HerrienAtzipenak("localhost","HerrienDBa","Herriak","ikaslea","ikaslea");
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("Nagusia"),500,700);
        scene.getStylesheets().add(getClass().getResource("css/ModenaAldatua.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("02-JavaFXJDBC");
        
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