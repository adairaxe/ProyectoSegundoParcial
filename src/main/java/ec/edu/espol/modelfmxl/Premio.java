package ec.edu.espol.modelfmxl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Premio {
    private int id;
    private int lugar;
    private String descripcion;
    private int idConcurso;
    private Concurso concurso;

    
    
    public Premio(int id, int lugar, String des, int idConc){
        this.id = id;
        this.lugar= lugar;
        this.descripcion = des;
        this.idConcurso = idConc;
    }
    public Premio(int id, int lugar, String des){
        this.id = id;
        this.lugar= lugar;
        this.descripcion = des;
    }
 
    // Getters
    
    public int getId() {
        return id;
    }
    public int getLugar() {
        return lugar;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getIdConcurso() {
        return idConcurso;
    }
    public Concurso getConcurso() {
        return concurso;
    }
   
    //Setters
    
    public void setId(int id) {
        this.id = id;
    }
    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }
    

    @Override
    
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(" * ");
        sb.append(this.lugar);
        sb.append("° lugar: ");
        sb.append(this.descripcion);
        sb.append("\n");
        return sb.toString(); 

    }
    
    
    public void  saveFile(String nomfile){
        /*
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id + "|"+ this.lugar+ "|" + this.descripcion + "|"+ this.idConcurso);
        } catch(Exception e) {
            //System.out.println(e.getMessage());
            
        }*/
        try 
           (
            FileWriter writer = new FileWriter(nomfile, true);
            BufferedWriter  bw  = new BufferedWriter (writer);   
            )    
            {
            bw.write(this.id + "|"+ this.lugar+ "|" + this.descripcion + "|"+ this.idConcurso);
         
            bw.newLine();
       }catch (IOException e){
           System.out.println(e.getMessage());;
       }
    }
    
    
    public static void saveFile(ArrayList<Premio> premios, String nomfile){
        /*
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))))
        {
           for( Premio p: premios)
               pw.println(p.getId() + "|"+ p.getLugar() + "|" + p.getDescripcion() + "|"+ p.getIdConcurso()); 
        } catch(Exception e) {
            //System.out.println(e.getMessage());
        }*/
        try(
                FileWriter writer = new FileWriter(nomfile, true);
                BufferedWriter  bw  = new BufferedWriter (writer);   
            ) 
            {
            for (Premio p : premios)
            {
                bw.write(p.getId() + "|"+ p.getLugar() + "|" + p.getDescripcion() + "|"+ p.getIdConcurso());
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }  
    }
    
    
    public static ArrayList<Premio> readFromFile(String nomfile){
        /*
        ArrayList<Premio> premios = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile)))
        {
            while(sc.hasNextLine())
            {
                // linea = id|lugar|descripcion|idConcurso
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                // int id,int lugar,String descripcion,int idconcurso
                Premio p = new Premio(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2],Integer.parseInt(tokens[3]));
                premios.add(p);
            }
            
        }catch(Exception e) {
            //System.out.println("Se ha creado el archivo: "+ nomfile);
            
        }*/
        ArrayList<Premio> premios= new ArrayList<>();
        try (
            FileReader reader = new FileReader(nomfile);
            BufferedReader br = new BufferedReader(reader);
            )
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|"); 
                //String[] datos2 = datos[1].split(",");
                // linea = id|nombre|fecha|fechaInscripcion|fechaCierreInscripcion|tematica|costo
                // int id,String nombre,LocalDate fecha,LocalDate fechaInscripcion,LocalDate fechaCierreInscripcion,String tematica, double costo
                Premio p= new Premio(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2],Integer.parseInt(tokens[3]));
                premios.add(p);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return premios;
    
        
    }
    public static ArrayList<Premio> nextPremios(Scanner sc){  
        int id, id_concurso, lugar, cantidad, contador=0 ;
        String descrip;
        id=0;
        System.out.println("Ingrese la cantidad de premios: ");
        cantidad = sc.nextInt();
        ArrayList<Premio> lista_premios_inicial = new ArrayList<>();
        ArrayList<Premio> lista_premios_terminada = new ArrayList<>();       
        ArrayList<Premio> lista_premios = Premio.readFromFile("premios.txt");
        for (Premio p: lista_premios){
            if (id<p.getId()){
                id=p.getId();
            }
        }
        id = id+1;
        
        while (contador < cantidad){          
            System.out.println("Ingrese el lugar de ese premio: ");
            lugar = sc.nextInt();
            System.out.println("Ingrese la descripción del premio: ");
            descrip = sc.next();
            Premio premio = new Premio(id, lugar, descrip);
            lista_premios_inicial.add(premio);
            contador = contador + 1;
            id=id+1;
        }
        
        do{
        id_concurso = Util.next_idconcurso(sc);
        if (id_concurso != 0)
        {
            for(Premio p: lista_premios_inicial){
            Premio prem = new Premio(p.getId(),p.getLugar(),p.getDescripcion(),id_concurso);            
            //aqui registramos
            prem.saveFile("premios.txt");
            lista_premios_terminada.add(prem);
            }
        }
        }while(id_concurso==0);
        return lista_premios_terminada;                                       
    }   
}
