/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Concurso;
import ec.edu.espol.modelfmxl.Criterio;
import ec.edu.espol.modelfmxl.Util;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private HBox btnLimpiar;
    @FXML
    private TextField txNombreConcurso;
    @FXML
    private TextField txNombreCriterio;
    @FXML
    private TextField txDescripcion;
    @FXML
    private TextField txtPuntajeMaximo;
    
    @FXML
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void guardar(MouseEvent event) {
        ArrayList<Criterio> listaCriterios = Criterio.readFromFile("criterios.txt");
        System.out.println("Inicia");
        
        Alert alerta;
        
            //Criterio(int id, String nombre, String descripcion, int punt_max, int idConcurso)
            int idConcurso = Util.examinarIdConcurso(txNombreConcurso.getText());     
            System.out.println(idConcurso);
            
            int idCriterio =  listaCriterios.size()+1;
            System.out.println(idCriterio);
            
            String nombreCriterio = txNombreCriterio.getText();
            System.out.println(nombreCriterio);
            
            String descripcion = txDescripcion.getText();
            System.out.println(descripcion);
            
            int puntaje = Integer.parseInt(txtPuntajeMaximo.getText());
            System.out.println(puntaje);

            if (idConcurso != 0){
                
                Criterio criterio= new Criterio(idCriterio, nombreCriterio, descripcion, puntaje, idConcurso);
                System.out.println(criterio);
                
                criterio.saveFile("criterios.txt");
                alerta = new Alert(AlertType.INFORMATION,"El criterio "+ nombreCriterio +" ha sido creado con exito");
                alerta.show();
                
                txNombreConcurso.setText("");
                txNombreCriterio.setText("");
                txDescripcion.setText("");
                txtPuntajeMaximo.setText("");
                
                
            }else{
                alerta = new Alert(AlertType.ERROR,"Concurso no encontrado");
                alerta.show();
            }

    }

    @FXML
    private void limpiar(MouseEvent event) {
    }




    
}
