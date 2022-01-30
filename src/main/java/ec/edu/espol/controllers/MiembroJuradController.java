/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Duen;
import ec.edu.espol.modelfmxl.MiembroJurado;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.net.URL;
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
 * @author USER
 */
//<<<<<<< HEAD:src/main/java/ec/edu/espol/controllers/PruebaController.java
//public class PruebaController implements Initializable {
//=======
public class MiembroJuradController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textApellido;
    @FXML
    private TextField textTelefono;
    @FXML
    private TextField textDescripcion;
//>>>>>>> d3b146ba984b19116aee9502f75314c585912069:src/main/java/ec/edu/espol/controllers/MiembroJuradController.java
    @FXML
    private Button btnguardar;
    @FXML
    private TextField textEmail;

    /**
     * Initializes the controller class.
     */
//    @Override
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
    private void guardando(MouseEvent event) {
        ArrayList< MiembroJurado> lista_JURADOS = MiembroJurado.readFile("miembroJurado.txt");
        int id_dueno = lista_JURADOS.size()+1;
        System.out.println(id_dueno);
        try{
            String nombre= textNombre.getText();
            String apellido= textApellido.getText();
            String telefono= textTelefono.getText();
            String email= textEmail.getText();
            String descripcion= textDescripcion.getText();
            
            if (nombre!=null ||apellido!=null||telefono!=null||email!=null||descripcion!=null
                   ){
//                if (nombre!="" ||apellido!=""||telefono!=""||email!=""||direccion!=""){|| nombre!="" ||apellido!=""||telefono!=""||email!=""||direccion!=""
                if (nombre!="" ||apellido!=""||telefono!=""||email!=""||descripcion!=""){                
//MiembroJurado( int id,String perfil, String nombres, 
            //String apellidos, String telefono, String email) 
                    
                    MiembroJurado persona_Jurado = new MiembroJurado(id_dueno, descripcion,nombre, apellido, telefono, email);    
                    persona_Jurado.saveFile("miembroJurado.txt");
                    limpiar(event);
                    Alert a5= new Alert(Alert.AlertType.INFORMATION, "Mascota registrada con exito" );
                    a5.show();
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
        textNombre.clear();
        textApellido.clear();
        textTelefono.clear();
        textEmail.clear();
        textDescripcion.clear();
    }
    
}
