/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Duen;
import ec.edu.espol.modelfmxl.Mascota;
import ec.edu.espol.modelfmxl.MiembroJurado;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 59399
 */
public class MascotaController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txNombre;
    @FXML
    private TextField txRaza;
    @FXML
    private TextField txTipo;
    @FXML
    private TextField txFechaNacimeinto;
    @FXML
    private TextField txtIDDueño;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(MouseEvent event) {
        Stage stg = (Stage)btnRegresar.getScene().getWindow();
        stg.close();
        try {
            
            FXMLLoader loader = App.loadFXML("menu"); 
            Scene scdueno = new Scene(loader.load(),600,400);
            Stage stgdueno = new Stage();
            stgdueno.setScene(scdueno);
            stgdueno.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void guardarInformacion(MouseEvent event) {
        ArrayList< Mascota> lista_Mascotas = Mascota.readFile("mascotas.txt");
        int id_mascota = lista_Mascotas.size()+1;
        try{
            String nombre= txNombre.getText();
            String raza= txRaza.getText();
            String tipo= txTipo.getText();
            String fechaNacimeinto= txFechaNacimeinto.getText();
            
            if (nombre!=null ||raza!=null||tipo!=null||fechaNacimeinto!=null){
               if (nombre!="" ||raza!=""||tipo!=""||fechaNacimeinto!=""){
                    Duen persona_duen = new Duen(id_mascota, nombre, raza, tipo, fechaNacimeinto, descripcion);    
                    persona_duen.saveFile("miembroJurado.txt");
                }

            }else{
                Alert a3= new Alert(Alert.AlertType.ERROR, "Ingreso de campos vacios" );
                a3.show();
            } 
            
        }catch(Exception e){
            Alert a2= new Alert(Alert.AlertType.ERROR, "Ingreso los datos de manera incorrecta" );
            a2.show();
        }
        
       
    }

    @FXML
    private void limpiar(MouseEvent event) {
    }
    
}
