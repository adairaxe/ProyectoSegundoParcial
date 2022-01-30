/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.modelfmxl.Concurso;
import ec.edu.espol.modelfmxl.Inscripcion;
import ec.edu.espol.modelfmxl.Util;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
 * @author USER
 */
public class InscripcionController implements Initializable, Serializable {

    @FXML
    private TextField txtNombreMascota;
    @FXML
    private TextField txtNombreConcurso;
    @FXML
    private TextField txtFechaInscripcion;
    
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txTotalPagar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }



    
    @FXML
    private void guardarInscripcion(MouseEvent event) {
        ArrayList<Inscripcion> lista_inscripciones = Inscripcion.readFile("inscripcion.txt");
        
        int id_inscripcion = lista_inscripciones.size()+1;      
        int id_mascota = Util.examinarIdMascota(txtNombreMascota.getText());   
        int id_concurso = Util.examinarIdConcurso(txtNombreConcurso.getText());

        System.out.println(id_concurso);
        
        LocalDate fecha_actual = LocalDate.parse(txtFechaInscripcion.getText());
        System.out.println(fecha_actual);
        
        LocalDate fecha_inicio = Util.fecha_inicio_concurso(id_concurso);
        System.out.println(fecha_inicio);
        
        LocalDate fecha_cierre = Util.fecha_cierre_concurso(id_concurso);
        System.out.println(fecha_cierre);
        
        
        double precioPagado = Double.parseDouble(txTotalPagar.getText());
        System.out.println(precioPagado);
        
        double precio_concurso = Util.exminarCostoConcurso(id_concurso);
        System.out.println(precio_concurso);
        
        System.out.println(fecha_actual.isAfter(fecha_inicio));
        
        if (id_mascota != 0 && id_concurso != 0){
            
            if(precioPagado == precio_concurso && fecha_actual.isAfter(fecha_inicio) && fecha_actual.isBefore(fecha_cierre)){
                Inscripcion inscripcion = new Inscripcion(id_inscripcion, fecha_actual, precio_concurso, id_mascota, id_concurso);
                System.out.println("SE HA CREADO LA INSCRIPCION");
                inscripcion.saveFile("inscripcion.txt");
                limpiar(event);
                Alert a5= new Alert(Alert.AlertType.INFORMATION, "Mascota registrada con exito" );
                a5.show();
            }else{
                Alert alertCostoFecha = new Alert(AlertType.ERROR, "Revise el periodo de inscripcion y el costo del concurso");
                alertCostoFecha.show();
            }
            
        }
        else{
            Alert alertMascotaConcurso = new Alert(AlertType.ERROR, "¿Ya registro a su mascota?\n Tambien puede verificar si el"
                    + "nombre del concurso ingresado es el correcto");
            alertMascotaConcurso.show();
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
    }

    
}
