package model;

import java.util.Objects;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected long documento;
    
    public Persona(String nombre, String apellido, long documento) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.documento = documento;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public long getDocumento(){
        return this.documento;
    }
    
    public void setDocumento(long documento){
        this.documento = documento;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        final Persona other = (Persona) obj;
        if(this.documento != other.documento) return false;
        if(!Objects.equals(this.nombre, other.nombre)) return false;
        return Objects.equals(this.apellido, other.apellido);        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.apellido);
        hash = 43 * hash + (int) (this.documento ^ (this.documento >>> 32));
        return hash;
    }
    
    @Override
    public String toString(){
        return "Persona: {nombre: " + this.nombre + ",apellido: " + this.apellido + ", documento: " + this.documento + "}";
    }
}
