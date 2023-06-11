package javaapplication1;

public class Persona {
    protected String nombre;
    
    public Persona(String n){
        this.nombre = n;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
