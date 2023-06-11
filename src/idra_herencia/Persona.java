package datos;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int documento;
    
    public Persona() {
        this.nombre = "";
        this.apellido = "";
    }
    
    public Persona(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
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
    
    @Override
    public String toString() {
        String salida = "Persona {";
        salida += "apellido: \"";
        salida += this.apellido+"\", ";
        salida += "nombre: \"";
        salida += this.nombre+"\", ";
        salida += "documento: ";
        salida += this.documento+" }";
        return salida;
    }
    
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        
        if ( o == null ) {
            return false;
        }
        
        if ( this.getClass() != o.getClass()) {
            return false;
        }
        
        Persona p = (Persona) o;
        if ( this.documento != p.documento ) {
            return false;
        }
        if ( !this.nombre.equals(p.nombre)) {
        //if ( this.nombre.equals(p.nombre) != true) {
            return false;
        }
        /*if ( !this.apellido.equals(p.apellido)){
            return false;
        }
        return true;*/
        return this.apellido.equals(p.apellido);
        
    }
}
