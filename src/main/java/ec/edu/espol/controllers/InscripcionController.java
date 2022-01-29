/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.modelfmxl.Concurso;
import ec.edu.espol.modelfmxl.Util;
import ec.edu.espol.proyectosegundopar.App;
import java.io.IOException;
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
public class InscripcionController implements Initializable {

    @FXML
    private TextField txtNombreMascota;
    @FXML
    private TextField txtNombreConcurso;
    @FXML
    private TextField txtFechaInscripcion;
    private TextField txtTotalPagar;
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

        if (id_mascota == 0){
            Alert alertaMascota = new Alert(AlertType.ERROR, "Revise si el nombre de su mascota es correcto");
            alertaMascota.show();
        }
                
        
        int id_concurso = Util.examinarIdConcurso(txtNombreConcurso.getText());
        if (id_mascota == 0){
            Alert alertaConcurso = new Alert(AlertType.ERROR, "Revise si el nombre del concurso es correcto");
            alertaConcurso.show();
        }
        
        Alert alertfecha;         
        LocalDate fecha_actual = LocalDate.parse(txtFechaInscripcion.getText());        
        if (fecha_actual.isBefore(Util.fecha_inicio_concurso(id_concurso))){    
            alertfecha = new Alert(AlertType.ERROR,"LA FECHA DE INSCRIPCION AUN NO COMIENZA");          
        }       
        else if(fecha_actual.isAfter(Util.fecha_cierre_concurso(id_mascota))){           
            alertfecha = new Alert(AlertType.ERROR,"LA FECHA DE INSCRIPCION HA TERMINADO");
        }
        
        Alert alertacosto;
        double precio_concurso = Double.parseDouble(txtTotalPagar.getText());
        if (precio_concurso > Util.exminarCostoConcurso(id_concurso)){
            alertacosto = new Alert(AlertType.ERROR,"Usted está pagando de más"); 
        }
        else if(precio_concurso < Util.exminarCostoConcurso(id_concurso)){
            alertacosto = new Alert(AlertType.ERROR,"El costo a pagar es de\n");           
        }
        
        //Inscripcion(int id, LocalDate fecha_inscripcion, double valor, int idMascota,int idConcurso )
        Inscripcion inscripcion = new Inscripcion(id_inscripcion, fecha_actual, precio_concurso, id_mascota, id_concurso);
        inscripcion.saveFile("inscripcion.txt");

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
