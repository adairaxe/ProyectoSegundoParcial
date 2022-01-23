package ec.edu.espol.modelfmxl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Mascota {
    private String nombre,raza,tipo,emailDueño;
    private int id,idDueño;
    private LocalDate fechaNacimiento;
    private Duen dueño;
    private ArrayList<Inscripcion> inscripciones;

    public Mascota( int id,String nombre, String raza, String tipo, LocalDate fechaNacimiento, int idDueño) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.idDueño = idDueño;
    }
    
    //Gets and Sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Duen getDueño() {
        return dueño;
    }

    public void setDueño(Duen dueño) {
        this.dueño = dueño;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Mascota[ id= ");
        sb.append(this.id);
        sb.append(", nombre= ");
        sb.append(this.nombre);
        sb.append(", raza= ");
        sb.append(this.raza);
        sb.append(", tipo= ");
        sb.append(this.tipo);
        sb.append(", idDueño= ");
        sb.append(this.idDueño);
        sb.append(", fechaNacimiento= ");
        sb.append(this.fechaNacimiento);
        sb.append(", Inscripciones= ");
        for (Inscripcion i: inscripciones){
            sb.append(i.toString());
            if(this.inscripciones.size()!=this.inscripciones.size()-1)
                sb.append(";");    
            }
        sb.append("]");
        return sb.toString();
    }
   
    
    public void saveFile(String ruta){
//        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(file),true)))
//        {
//            pw.println(this.getId() + "|"+ this.getNombre()+ "|" + this.getRaza() + "|"+ this.getTipo()+ "|"+ this.getFechaNacimiento()+ "|"+ this.getIdDueño());
//            for (Inscripcion i: this.getInscripciones()){
//                pw.println(i.getId() + ";");
//            }
//        }catch(Exception e) {
//            //System.out.println(e.getMessage());
//        }
        try{
            FileWriter writer= new FileWriter(ruta, true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(String.valueOf(this.getId()));
            bufferedWriter.write("|");
            bufferedWriter.write(String.valueOf(this.getNombre()));
            bufferedWriter.write("|");
            bufferedWriter.write(String.valueOf(this.getRaza()));
            bufferedWriter.write("|");
            bufferedWriter.write(String.valueOf(this.getTipo()));
            bufferedWriter.write("|");
            bufferedWriter.write(String.valueOf(this.getFechaNacimiento()));
            bufferedWriter.write("|");
            bufferedWriter.write(String.valueOf(this.getIdDueño()));
            bufferedWriter.write("|");
            for (Inscripcion i: this.getInscripciones()){
                bufferedWriter.write(String.valueOf(i.getId()));
                bufferedWriter.write("|");
            }
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch(Exception e) {
            e.printStackTrace();
//            //System.out.println(e.getMessage());
        }
    }
    public static void  saveFile( ArrayList<Mascota> mascotas , String nombre){
//        //en modo append
//        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombre),true))){
//            for (   Mascota v:  mascotas ){
//                // ejemplo= 1|Tobias|mestiza|perro|2015-01-10|1|2;4;
//                pw.println(v.getId() + "|"+ v.getNombre()+ "|" + v.getRaza() + "|"+ v.getTipo()+ "|"+ v.getFechaNacimiento()+ "|"+ v.getIdDueño());
//                for (Inscripcion m: v.getInscripciones()){
//                    pw.println(m.getId() + ";");
//                }
//            }    
//        }catch(Exception e){
//            //System.out.println(e.getMessage());
//        }

        try{
            FileWriter writer= new FileWriter(nombre);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            for( Mascota v:  mascotas){
                bufferedWriter.write(String.valueOf(v.getId()));
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(v.getNombre()));
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(v.getRaza()));
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(v.getTipo()));
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(v.getFechaNacimiento()));
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(v.getIdDueño()));
                bufferedWriter.write("|");
                for (Inscripcion i: v.getInscripciones()){
                    bufferedWriter.write(String.valueOf(i.getId()));
                    bufferedWriter.write("|");
                }
                bufferedWriter.newLine();
            
            } 
            bufferedWriter.close();

        }catch(Exception e) {
            e.printStackTrace();
//            //System.out.println(e.getMessage());
        }
    }
    Scanner sc= new Scanner(System.in);

    
    public static ArrayList<Mascota> readFile(String nombre){
//        ArrayList<Mascota> mascotas= new ArrayList<>();
//        try (Scanner sc =new Scanner(new File (nombre))){
//            while(sc.hasNextLine()){
//                String linea= sc.nextLine();
//                String[] datos = linea.split("\\|"); 
//                Mascota v= new Mascota(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],LocalDate.parse(datos[4]),Integer.parseInt(datos[5]));
//                mascotas.add(v);                    
//            } 
//        }catch (Exception e){
//            //System.out.println("Se ha creado el archivo: "+ nombre);
//        }
//        
//        return mascotas;
        ArrayList<Mascota> mascotas= new ArrayList<>();
        try (Scanner sc =new Scanner(new File (nombre))){
            FileReader reader = new FileReader(nombre);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split("\\|"); 
                String[] datos2 = datos[1].split(";");
                Mascota v= new Mascota(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],LocalDate.parse(datos[4]),Integer.parseInt(datos[5]));
                mascotas.add(v); 
            }
            reader.close();
        }catch (Exception e){
            //System.out.println("Se ha creado el archivo: "+ nombre);
            e.printStackTrace();
        }
        
        return mascotas;
    }
    
    
    public static Mascota nextMascota(Scanner sc){
        String nombre,raza,tipo;
        int id;
        LocalDate fecha;
        ArrayList <Mascota> lista_mascotas = Mascota.readFile("mascotas.txt");
        id = lista_mascotas.size()+1;
        System.out.println("Ingrese el nombre de la mascota: ");
        nombre = sc.next();        
        System.out.println("Ingrese la raza de la mascota: ");
        raza = sc.next();
        System.out.println("Ingrese la fecha de nacimiento: ");
        fecha = LocalDate.parse(sc.next());
        System.out.println("Ingrese el tipo de mascota: ");
        tipo = sc.next();
        Duen dueño;
        
        do{
            dueño = Util.next_Duendueño(sc);
        }while(dueño == null);             
        Mascota m = new Mascota( id,nombre,raza, tipo, fecha,dueño.getId());
        m.saveFile("mascotas.txt");
        
        return m;    
    }
    public static ArrayList<Inscripcion>  GenerarListInscripMascota(String nombre,int id){
        ArrayList<Inscripcion> ins2=new ArrayList<>();
        ArrayList<Inscripcion> ins= Inscripcion.readFile(nombre);
        
        for (Inscripcion m: ins){
            
                if (m.getIdMascota()==id){
                    ins2.add(m);
                }
        }
        return ins2;
    }
    public static void ArchivoInscripcionMascota(){
        ArrayList<Mascota> mascota= Mascota.readFile("mascotas.txt");
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File("mascotas.txt")))){
            for (Mascota v: mascota){
                String cadena="";
                
                for (Inscripcion m: Mascota.GenerarListInscripMascota("inscripciones.txt", v.getId())){
                    cadena = cadena.concat(m.getId() + ";");
                }
                v.setInscripciones(Mascota.GenerarListInscripMascota("inscripciones.txt", v.getId()));
                pw.println(v.getId()+ "|"+ v.getNombre()+ "|" + v.getRaza() + "|"+ v.getTipo()+ "|"+ v.getFechaNacimiento()+ "|"+ v.getIdDueño()+"|" +cadena);
            } 
        }catch(Exception e){ System.out.println(e.getMessage());
            }
    }

    
    
}
