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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
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
    @FXML
    private Button Subir;
    @FXML
    private VBox hbmascota;
    @FXML
    private ImageView mascota;
    private FileChooser fc= new FileChooser();
    private String ruta;

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
        ArrayList< Mascota> lista_Mascotas = Mascota.readFile("mascotas.txt");
        int id_mascota = lista_Mascotas.size()+1;
        try{
            String nombre= txNombre.getText();
            String raza= txRaza.getText();
            String tipo= txTipo.getText();
            String fechaNacimeinto= txFechaNacimeinto.getText();
            int idDueño = Integer.parseInt(txtIDDueño.getText());
            if (nombre!=null ||raza!=null||tipo!=null||fechaNacimeinto!=null){
               if (nombre!="" ||raza!=""||tipo!=""||fechaNacimeinto!=""){
//                   ///cambiosssss
                    Mascota mascota1 = new Mascota(id_mascota, nombre, raza, tipo, LocalDate.parse(fechaNacimeinto), idDueño);    
                    
//                    fc.setInitialDirectory(new File(System.getProperty("user.home")));
//                    fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "."));
//                    File seledFile= fc.showOpenDialog(null);
                    Image img= new Image (ruta);
                    
                    mascota1.setImgm(img);
                    
                        mascota1.saveFile("mascotas.txt");
                    
                    
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
        txNombre.clear();
        txRaza.clear();
        txTipo.clear();
        txFechaNacimeinto.clear();
        txtIDDueño.clear();
        mascota.setImage(null);
    }

    @FXML
    private void subir(MouseEvent event) {
        
//        fc.setInitialDirectory(new File("C:\\Users\\59399\\Downloads"));
//        fc.getExtensionFilters().addAll(
//                new ExtensionFilter("imagenes")
//        );
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        //fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "."));


        File seledFile= fc.showOpenDialog(null);
        if (seledFile!= null){
//            listview.ç
//            Image image = new Image(seledFile.getAbsolutePath());
//            ImageView iv = new ImageView(image);
            Image img= new Image (seledFile.toURI().toString());
            ruta=seledFile.toURI().toString();
//            mascota.getChildren().add(iv);
            mascota.setImage(img);
        }
    }
    
}
