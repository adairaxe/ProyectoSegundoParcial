/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Concurso;
import ec.edu.espol.modelfmxl.Duen;
import ec.edu.espol.modelfmxl.Mascota;
import ec.edu.espol.modelfmxl.Premio;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class PremioController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txLugar;
    @FXML
    private TextField txDescripcion;
    @FXML
    private TextField txtIdConcurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void guardarInformacion(MouseEvent event) {
        ArrayList<Premio> lista_concursos = Premio.readFromFile("premio.txt");
        int id_premio = lista_concursos.size()+1;
        try
        {
            String nombreConcurso= txtIdConcurso.getText();
            String lugar= txLugar.getText();
            String descripcion= txDescripcion.getText();
            int idConcurso=0;
            ArrayList<Concurso> concursos = Concurso.readFromFile("concurso.txt");
            for(    Concurso m:concursos){
                if (m.getNombre().equals(nombreConcurso)){
                    idConcurso= idConcurso+m.getId();
                }
            }
            
            if (lugar!="" || descripcion !=""|| nombreConcurso !="")
            {
                Premio premio = new Premio(id_premio,Integer.parseInt(lugar),descripcion,idConcurso);    
                premio.saveFile("premio.txt");
                limpiar(event);
                Alert a5= new Alert(Alert.AlertType.INFORMATION, "Mascota registrada con exito" );
                a5.show();
            }
        }catch(Exception e){
            Alert a2= new Alert(Alert.AlertType.ERROR, "Ingreso los datos de manera incorrecta" );
            a2.show();
        }
        
    }

    @FXML
    private void limpiar(MouseEvent event) {
        txLugar.clear();
        txDescripcion.clear();
        txtIdConcurso.clear();
    }
    
}
