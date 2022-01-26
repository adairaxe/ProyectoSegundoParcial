package ec.edu.espol.proyectosegundopar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu").load(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Alert a = new Alert(Alert.AlertType.INFORMATION,"Si es la primera vez que ingresa al sistema,\ndebe primero registrar su usuario");
        a.setTitle("Confirmación");
        a.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        
        launch();
    }

}