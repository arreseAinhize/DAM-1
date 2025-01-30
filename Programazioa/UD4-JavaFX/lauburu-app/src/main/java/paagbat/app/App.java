package paagbat.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Screen;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Euskara Lantzen");

        Image image = new Image(App.class.getResourceAsStream("/paagbat/img/logoa.png"));
        stage.getIcons().add(image);

        scene = new Scene(loadFXML("/paagbat/fxml/ongietorri"));
        stage.setScene(scene);
        
        // Establecer la aplicación en modo de pantalla completa
        stage.setFullScreen(true);
        
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Set the stage size to the screen size
        stage.setWidth(screenWidth);
        stage.setHeight(screenHeight);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("/paagbat/css/modena.css").toExternalForm());

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