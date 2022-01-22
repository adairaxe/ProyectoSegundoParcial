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

/**
 * FXML Controller class
 *
 * @author 59399
 */
public class MascotaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textRaza;
    @FXML
    private TextField textFecha;
    @FXML
    private TextField textTipo;
    @FXML
    private Button subirFoto;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
