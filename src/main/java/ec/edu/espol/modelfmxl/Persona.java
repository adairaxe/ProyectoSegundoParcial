package ec.edu.espol.modelfmxl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Persona {
    protected int id;
    protected String nombres,apellidos,telefono,email;

    public Persona(int id, String nombres, String apellidos, String telefono, String email) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    //Constructor para poder sacar los datos de una Persona GENERAL
    public Persona(String nombres, String apellidos, String telefono, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email + '}';
    }

    
        public static  Persona nextPersona(Scanner sc){        
        String nombre,apellidos,telefono,email;
        sc.useDelimiter("\n");       
        System.out.println("Ingrese el nombre : ");
        nombre = sc.next();
        System.out.println("Ingrese el apellido : ");
        apellidos = sc.next();
        System.out.println("Ingrese el telefono: ");
        telefono = sc.next();
        System.out.println("Ingrese el email: ");
        email = sc.next();
        Persona persona_nueva = new Persona(nombre,apellidos,telefono,email);
        return persona_nueva;     
    }
    
}
