package tpobjetos;

import java.time.LocalDate;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int documento;
    protected LocalDate fechaNacimiento;
    
    public Persona(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }
    
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public Persona() {
        this.nombre = "";
        this.apellido = "";
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getDocumento() {
        return this.documento;
    }
        
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
