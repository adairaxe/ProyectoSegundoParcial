/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
//<<<<<<< HEAD:src/main/java/ec/edu/espol/controllers/PruebaController.java
//public class PruebaController implements Initializable {
//=======
public class MiembroJuradController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textApellido;
    @FXML
    private TextField textTelefono;
    @FXML
    private TextField TextEmail;
    @FXML
    private TextField textDescripcion;
//>>>>>>> d3b146ba984b19116aee9502f75314c585912069:src/main/java/ec/edu/espol/controllers/MiembroJuradController.java
    @FXML
    private Button btnguardar;

    /**
     * Initializes the controller class.
     */
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(MouseEvent event) {
        Stage stg = (Stage)btnRegresar.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("menu"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void guardando(MouseEvent event) {
    }
    
}
