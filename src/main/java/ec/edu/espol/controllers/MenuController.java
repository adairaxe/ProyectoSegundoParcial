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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnSalir;
    @FXML
    private Button btnConcurso;
    @FXML
    private Button btnMascota;
    @FXML
    private Button btnDueno;
    @FXML
    private Button btnPremio;
    @FXML
    private Button btnCriterio;
    @FXML
    private Button btnInscripcion;
    @FXML
    private Button btnMiembroJurado;
    @FXML
    private Button btnEvaluacion;
    @FXML
    private VBox vopcion1;
    @FXML
    private VBox vopcion2;
    @FXML
    private HBox hbopciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void concurso(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("concurso"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
        
        
    }

    @FXML
    private void mascota(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
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
    private void dueno(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
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
    private void premio(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("premio"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void salir(MouseEvent event) {         
        Stage stg = (Stage)btnSalir.getScene().getWindow();
        stg.close();
    }

    @FXML
    private void criterio(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("criterio"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void inscripcion(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
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

    @FXML
    private void MiembroJurado(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("miembroJurad"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void evaluacion(MouseEvent event) throws IOException {
        Stage stg = (Stage)hbopciones.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("evaluacion"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
