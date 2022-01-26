/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class CriterioController {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txNombre;
    @FXML
    private TextField txDescripcion;
    @FXML
    private TextField txPuntajeMax;

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
    private void guardar(MouseEvent event) {
    }
    
}
