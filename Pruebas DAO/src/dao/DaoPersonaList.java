package dao;

import java.util.ArrayList;
import java.util.List;
import model.Persona;

public class DaoPersonaList implements dao {
    
    private List<Persona> gente;
    private static DaoPersonaList instance;

    private DaoPersonaList() {
        gente = new ArrayList();
    }
    
    public DaoPersonaList getInstance() {
        if(instance == null) {
            instance = new DaoPersonaList();
        }
        return instance;
    }
    
    @Override
    public void save(Object d) throws DocumentoRepetidoException {
        Persona nueva = (Persona) d;
        comprobarExisteDocumento(nueva.getDocumento());
        gente.add(nueva);
    }

    @Override
    public Object find(long documento){
         
        for(Persona p: this.gente){
            if(p.getDocumento() == documento){
                Persona encontrado = new Persona(p.getNombre(),
                                            p.getApellido(),
                                            p.getDocumento()
                                                );
                return encontrado;
            }
        }
        return null;
    }

    @Override
    public List<Persona> getAll() {
        return this.gente;
    }

    @Override
    public void update(Object d) {
        Persona aActualizar = (Persona) d;
        for(Persona p: gente) {
            if(p.getDocumento() == aActualizar.getDocumento()) {
                p.setNombre(aActualizar.getNombre());
                p.setApellido(aActualizar.getApellido());
                p.setDocumento(aActualizar.getDocumento());
            }
        }
    }

    @Override
    public void delete(long documento) {
        for(Persona p: gente){
            if(p.getDocumento() == documento){
                gente.remove(p);
            }
        }
    }
    
    public void comprobarExisteDocumento(long documento) throws DocumentoRepetidoException {
        for(Persona p: gente){
            if(p.getDocumento() == documento){
                throw new DocumentoRepetidoException("El documento ya existe en la base de datos");
            }
        }
    }
}
