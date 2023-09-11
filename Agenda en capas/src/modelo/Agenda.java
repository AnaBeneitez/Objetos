
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    protected List<Persona> gente;
    
    public Agenda () {
        this.gente = new ArrayList();
    }
    
    public void agregarPersona(Persona p) throws DocumentoRepetidoException {
        comprobarExisteDocumento(p.getDocumento());
        this.gente.add(p);
    }

    private void comprobarExisteDocumento(long documento) throws DocumentoRepetidoException {
        for(Persona p: gente){
            if(p.documento == documento) {
                throw new DocumentoRepetidoException("Ya existe una persona con ese documento");
            }
        }
    }
    
    public List<Persona> getGente(){
        return this.gente;
    }
}
