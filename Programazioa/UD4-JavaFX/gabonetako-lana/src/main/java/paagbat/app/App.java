package paagbat.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import paagbat.utils.AudioManager;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;



    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Euskal Dantzak");

        Image image = new Image(App.class.getResourceAsStream("/paagbat/images/Icon.png")); // carga imagen desde los recursos
        stage.getIcons().add(image);
        
        
        scene = new Scene(loadFXML("/paagbat/fxml/home"), 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}