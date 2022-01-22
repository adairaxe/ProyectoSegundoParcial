/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Util;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InscripcionController implements Initializable {

    @FXML
    private TextField txtNombreMascota;
    @FXML
    private TextField txtNombreConcurso;
    @FXML
    private TextField txtFechaInscripcion;
    @FXML
    private TextField txtTotalPagar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardarInscripcion(MouseEvent event) {
        
        int id_mascota = Util.examinarIdMascota(txtNombreMascota.getText());
        int id_concurso = Util.examinarIdConcurso(txtNombreConcurso.getText());
        LocalDate fecha_actual = LocalDate.now();
        double precio_concurso = Double.parseDouble(txtTotalPagar.getText());
        
        Alert alertfecha;
        Alert alertacosto;
        
        
        if (fecha_actual.isBefore(Util.fecha_inicio_concurso(id_concurso))){    
            alertfecha = new Alert(AlertType.ERROR,"LA FECHA DE INSCRIPCION AUN NO COMIENZA");          
        }       
        else{           
            alertfecha = new Alert(AlertType.ERROR,"LA FECHA DE INSCRIPCION HA TERMINADO");
        }
        
        
        if (precio_concurso > Util.exminarCostoConcurso(id_concurso)){
            alertacosto = new Alert(AlertType.ERROR,"Usted está pagando de más"); 
        }
        else if(precio_concurso < Util.exminarCostoConcurso(id_concurso)){
            alertacosto = new Alert(AlertType.ERROR,"El costo a pagar es de\n"+Util.exminarCostoConcurso(id_concurso));           
        }
        
        
        
        
        
        
    }

    
}
