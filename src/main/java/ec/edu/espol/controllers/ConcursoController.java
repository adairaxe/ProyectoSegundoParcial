/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class ConcursoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txNombre;
    @FXML
    private TextField txFecha;
    @FXML
    private TextField txFechaIns;
    @FXML
    private TextField txFechaCierre;
    @FXML
    private TextField txTema;
    @FXML
    private TextField txCosto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(MouseEvent event) {
    }

    @FXML
    private void guardarInformacion(MouseEvent event) {
    }

    @FXML
    private void limpiar(MouseEvent event) {
    }
    
}
