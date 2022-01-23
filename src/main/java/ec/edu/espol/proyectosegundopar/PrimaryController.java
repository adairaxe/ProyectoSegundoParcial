/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectosegundopar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class PrimaryController implements Initializable {


   
    @FXML
    private Button btusuario;
    
    @FXML
    private Button btmascota;
   
    @FXML
    private Button btinscripcion;
    @FXML
    private VBox vbopciones;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void registrarUsuario(MouseEvent event) {
        Stage stg = (Stage)vbopciones.getScene().getWindow();
        stg.close();
            
        try {
            
            FXMLLoader loader = App.loadFXML("duen"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
       

    @FXML
    private void registrarMascota(MouseEvent event) {
        Stage stg = (Stage)vbopciones.getScene().getWindow();
        stg.close();
            
        try {
            
            FXMLLoader loader = App.loadFXML("mascota"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }

    @FXML
    private void registrarInscripcion(MouseEvent event) {
        // VENTANA PRUEBA
        Stage stg = (Stage)vbopciones.getScene().getWindow();
        stg.close();
            
        try {
            
            FXMLLoader loader = App.loadFXML("inscripcion"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }
    
    

    
    
}
