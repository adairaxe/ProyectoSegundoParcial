package ec.edu.espol.proyectosegundopar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {       
        scene = new Scene(loadFXML("menu").load(), 640, 480);
        stage.getIcons().add(new Image("img/iconoProyecto2.jpg"));
        stage.setScene(scene);
        stage.show();
        
        Alert a = new Alert(Alert.AlertType.INFORMATION,"Si es la primera vez que ingresa al sistema,\nprimero debe registrarse como dueño");
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