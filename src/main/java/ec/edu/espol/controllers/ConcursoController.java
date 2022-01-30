/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Concurso;
import ec.edu.espol.modelfmxl.Duen;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private void regresar(MouseEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("menu");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }

    @FXML
    private void guardarInformacion(MouseEvent event) {
        
        ArrayList<Concurso> lista_concursos = Concurso.readFromFile("concurso.txt");
        int id_concurso = lista_concursos.size()+1;
        try
        {
            String nombre= txNombre.getText();
            String fecha= txFecha.getText();
            String fechains= txFechaIns.getText();
            String fechacierre= txFechaCierre.getText();
            String tema= txTema.getText();
            String costo= txCosto.getText();
            if (nombre!="" || fecha !=""||fechains!=""||fechacierre!=""||tema!=""||costo!="")
            {
                Concurso concurso = new Concurso(id_concurso,nombre, LocalDate.parse(fecha),LocalDate.parse(fechains),LocalDate.parse(fechacierre), tema,Double.parseDouble(costo));    
                concurso.saveFile("concurso.txt");
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
        txNombre.clear();
        txFecha.clear();
        txFechaIns.clear();
        txFechaCierre.clear();
        txTema.clear();
        txCosto.clear();
    }
    
}
