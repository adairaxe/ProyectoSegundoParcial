package ec.edu.espol.modelfmxl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Evaluacion {
    private int id;
    private int nota;
    private int idInscripcion;
    private Inscripcion inscripcion;
    private int idMiembroJurado;
    private int idCriterio;
    private Criterio criterio;
    

    public Evaluacion(int id, int idMiembroJurado, int idInscripcion, int idCriterio, int nota) {
        this.id = id;
        this.nota = nota;
        this.idInscripcion = idInscripcion;
        this.idMiembroJurado = idMiembroJurado;
        this.idCriterio = idCriterio;
    }

    public int getId() {
        return this.id;
    }

    public double getNota() {
        return this.nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public int getIdCriterio() {
        return idCriterio;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }
   
    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", nota=" + nota + ", idInscripcion=" + idInscripcion + ", idMiembroJurado=" + idMiembroJurado + ", idCriterio=" + idCriterio + '}';
    }

   
    public void saveFile (String evaluacionefield){
       try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(evaluacionefield),true))){
           pw.println(this.id + "|"+ this.nota+ "|" + this.idInscripcion + "|"+ this.idMiembroJurado + "|"+ this.idCriterio);
       }catch(Exception e){
           //System.out.println(e.getMessage());
       }  
    }
    
    
    public static void saveFile(ArrayList<Evaluacion> listaevaluaciones, String evaluacionefield){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(evaluacionefield),true))){
            for (Evaluacion eva : listaevaluaciones)
                pw.println(eva.getId() + "|"+ eva.getNota()+ "|" + eva.getIdInscripcion() + "|"+
                        eva.getIdMiembroJurado() + "|"+ eva.getIdCriterio());
        }
        catch(Exception e){
            //System.out.println(e.getMessage());
        }       
    }
    
    
    /*****************************************/
    
    
    
    public static ArrayList<Evaluacion> readFile(String nomfile){
    ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
    try (
        FileReader reader = new FileReader(nomfile);
        BufferedReader br = new BufferedReader(reader);
        )
    {
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split("\\|"); 
            //Evaluacion(int id, int idMiembroJurado, int idInscripcion, int idCriterio, int nota)
            Evaluacion evaluacion = new Evaluacion(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]));                
            evaluaciones.add(evaluacion);
        }
        reader.close();
    }catch (Exception e){
        System.out.println("EL ARCHIVO NO EXISTE");;
    }
    return evaluaciones;
    
    }
        
        /********************************/
    
    
    public static Evaluacion nextEvaluacion(Scanner sc){     
        int id, idInscripcion, idCriterio=0;
        int nota; 
        int ptmax=0;
        int idMiembroJurado= 0;
        String emailMiembroJurado;
        id= Util.nextID("evaluaciones.txt");
        
        do{
            System.out.println("Ingrese el email del miembro del jurado: ");
            emailMiembroJurado = sc.next();
            ArrayList<MiembroJurado>  miembros =  MiembroJurado.readFile("miembroJurados.txt");
            for (MiembroJurado m: miembros){
                if(emailMiembroJurado.equals(m.getEmail()))
                {
                    idMiembroJurado= m.getId();
                }
            }
        }while(idMiembroJurado==0);
        
        Inscripcion ins;
        do{
            ins = Util.next_InsInscripcion(sc);
        }while(ins==null);       
        idInscripcion = ins.getId();
        
        Criterio crit;
        do{
            crit = Util.id_criterio(sc);
        }while(crit == null);
        idCriterio=crit.getId();
        ptmax=crit.getPunt_max();

        do{
            System.out.println("Ingrese la nota: ");
            nota = sc.nextInt(); 
        }while(nota>ptmax);
        
        Evaluacion nueva_evaluacion = new Evaluacion(id, idMiembroJurado, idInscripcion,
                idCriterio, nota);
        nueva_evaluacion.saveFile("evaluaciones.txt");
        
        return nueva_evaluacion;
    }
}






