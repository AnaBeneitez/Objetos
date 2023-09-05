
package modelo;
import java.util.Objects;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected long documento;
    
    public Persona(String nombre, String apellido, long doc) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = doc;
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
    public long getDocumento() {
        return this.documento;
    }
    public void setDocumento(long doc) {
        this.documento = doc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.apellido);
        hash = 47 * hash + (int) (this.documento ^ (this.documento >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals (Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if(this.documento != other.documento) {
            return false;
        }
        if(!Objects.equals(this.nombre,other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }
    
    @Override
    public String toString() {
        return "Persona: {nombre: " + this.nombre + ",apellido: " + this.apellido + ", documento: " + this.documento + "}"; 
    }
}
