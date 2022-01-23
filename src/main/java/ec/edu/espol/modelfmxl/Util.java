package ec.edu.espol.modelfmxl;

import static ec.edu.espol.modelfmxl.Concurso.readFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Util {
    
    // el constructor se lo ha declarado privado
    // ya que esta clase solo va a contener comportamientos estáticos
    // por lo tanto, no se van a permitir crear instancia de la clase Util    
    private Util(){}
    
    public static int nextID(String nomfile)
    {
        int id = 0;
        try(Scanner sc = new Scanner(new File(nomfile)))
        {
           while(sc.hasNextLine())
           {
               String linea = sc.nextLine();
               String[] tokens = linea.split("\\|");
               id = Integer.parseInt(tokens[0]);
           }
        }
        catch(Exception e)
        {
        }
        return id+1;
    }
    
    
    
    
    
    
    /////////////////////////     FUNCIONES DE MASCOTA   /////////////////////
    
    public static int next_idmascota(Scanner sc){
    System.out.println("Ingrese el nombre de su mascota: ");
    String nombre_mascota = sc.next();
    ArrayList</*ec.edu.espol.model.*/Mascota> mascotas = /*ec.edu.espol.model.*/Mascota.readFile("mascotas.txt");
    for (/*ec.edu.espol.model.*/Mascota m: mascotas){
        if (nombre_mascota.equals(m.getNombre())){
            return m.getId();
            }  
        }
    return 0;
    }
    
   
    public static int examinarIdMascota(String nombre_mascota){
    ArrayList</*ec.edu.espol.model.*/Mascota> mascotas = /*ec.edu.espol.model.*/Mascota.readFile("mascotas.txt");
    for (/*ec.edu.espol.model.*/Mascota m: mascotas){
        if (nombre_mascota.equals(m.getNombre())){
            return m.getId();
            }  
        }
    return 0;
    }
    
    
    ////////////////////////////////////////////////////////
    
    
    public static Duen next_Duendueño(Scanner sc){
        
        System.out.println("Ingrese un email de dueño existente: ");
        String email = sc.next();
        ArrayList<Duen> dueños = Duen.readFile("dueños.txt");
        for (Duen d: dueños){
            if (email.equals(d.getEmail())){
               
                return d;
            }  
        }
        return null; 
    }
    
    
    public static Inscripcion next_InsInscripcion(Scanner sc){
        System.out.println("Ingrese el id de la inscripcion: ");
        int id= sc.nextInt();
        ArrayList<Inscripcion> inscripciones = Inscripcion.readFile("inscripciones.txt");
        for (Inscripcion d: inscripciones){
            if (id==d.getId()){
                return d;
            }  
        }
    return null;
    }
    
    
    public static Criterio id_criterio(Scanner sc){
        System.out.println("Ingrese el id del criterio: ");
        int id= sc.nextInt();
        ArrayList<Criterio> lista_criterios = Criterio.readFromFile("criterios.txt");
        for (Criterio criterio: lista_criterios){
            if (id==criterio.getId()){
                return criterio;
            }  
        }
    return null;
    }
    
    
    
     /////////// FUNCIONES DE CONCURSO//////////////////
    
    public static int next_idconcurso(Scanner sc){
    System.out.println("Ingrese el nombre del concurso: ");
    String concurso = sc.next();
    ArrayList</*ec.edu.espol.model.*/Concurso> concursos = /*ec.edu.espol.model./*/Concurso.readFromFile("concursos.txt");
    for (/*ec.edu.espol.model.*/Concurso i: concursos){
        if (concurso.equals(i.getNombre())){
            return i.getId();
            }  
        }
    return 0;
    }
    
   
        
    public static int examinarIdConcurso(String nombre_concurso){
    ArrayList</*ec.edu.espol.model.*/Concurso> concursos = Concurso.readFromFile("concursos.txt");
    for (/*ec.edu.espol.model.*/Concurso i: concursos){
        if (nombre_concurso.equals(i.getNombre())){
            return i.getId();
            }  
        }
    return 0;
    }
    
    
    
    public static double exminarCostoConcurso(int id){
        ArrayList</*ec.edu.espol.model.*/Concurso> concurso = /*ec.edu.espol.model.*/Concurso.readFromFile("concursos.txt");
        for (/*ec.edu.espol.model.*/Concurso c: concurso){
            if (id==c.getId()){
                return c.getCosto();
            }  
        }
        return 0;
    }
    
    
    
    
    public static LocalDate fecha_inicio_concurso(int id){
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");
        for (Concurso i: concursos){
            if(id==i.getId()){
                return i.getFechaInscripcion();
            }
        }
        return null;       
    }
    
    public static LocalDate fecha_cierre_concurso(int id){
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");
        for (Concurso i: concursos){
            if(id==i.getId()){
                return i.getFechaCierreInscripcion();
            }
        }
        return null;       
    }
    ////////////////////////////////////////////////
}

