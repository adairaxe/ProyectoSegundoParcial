/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Evaluacion;
import ec.edu.espol.modelfmxl.Inscripcion;
import ec.edu.espol.modelfmxl.Mascota;
import ec.edu.espol.modelfmxl.Util;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class EvaluacionController implements Initializable{

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
    private ComboBox<String> cbmascotas;
    @FXML
    private VBox mostrarImagen;
    @FXML
    private ImageView imvMascota;
    
    public void initialize(URL url, ResourceBundle rb) {
        //LEER LOS DATOS DE LAS CATEGORIAS Y CARGARLOS AL COMOBOBOX
        try{
            ArrayList<Mascota> mascotas = Mascota.readFile("mascotas.txt");
            ArrayList<String> nombres= new ArrayList();
            for(Mascota m:mascotas){
                nombres.add(m.getNombre());
            }
            cbmascotas.getItems().addAll(nombres);
//            cbmascotas.setOn
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }

    @FXML
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void limpiar(MouseEvent event) {
        txidInscripcion.clear();
        txCorreo.clear();
        txidCriterio.clear();
        txNota.clear();
        imvMascota.setImage(null);
        cbmascotas.setValue("");
    }

    @FXML
    private void guardarEvaluacion(MouseEvent event) {
        
        ArrayList<Evaluacion> lista_evaluaciones = Evaluacion.readFile("evaluaciones.txt");
        System.out.println(lista_evaluaciones.size());
       
        //Evaluacion(int id, int idMiembroJurado, int idInscripcion, int idCriterio, int nota)
        int idEvaluacion = lista_evaluaciones.size()+1;
        
        
        int idMiembroJurado = Util.examinarIdMiembroJurado(txCorreo.getText());

        int idInscripcion = Util.examinarIdInscripcion(Integer.parseInt(txidInscripcion.getText()));
  
        int idCriterio = Util.examinarCriterio(Integer.parseInt(txidCriterio.getText())).getId();

        
        int nota = Integer.parseInt(txNota.getText());

        
        int notaMaxima = Util.examinarCriterio(Integer.parseInt(txidCriterio.getText())).getPunt_max();
        
        String mascotaNombre = cbmascotas.getValue();
        ArrayList<Mascota> mascotas = Mascota.readFile("mascotas.txt");
        int idMascota=0;
        for(Mascota m:mascotas){
            if (m.getNombre().equals(mascotaNombre)){
                idMascota= idMascota+m.getId();
            }
        }
        
        Alert alerta;
        if (idMiembroJurado != 0){
            
            if (idInscripcion != 0){
                
                if(idCriterio != 0){
                    
                    if(nota <= notaMaxima){
                        Evaluacion evaluacion = new Evaluacion(idEvaluacion, idMascota,idMiembroJurado, idInscripcion, idCriterio, nota);
                        evaluacion.saveFile("evaluaciones.txt");
                        limpiar(event);
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

    @FXML
    private void mostrarImagenMascota(ActionEvent event) {
        //imvMascota.setImage(new Image(""));
        String seleccionado= cbmascotas.getValue();
        ArrayList<Mascota> mascotas = Mascota.readFile("mascotas.txt");
        Image imv;
        String ruta;
        
        for(Mascota m:mascotas){
            if (m.getNombre().equals(seleccionado)){
                ruta= m.getRuta();
                imv= new Image(ruta);
                imvMascota.setImage(imv);
            }
        }
    }
    
}
