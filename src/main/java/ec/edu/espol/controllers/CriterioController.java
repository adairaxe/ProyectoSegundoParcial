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
    private VBox vdatos;
    @FXML
    private TextField txtConcurso;
    @FXML
    private TextField txtCantidad;
    @FXML
    private Label txtcontador;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPuntaje;
    @FXML
    private Button btnEmpezarcontar;
    @FXML
    private VBox eliminar;
    private int  cantidad;
    private String nombreConcurso;
    @FXML
    private HBox cerrar;
    @FXML
    private VBox hvGuardarCriterio;
    private ArrayList<Criterio> criterios= new ArrayList<>();;
    @FXML
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void guardar(MouseEvent event) {
        if (nombreConcurso==""|| cantidad!=0){
            if(criterios.size()==cantidad){
//                for(Criterio c: criterios){
//                    c.saveFile("criterios.txt");
//                }
            }else{
                Alert a1= new Alert(AlertType.ERROR,"Termine de Ingresar todos los Criterios");
                a1.show();
            }
        } else {
            Alert a= new Alert(AlertType.ERROR,"Primero debe ingresar nombreConcurso y Cantidad");
            a.show();
            
        }
        
        
    }

    @FXML
    private void limpiar(MouseEvent event) {
        
    }

    @FXML
    private void guardarCriterio(ActionEvent event) {
        Criterio criterio;
        
        try{
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            int puntaje = Integer.parseInt(txtPuntaje.getText());
            //(int id, String nombre, String descripcion, int punt_max, int idConcurso)
            int idconcurso = Util.next_idconcurso(nombreConcurso);
            
            
            criterio= new Criterio (Criterio.obtenerId(),nombre,descripcion,puntaje,idconcurso);
            criterio.saveFile("criterios.txt");
            criterios.add(criterio);
        }catch (Exception ex){
            Alert a1= new Alert (AlertType.ERROR,"Ingreso de forma incorecta");
            
        }
        int posicion=Integer.parseInt(txtcontador.getText());
        posicion=posicion+1;
        if(posicion<=cantidad){
            txtcontador.setText(String.valueOf(posicion));
        }
        else{
            hvGuardarCriterio.getChildren().clear();
        }
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPuntaje.setText("");
        
    }

    @FXML
    private void Contador(ActionEvent event) {
        try{
            String nombre= txtConcurso.getText();
            int cantidad= Integer.parseInt(txtCantidad.getText());
            int i=0;
            if (i<=cantidad){
                i=i+1;
                txtcontador.setText(String.valueOf(i));
                eliminar.getChildren().clear();
                this.cantidad=cantidad;
                this.nombreConcurso=nombre;
                
            }
        }catch (Exception ex){
            Alert a1= new Alert (AlertType.ERROR,"Ingreso de IDConcurso o Cantidad de Criterios de forma incorecta");
            
        }
        
    }
    
}
