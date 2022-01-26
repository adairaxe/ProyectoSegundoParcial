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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    private HBox btnLimpiar;

    @FXML
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void guardar(MouseEvent event) {
    }

    @FXML
    private void limpiar(MouseEvent event) {
    }
    
}
