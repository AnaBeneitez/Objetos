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
    public void save(Object d) {
        gente.add((Persona)d);
    }

    @Override
    public Object find(long documento) throws DocumentoNoEncontrado {
        boolean encontrado = false;
        Persona buscado;
         
        for(Persona p: this.gente){
            if(p.getDocumento() == documento){
                encontrado = true;
                buscado = new Persona(p.getNombre(), p.getApellido(), p.getDocumento());
            }
        }
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(long documento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
