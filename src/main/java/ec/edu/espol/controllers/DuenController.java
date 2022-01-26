/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Duen;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 59399
 */
public class DuenController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textApellido;
    @FXML
    private TextField textTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField textDireccion;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;

    /**
     * Initializes the controller class.
     */
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
    private void guardando(MouseEvent event) {
        ArrayList<Duen> lista_duenos = Duen.readFile("duenos.txt");
        int id_dueno = lista_duenos.size()+1;
        try{
            String nombre= textNombre.getText();
            String apellido= textApellido.getText();
            String telefono= textTelefono.getText();
            String email= txtEmail.getText();
            String direccion= textDireccion.getText();
            
//            
//            
//            
//            REVISAR XQ NO SALE LA ALERTA CUANDO LOS CAMPOS ESTAN VACIOS
//            
//            
//            
            
            
            if (nombre!=null ||apellido!=null||telefono!=null||email!=null||direccion!=null
                   ){
//                if (nombre!="" ||apellido!=""||telefono!=""||email!=""||direccion!=""){|| nombre!="" ||apellido!=""||telefono!=""||email!=""||direccion!=""
                if (nombre!="" ||apellido!=""||telefono!=""||email!=""||direccion!=""){
                    Duen persona_duen = new Duen(id_dueno, nombre, apellido, telefono, email, direccion);    
                    persona_duen.saveFile("duenos.txt");
                }
//                else{
//                    Alert a3= new Alert(AlertType.ERROR, "Ingreso de campos vacios" );
//                    a3.show();
//                } 
                        
                        
//                }
                
            }else{
                Alert a3= new Alert(AlertType.ERROR, "Ingreso de campos vacios" );
                a3.show();
            } 
            
        }catch(Exception e){
            Alert a2= new Alert(AlertType.ERROR, "Ingreso los datos de manera incorrecta" );
            a2.show();
        }
        
        
    }

    @FXML
    private void limpiar(MouseEvent event) {
        textNombre.clear();
        textApellido.clear();
        textTelefono.clear();
        txtEmail.clear();
        textDireccion.clear();
    }
    
}
