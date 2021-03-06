package ec.edu.espol.modelfmxl;

import ec.edu.espol.modelfmxl.Persona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Duen extends Persona{
    private String direccion;
    private ArrayList<Mascota> mascotas;
    
    public Duen(int id, String nombre, String apellidos, String telefono, String email, String direccion){
//        this.id = id;
        super(id,nombre,apellidos,telefono,email);
        this.direccion=direccion;
//        this.mascotas=new ArrayList<>();
    }
//    
//    public Duen(int id, String nombre, String apellidos, String telefono, String email, String direccion, ArrayList<Mascota> mascotas){
//        super(nombre,apellidos,telefono,email);
//        this.id = id;
//        this.direccion=direccion;
//        this.mascotas=mascotas;
//    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    
    
            @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Dueño{ id= ");
        sb.append(this.getId());
        sb.append(", nombre= ");
        sb.append(this.getNombres());
        sb.append(", apellidos=");
        sb.append(this.getApellidos());
        sb.append(", telefono= ");
        sb.append(this.getTelefono());
        sb.append(", email= ");
        sb.append(this.getEmail());
        sb.append(", direccion= ");
        sb.append(this.getDireccion());
        sb.append(",    Mascotas= ");
//        for (Mascota i: this.mascotas){
//            sb.append(i.toString());
//            if(this.mascotas.size()!=this.mascotas.size()-1)
//                sb.append(";");               
//            }
        sb.append("]");
        return sb.toString();
    }
    
    public static Duen nextDueño(Scanner sc){   
        ArrayList<Duen> lista_duenos = Duen.readFile("duenos.txt");
        int id_dueno = lista_duenos.size()+1;
        Persona persona = Persona.nextPersona(sc);
        System.out.println("Ingrese la direccion del Dueño: ");
        String direccion = sc.next();
        Duen persona_duen = new Duen(id_dueno, persona.nombres, persona.apellidos, persona.telefono, persona.email, direccion);    
        persona_duen.saveFile("duenos.txt");
        return persona_duen;
        
        
    }
    
    
    
    /////
    ////     Edite SaveFile,Read. si no corre revisar :c
    /////
    public void saveFile(String ruta){
        try{
            FileWriter writer= new FileWriter(ruta, true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write((String.valueOf(this.getId())));
            bufferedWriter.write("|");
            bufferedWriter.write((String.valueOf(this.getNombres())));
            bufferedWriter.write("|");
            bufferedWriter.write((String.valueOf(this.getApellidos())));
            bufferedWriter.write("|");
            bufferedWriter.write((String.valueOf(this.getTelefono())));
            bufferedWriter.write("|");
            bufferedWriter.write((String.valueOf( this.getEmail())));
            bufferedWriter.write("|");
            bufferedWriter.write((String.valueOf(this.getDireccion())));
            //bufferedWriter.write("|");
//            for (Mascota m: this.getMascotas()){
//                bufferedWriter.write((String.valueOf( this.getId())));
//                bufferedWriter.write(";");
//            }
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void  saveFile( ArrayList<Duen> dueño , String nombre){
        //en modo append
        try{
            FileWriter writer= new FileWriter(nombre);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            for (Duen v:dueño){
                bufferedWriter.write((String.valueOf(v.getId())));
                bufferedWriter.write("|");
                bufferedWriter.write((String.valueOf(v.getNombres())));
                bufferedWriter.write("|");
                bufferedWriter.write((String.valueOf(v.getApellidos())));
                bufferedWriter.write("|");
                bufferedWriter.write((String.valueOf(v.getTelefono())));
                bufferedWriter.write("|");
                bufferedWriter.write((String.valueOf( v.getEmail())));
                bufferedWriter.write("|");
                bufferedWriter.write( (String.valueOf(v.getDireccion())));
                //bufferedWriter.write("|");
//                for (Mascota m: v.getMascotas()){
//                    bufferedWriter.write((String.valueOf( m.getId())));
//                    bufferedWriter.write(";");
//                }
                
                bufferedWriter.newLine();
            }
//            for (Duen v:  dueño ){
//                pw.println(v.getId() + "|"+ v.getNombres()+ "|" + v.getApellidos() + "|"+ v.getTelefono()+ "|"
//                    + v.getEmail()+ "|"+ v.getDireccion()+ "|");
//                for (Mascota m: v.getMascotas()){
//                    pw.println(m.getId() + ";");
//                }
//            }
            bufferedWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    public static ArrayList<Duen> readFile(String nombre){
        ArrayList<Duen> dueño= new ArrayList<>();
        try (
                FileReader reader = new FileReader(nombre);
                BufferedReader bufferedReader = new BufferedReader(reader);
                )
        
        {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split("\\|"); 
                //String[] datos2 = datos[1].split(";");
                int idDueño=Integer.parseInt(datos[0])+0;
                Duen duen= new Duen(idDueño,datos[1],datos[2],datos[3],datos[4],datos[5]);
//                System.out.println(duen.toString());
                dueño.add(duen);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
            //System.out.println("Se ha creado el archivo: " + nombre);
        }
        return dueño;
    }
    public static ArrayList<Mascota>  GenerarListMascotasDueño(String nombre,int id){
        ArrayList<Mascota> mascota2=new ArrayList<>();
        ArrayList<Mascota> mascotas= Mascota.readFile(nombre);
        
        for (Mascota m: mascotas){
            
                if (m.getIdDueño()==id){
                    mascota2.add(m);
                }
        }
        return mascota2;
    }
    
    public static void ArchivoMascotasDueño(){
        ArrayList<Duen> dueño= Duen.readFile("duenos.txt");
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File("duenos.txt")))){
            for (Duen v: dueño){
            //Mascota.saveFile(Duen.GenerarListMascotasDueño("mascotas.txt", d.getId()),"mascotasDueño");
                String cadena="";
                
                for (Mascota m: Duen.GenerarListMascotasDueño("mascotas.txt", v.getId())){
                    cadena = cadena.concat(m.getId() + ";");
                }
                v.setMascotas(Duen.GenerarListMascotasDueño("mascotas.txt", v.getId()));
                pw.println(v.getId() + "|"+ v.getNombres()+ "|" + v.getApellidos() + "|"+ v.getTelefono()+ "|"
                    + v.getEmail()+ "|"+ v.getDireccion()+ "|" +cadena);
            } 
        }catch(Exception e){ System.out.println(e.getMessage());
            }
    }
    
}
