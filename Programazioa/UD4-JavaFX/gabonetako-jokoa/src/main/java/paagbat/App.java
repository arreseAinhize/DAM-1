    package paagbat;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.image.Image;
    import javafx.stage.Stage;

    import java.io.IOException;

    /**
     * JavaFX App
     */
    public class App extends Application {

        private static Scene scene;

        @Override
        public void start(Stage stage) throws IOException {
            stage.setTitle("Arcane memory game");

            Image image = new Image(App.class.getResourceAsStream("/img/League-of-Legends-Embleme.png")); // carga imagen desde los recursos
            stage.getIcons().add(image);

            scene = new Scene(loadFXML("game"), 640, 480);
            scene.getStylesheets().add(getClass().getResource("modena.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }

        static void setRoot(String fxml) throws IOException {
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