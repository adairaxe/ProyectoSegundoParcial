package ec.edu.espol.modelfmxl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

///cambiogit status
public class Criterio {
    private int id;
    private String nombre;
    private String descripcion;
    private int punt_max;
    private int idConcurso;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluaciones;
    

    
    public Criterio(int id, String nombre, String descripcion, int punt_max, int idConcurso) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.punt_max = punt_max;
        this.idConcurso = idConcurso;
    }

    public Criterio(int id, String nombre, String descripcion, int punt_max) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.punt_max = punt_max;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public int getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPunt_max() {
        return this.punt_max;
    }

    public int getIdConcurso() {
        return idConcurso;
    }
    
    

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPunt_max(int punt_max) {
        this.punt_max = punt_max;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }
    
    

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Criterio other = (Criterio) obj;
        if (this.id != other.id) 
            return false;
        return true;
    }

    
    @Override
    public String toString() {
        return "Criterio{" + "id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", punt_max=" + this.punt_max + '}';
    }
    
    
    public void saveFile (String nomfile){
        /*
       try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(criteriofield),true))){
           pw.println(this.id + "|"+ this.nombre+ "|" + this.descripcion + "|"+ this.punt_max+ "|"+ this.idConcurso+ "|");
            for (Evaluacion m: this.getEvaluaciones()){
                pw.println(m.getId() + ";");
            }
       }catch(Exception e){
           //System.out.println(e.getMessage());
       }  */
        try 
           (
            FileWriter writer = new FileWriter(nomfile, true);
            BufferedWriter  bw  = new BufferedWriter (writer);   
            )    
            {
            bw.write(this.id + "|"+ this.nombre+ "|" + this.descripcion + "|"+ this.punt_max+ "|"+ this.idConcurso+ "|");
            for (Evaluacion m: this.getEvaluaciones()){
                bw.write(m.getId() + ";");
           }
             bw.newLine();
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }

    public static void saveFile(ArrayList<Criterio> listacriterios, String nomfile){
        /*
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(criteriofield),true))){
            for (Criterio crit : listacriterios){
                pw.println(crit.id + "|"+ crit.nombre+ "|" + crit.descripcion + "|"+ crit.punt_max + "|"+ crit.idConcurso);
                for (Evaluacion m: crit.getEvaluaciones()){
                    pw.println(m.getId() + ";");
                }
            }
            
        }
        catch(Exception e){
            //System.out.println(e.getMessage());
        }*/
        try(
                FileWriter writer = new FileWriter(nomfile, true);
                BufferedWriter  bw  = new BufferedWriter (writer);   
            ) 
        {
            for (Criterio crit : listacriterios)
            {
            bw.write(crit.id + "|"+ crit.nombre+ "|" + crit.descripcion + "|"+ crit.punt_max + "|"+ crit.idConcurso);
                for (Evaluacion m: crit.getEvaluaciones()){
                    bw.write(m.getId() + ";");
                    bw.newLine();
                }
            } 
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        } 
    }
    
    public static ArrayList<Evaluacion>  GenerarListEvaluacionCriterio(String nombre,int id){
        ArrayList<Evaluacion> e2 = new ArrayList<>();
        ArrayList<Evaluacion> e= Evaluacion.readFile(nombre);
        for (Evaluacion m: e){      
                if (m.getIdCriterio()==id){
                    e2.add(m);
                }
        }
        return e2;
    }
    public static void ArchivoEvaluacionCriterio(){
        ArrayList<Criterio> miembrosjurado_lista = Criterio.readFromFile("criterios.txt");
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File("criterios.txt")))){
            for (Criterio v: miembrosjurado_lista){
            //Mascota.saveFile(Duen.GenerarListMascotasDueño("mascotas.txt", d.getId()),"mascotasDueño");
                String cadena="";
                
                for (Evaluacion m: Criterio.GenerarListEvaluacionCriterio("evaluaciones.txt", v.getId())){
                    cadena = cadena.concat(m.getId() + ";");
                }
                v.setEvaluaciones(Criterio.GenerarListEvaluacionCriterio("evaluaciones.txt", v.getId()));
                pw.println(v.getId() + "|"+ v.getNombre()+ "|" + v.getDescripcion() + "|"+ v.getPunt_max()+ "|"
                    + v.getIdConcurso()+ "|" +cadena);
            } 
        }catch(Exception e){ System.out.println(e.getMessage());
            }
    }
    
    public static ArrayList<Criterio> readFromFile(String criteriofield){
        ArrayList<Criterio> criterios = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(criteriofield)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|nombre|descripcion|punt_max|idConcurso
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id, int punt_max,int, int idConcurso ,String nombre ,int descripcion
                Criterio crit = new Criterio(Integer.parseInt(tokens[0]),(tokens[1]),tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                criterios.add(crit);
            }           
        }catch(Exception e) {
            //System.out.println("Se ha creado el archivo: " + criteriofield);
        }
        return criterios;
    }
       
    public static ArrayList<Criterio> nextCriterio(Scanner sc){
        int id=0,punt_max, id_concurso, cantidad, contador = 0; ;
        String nombre, descripcion;
        
        System.out.println("Ingrese la cantidad de criterios: ");
        cantidad = sc.nextInt();
        ArrayList<Criterio> lista_criterios_1 = new ArrayList<>(); 
        ArrayList<Criterio> lista_criterios_2 = new ArrayList<>();
        
        ArrayList<Criterio> lista_cri = Criterio.readFromFile("criterios.txt");
        for (Criterio c: lista_cri){
            if (id<c.getId()){
                id=c.getId();
            }
        }
        id = id+1;
        while(contador < cantidad){                
            System.out.println("Ingrese el nombre del criterio: ");
            nombre = sc.next();
            System.out.println("Ingrese la descripción del criterio: ");
            descripcion = sc.next();
            System.out.println("Ingrese el puntaje maximo a obtener en ese criterio: ");
            punt_max = sc.nextInt(); 
            Criterio crit = new Criterio(id, nombre, descripcion, punt_max);  
            lista_criterios_1.add(crit);
            contador = contador + 1;
            id=id+1;
            }
            do{
            id_concurso = Util.next_idconcurso(sc);
            if (id_concurso != 0){
                for ( Criterio c1:  lista_criterios_1){
                    Criterio crit2 = new Criterio(c1.getId(),c1.getNombre(), c1.getDescripcion(), c1.getPunt_max(), id_concurso);  
                    crit2.saveFile("criterios.txt");
                    lista_criterios_2.add(crit2);
                }
            }
            }while(id_concurso==0);           
        return lista_criterios_1;
        }    
    }

