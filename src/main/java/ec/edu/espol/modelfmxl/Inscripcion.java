package ec.edu.espol.modelfmxl;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inscripcion implements Serializable {
    private int id;
    private LocalDate fecha_inscripcion;
    private double valor;
    private int idMascota;
    private int idConcurso;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluacion;

    
    // Los Id deben ser automaticos 
    public Inscripcion(int id, LocalDate fecha_inscripcion, double valor, int idMascota,int idConcurso ) {
        this.id = id;
        this.fecha_inscripcion = fecha_inscripcion;
        this.valor = valor;
        this.idMascota = idMascota;
        this.idConcurso = idConcurso;
    }

    public Inscripcion(int id, LocalDate fecha_inscripcion, double valor) {
        this.id = id;
        this.fecha_inscripcion = fecha_inscripcion;
        this.valor = valor;
    }

    
    public int getId() {
        return this.id;
    }

    public LocalDate getFecha_inscripcion() {
        return this.fecha_inscripcion;
    }

    public double getValor() {
        return this.valor;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public ArrayList<Evaluacion> getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(ArrayList<Evaluacion> evaluacion) {
        this.evaluacion = evaluacion;
    }
    
    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

   
    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", fecha_inscripcion=" + fecha_inscripcion + ", valor=" + valor + ", idMascota=" + idMascota + ", idConcurso=" + idConcurso + '}';
    }
    
    
    public void saveFile (String inscripcionesfield){
        /*try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(inscripcionesfield),true))){
           pw.println(this.id + "|"+ this.fecha_inscripcion+ "|" + this.valor + "|"+ this.idMascota + "|"+ this.idConcurso + "|");
           for (Evaluacion m: this.getEvaluacion()){
                pw.println(m.getId() + ";");
           }
        }catch(Exception e){
           //System.out.println(e.getMessage());
       }*/
        
        
        try(BufferedWriter  bw  = new BufferedWriter (new FileWriter(inscripcionesfield, true)))
        {
            //Inscripcion(int id, LocalDate fecha_inscripcion, double valor, int idMascota,int idConcurso )
            bw.write(this.id + "|"+ this.fecha_inscripcion+ "|" + this.valor + "|"+ this.idMascota+ "|"+ this.idConcurso);
            bw.newLine();
            
        } catch (IOException ex) {
            System.out.println("FALLO saveFile");
        }
       
       
    }
    
    
    public static void saveFile(ArrayList<Inscripcion> listainscripciones, String inscripcionesfield){
        /*try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(inscripcionesfield),true))){
            for (Inscripcion ins : listainscripciones){
                String cadena="";
                for (Evaluacion m: ins.getEvaluacion()){
                    cadena = cadena.concat(m.getId() + ";");
                }
                pw.println(ins.getId() + "|"+ ins.getFecha_inscripcion()+ "|" + ins.getValor() + "|"+ ins.getIdMascota() + "|"+ ins.getIdConcurso()+ "|"+ cadena);
                
            }
        }
        catch(Exception e){
            //System.out.println(e.getMessage());
        } */      
        
        
        try( BufferedWriter  bw  = new BufferedWriter (new FileWriter(inscripcionesfield, true))) 
            {
            for (Inscripcion c : listainscripciones)
            {
                bw.write(c.id + "|"+ c.fecha_inscripcion+ "|" + c.valor + "|"+ c.idMascota+ "|"+ c.idConcurso);
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println("FALLO void saveFile");
        }
    }
    
    
    
    public static ArrayList<Evaluacion>  GenerarListEvaluacionInscripcion(String nombre,int id){
        ArrayList<Evaluacion> e2 = new ArrayList<>();
        ArrayList<Evaluacion> e= Evaluacion.readFile(nombre);
        for (Evaluacion m: e){      
                if (m.getIdInscripcion()==id){
                    e2.add(m);
                }
        }
        return e2;
    }
    
    
    
    public static void ArchivoEvaluacionInscripcion(){
        ArrayList<Inscripcion> inscripciones_lista = Inscripcion.readFile("inscripciones.txt");
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File("inscripciones.txt")))){
            for (Inscripcion v: inscripciones_lista){
            //Mascota.saveFile(Duen.GenerarListMascotasDueño("mascotas.txt", d.getId()),"mascotasDueño");
                String cadena="";
                
                for (Evaluacion m: Inscripcion.GenerarListEvaluacionInscripcion("evaluaciones.txt", v.getId())){
                    cadena = cadena.concat(m.getId() + ";");
                }
                v.setEvaluacion(Inscripcion.GenerarListEvaluacionInscripcion("evaluaciones.txt", v.getId()));
                pw.println(v.getId() + "|"+ v.getFecha_inscripcion()+ "|" + v.getValor() + "|"+ v.getIdMascota()+ "|"
                    + v.getIdConcurso()+ "|" +cadena);
            } 
        }catch(Exception e){ //System.out.println(e.getMessage());
            }
    }
    
    
    /*****************************************************/
    
    
    public static ArrayList<Inscripcion> readFile(String nomfile){
        ArrayList<Inscripcion> inscripciones= new ArrayList<>();
        try (
            FileReader reader = new FileReader(nomfile);
            BufferedReader br = new BufferedReader(reader);
            )
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split("\\|"); 
                
                //Inscripcion(int id, LocalDate fecha_inscripcion, double valor, int idMascota,int idConcurso )
                Inscripcion ins = new Inscripcion(Integer.parseInt(datos[0]),LocalDate.parse(datos[1]), Double.parseDouble(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]));                
                inscripciones.add(ins);
            }
            reader.close();
        }catch (Exception e){
            System.out.println("EL ARCHIVO NO EXISTE");;
        }
        return inscripciones;
    
    }
    
    /*************************************************/
    
    
    public static Inscripcion nextInscripcion(Scanner sc){
        int id,id_mascota, id_concurso;
        double valor;
        LocalDate fecha_inscripcion;  
        ArrayList<Inscripcion> lista_inscripciones = Inscripcion.readFile("inscripciones.txt");     
        id = lista_inscripciones.size()+1; 
        
        do{
            id_mascota = Util.next_idmascota(sc);
        }while(id_mascota==0);
        
        do{
            id_concurso = Util.next_idconcurso(sc);       
        }while(id_concurso==0);
        
        do{
            System.out.println("Ingrese la fecha de inscripcion: ");
            fecha_inscripcion = LocalDate.parse(sc.next());
            }while((fecha_inscripcion.isBefore(Util.fecha_inicio_concurso(id_concurso))) || (fecha_inscripcion.isAfter(Util.fecha_cierre_concurso(id_concurso))));
       
        if (id_concurso!= 0 && id_mascota != 0)         
        {    
            valor =0;
            do{
                System.out.println("Ingrese el valor total de la inscripcion: ");
                valor = sc.nextDouble();
                
                //cambio nombre de función idConcurso
            }while(valor!=Util.exminarCostoConcurso(id_concurso));
            
            Inscripcion inscripcion_completa = new Inscripcion(id, fecha_inscripcion, valor,id_mascota, id_concurso);
            inscripcion_completa.saveFile("inscripciones.txt");
            System.out.println("La incripcion: "+ inscripcion_completa +" ha sido guardada");
            
            return inscripcion_completa;      
        }
        System.out.println("Inscripcion inválida porque el concurso o mascota no existe");
        return null;
    }
}
