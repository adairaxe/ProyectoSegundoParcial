/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Evaluacion;
import ec.edu.espol.modelfmxl.Inscripcion;
import ec.edu.espol.modelfmxl.Util;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class EvaluacionController {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txCorreo;
    @FXML
    private TextField txidInscripcion;
    @FXML
    private TextField txidCriterio;
    @FXML
    private TextField txNota;

    @FXML
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void limpiar(MouseEvent event) {
    }

    @FXML
    private void guardarEvaluacion(MouseEvent event) {
        System.out.println("INICIA");
        ArrayList<Evaluacion> lista_evaluaciones = Evaluacion.readFile("evaluaciones.txt");
        System.out.println("PASO READFILE");
       
        //Evaluacion(int id, int idMiembroJurado, int idInscripcion, int idCriterio, int nota)
        int idEvaluacion = lista_evaluaciones.size()+1;
        System.out.println(idEvaluacion);
        
        int idMiembroJurado = Util.examinarIdMiembroJurado(txCorreo.getText());
<<<<<<< HEAD
        System.out.println(idMiembroJurado);
        
=======
        System.out.println("idMiembroJurado"+idMiembroJurado);
>>>>>>> 86c5dacc8d0eb0d0f8dcf7f477962c9215bd4dbc
        int idInscripcion = Util.examinarIdInscripcion(Integer.parseInt(txidInscripcion.getText()));
        System.out.println(idInscripcion);
  
        int idCriterio = Util.examinarCriterio(Integer.parseInt(txidCriterio.getText())).getId();
        System.out.println(idCriterio);
        
        int nota = Integer.parseInt(txNota.getText());
        System.out.println(nota);
        
        int notaMaxima = Util.examinarCriterio(Integer.parseInt(txidCriterio.getText())).getPunt_max();
        
        Alert alerta;
        if (idMiembroJurado != 0){
            
            if (idInscripcion != 0){
                
                if(idCriterio != 0){
                    
                    if(nota <= notaMaxima){
                        Evaluacion evaluacion = new Evaluacion(idEvaluacion, idMiembroJurado, idInscripcion, idCriterio, nota);
                        evaluacion.saveFile("evaluaciones.txt");
                    }else{
                        alerta = new Alert(AlertType.ERROR, "La nota ingresada supera la nota maxima");
                        alerta.show();
                    }
                    
                }else{
                    alerta = new Alert(AlertType.ERROR, "El id del Criterio no es correcto");
                    alerta.show();               
                }
  
            }else{
                alerta = new Alert(AlertType.ERROR, "El id de la Inscripcion no es correcto");
                alerta.show();   
            }
            
        }else{
            alerta = new Alert(AlertType.ERROR, "El correo del Miembro del jurado no es correcto");
            alerta.show();   
        }
        
    }
    
}
