
package ec.edu.espol.modelfmxl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Concurso {
    private int id;
    private String nombre;
    private LocalDate fecha;
    private LocalDate fechaInscripcion;
    private LocalDate fechaCierreInscripcion;
    private String tematica;
    private double costo;
    private ArrayList<Inscripcion> inscripciones;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterio;
    
    
    public Concurso(int id, String nombre, LocalDate fecha, LocalDate fechaInscripcion, LocalDate fechaCierreInscripcion, String tematica, double costo){
        this.id = id;
        this.nombre = nombre; 
        this.fecha = fecha;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.tematica = tematica;
        this.costo = costo;
        
    
    }
    // GETTERS
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public LocalDate getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }
     public String getTematica() {
        return tematica;
    }
      public double getCosto() {
        return costo;
    }
      public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }
      public ArrayList<Premio> getPremios() {
        return premios;
    }
      public ArrayList<Criterio> getCriterio() {
        return criterio;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    public void setFechaCierreInscripcion(LocalDate fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }
    public void setCriterio(ArrayList<Criterio> criterio) {
        this.criterio = criterio;
    }
    
    @Override
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Concurso[ id= ");
        sb.append(this.id);
        sb.append(", nombre= ");
        sb.append(this.nombre);
        sb.append(", fecha= ");
        sb.append(this.fecha);
        sb.append(", fecha de inscripcion= ");
        sb.append(this.fechaInscripcion);
        sb.append(", fecha de cierre de inscripcion= ");
        sb.append(this.fechaCierreInscripcion);
        sb.append(", temática= ");
        sb.append(this.tematica);
        sb.append(", costo de inscripción= ");
        sb.append(this.costo);
        sb.append(", Premios= ");
        for(Premio p: this.premios){
            sb.append(p.toString());
            if(this.premios.size() != this.premios.size()-1)
                sb.append(";");
        }
        sb.append("]");
        return sb.toString();
        
    }
      
     public void  saveFile(String nomfile){
        /*
         try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id + "|"+ this.nombre+ "|" + this.fecha + "|"+ this.fechaInscripcion+ "|"+ this.fechaCierreInscripcion+ "|"+ this.tematica+ "|"+ this.costo);
        } catch(Exception e) {
            //System.out.println(e.getMessage());
            
        }
        */
         try 
           (
            FileWriter writer = new FileWriter(nomfile, true);
            BufferedWriter  bw  = new BufferedWriter (writer);   
            )    
            {
            bw.write(this.id + "|"+ this.nombre+ "|" + this.fecha + "|"+ this.fechaInscripcion+ "|"+ this.fechaCierreInscripcion+ "|"+ this.tematica+ "|"+ this.costo);
         
            bw.newLine();
       }catch (IOException e){
           System.out.println(e.getMessage());;
       }
        
    }
    public static void saveFile(ArrayList<Concurso> concursos, String nomfile){
        /*
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))))
        {
           for( Concurso c: concursos)
               pw.println(c.id + "|"+ c.nombre+ "|" + c.fecha + "|"+ c.fechaInscripcion + "|"+ c.fechaCierreInscripcion+ "|"+ c.tematica+ "|"+ c.costo); 
        } catch(Exception e) {
            //System.out.println(e.getMessage());
            
        }*/
        try(
                FileWriter writer = new FileWriter(nomfile, true);
                BufferedWriter  bw  = new BufferedWriter (writer);   
            ) 
            {
            for (Concurso c : concursos)
            {
                bw.write(c.id + "|"+ c.nombre+ "|" + c.fecha + "|"+ c.fechaInscripcion + "|"+ c.fechaCierreInscripcion+ "|"+ c.tematica+ "|"+ c.costo);
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }  
    }
    
    public static ArrayList<Concurso> readFromFile(String nomfile){
        ArrayList<Concurso> concursos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|nombre|fecha|fechaInscripcion|fechaCierreInscripcion|tematica|costo
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id,String nombre,LocalDate fecha,LocalDate fechaInscripcion,LocalDate fechaCierreInscripcion,String tematica, double costo
                Concurso c = new Concurso(Integer.parseInt(tokens[0]),tokens[1],LocalDate.parse(tokens[2]),LocalDate.parse(tokens[3]),LocalDate.parse(tokens[4]), tokens[5], Double.parseDouble(tokens[6])  ) ;
                concursos.add(c);
            }
            
        }catch(Exception e) {
            //System.out.println("Se ha creado el archivo: " + nomfile);
            
        }
        return concursos;
    
    }
    public static Concurso nextConcurso(Scanner sc){       
        int id;
        String tematica, nombre;
        double costo;
        LocalDate fecha, fechaIns, fechaCierreIns;
        ArrayList<Concurso> c = Concurso.readFromFile("concursos.txt");
        id = c.size()+1;
        System.out.println("Ingrese el nombre de ese concurso: ");
        nombre = sc.next();
        System.out.println("Ingrese la fecha del concurso: ");
        fecha = LocalDate.parse(sc.next());
        // Valida que las fechas tengan sentido
        do{
        System.out.println("Ingrese la fecha de inscripcion: ");
        fechaIns = LocalDate.parse(sc.next());
        }while(fechaIns.isAfter(fecha));
        
        // Valida que las fechas tengan sentido
        do{
        System.out.println("Ingrese la fecha de cierre de inscripciones: ");
        fechaCierreIns = LocalDate.parse(sc.next());
        }while(fechaCierreIns.isBefore(fechaIns)||fechaCierreIns.isAfter(fecha));
        System.out.println("Ingrese la temática del concurso: ");
        tematica = sc.next();
        System.out.println("Ingrese el costo de la inscripcion: ");
        costo = sc.nextDouble();
        Concurso concurso = new Concurso(id,nombre,fecha,fechaIns,fechaCierreIns,tematica,costo);
        
        return concurso;
        
    }
    

    public static ArrayList<Premio>  GenerarListPremiosConcurso(String nombre,int id){
    ArrayList<Premio> premios2=new ArrayList<>();
    ArrayList<Premio> premios= Premio.readFromFile(nombre);

    for (Premio m: premios){

            if (m.getIdConcurso()==id){
                premios2.add(m);
            }
    }
    return premios2;
    }
    public static ArrayList<Criterio>  GenerarListCriterioConcurso(String nombre,int id){
        ArrayList<Criterio> criterios2=new ArrayList<>();
        ArrayList<Criterio> criterios= Criterio.readFromFile(nombre);
        
        for (Criterio m: criterios){
            
                if (m.getIdConcurso()==id){
                    criterios2.add(m);
                }
        }
        return criterios2;
    }
    
    public static ArrayList<Inscripcion>  GenerarListInscripcionesConcurso(String nombre,int id){
    ArrayList<Inscripcion> inscripciones2=new ArrayList<>();
    ArrayList<Inscripcion> inscripciones= Inscripcion.readFile(nombre);

    for (Inscripcion m: inscripciones){

            if (m.getIdConcurso()==id){
                inscripciones2.add(m);
            }
    }
    return inscripciones2;
    }
    public static void ArchivoListasDueño(){
    //ArrayList<Inscripcion> inscripciones1= Inscripcion.readFile("inscripciones.txt");
    ArrayList<Concurso> concurso= Concurso.readFromFile("concursos.txt");
    // ArrayList<Criterio> criterio1= Criterio.readFromFile("criterios.txt");
    //ArrayList<Premio> premios= Premio.readFromFile("premios.txt");
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File("concursos.txt"))))
        {
            for (Concurso v: concurso){
            //Mascota.saveFile(Duen.GenerarListMascotasDueño("mascotas.txt", d.getId()),"mascotasDueño");
                String cadena1="";
                String cadena2="";
                String cadena3="";
                for (Premio m: Concurso.GenerarListPremiosConcurso("premios.txt", v.getId())){
                    cadena1 = cadena1.concat(m.getId() + ";");
                }
                for (Criterio m: Concurso.GenerarListCriterioConcurso("criterios.txt", v.getId())){
                    cadena2 = cadena2.concat(m.getId() + ";");
                }
                for (Inscripcion m: Concurso.GenerarListInscripcionesConcurso("inscripciones.txt", v.getId())){
                    cadena3 = cadena3.concat(m.getId() + ";");
                }

                pw.println(v.getId() + "|"+ v.getNombre()+ "|" + v.getFecha() + "|"+ v.getFechaInscripcion() +
                        "|"+ v.getFechaCierreInscripcion()+ "|"+ v.getTematica()+ "|"+ v.getCosto()+"|"+cadena1+"|"+cadena2+"|"+cadena3);
            } 
        }catch(Exception e){ System.out.println(e.getMessage());
        }
    }       
}
