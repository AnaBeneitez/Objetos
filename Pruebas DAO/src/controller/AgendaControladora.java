package controller;

import dao.DaoPersonaList;
import java.util.List;
import model.Persona;
import view.AgendaVista;
import dao.DocumentoRepetidoException;
import java.util.ArrayList;

public class AgendaControladora {
    protected AgendaVista vista;
    protected DaoPersonaList modelo;
    
    public AgendaControladora() {
        this.vista = new AgendaVista();
        this.modelo = new DaoPersonaList();
    }
    
    public void mostrarAgenda() {
        int op = 0;
        do{
        vista.mostrarMenu();
        op = vista.leerOpcion();
        ejecutarOpcion(op);
        }while(op != 6);
    }

    private void ejecutarOpcion(int op) {
        switch (op){
            case 1 -> agregarPersona();
            case 2 -> buscarPorDocumento();
            case 3 -> listarPersonas();
            case 4 -> modificarPersona();
            case 5 -> eliminarPersona();
            case 6 -> vista.mostrarMensaje("La agenda se cerrará.");
            default -> vista.mostrarMensaje("Opción incorrecta");
        }
    }

    private void agregarPersona() {
        List datos = vista.pedirDatosPersona();
        Persona nueva = new Persona((String) datos.get(0), 
                                    (String) datos.get(1), 
                                    (long) datos.get(2)
                                    );
        try {
            this.modelo.save(nueva);
            vista.mostrarMensaje("La persona se ha agregado correctamente");
            vista.mostrarPersona(datos);
        } catch (DocumentoRepetidoException ex){
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    private void buscarPorDocumento() {
        long documento = vista.leerEntero("Ingrese el documento buscado");
        Persona encontrado = (Persona) modelo.find(documento);
        
        if(encontrado == null) {
            vista.mostrarMensaje("El documento ingresado no existe en la base de datos");
        }else {
            vista.mostrarMensaje("El documento ingresado corresponde a: ");
            List datos = new ArrayList();
            datos.add(encontrado.getNombre());
            datos.add(encontrado.getApellido());
            datos.add(encontrado.getDocumento());
            vista.mostrarPersona(datos);
        }
    }

    private void listarPersonas() {
        for(Persona p: modelo.getAll()){
            List datos = new ArrayList();
            datos.add(p.getNombre());
            datos.add(p.getApellido());
            datos.add(p.getDocumento());
            vista.mostrarPersona(datos);
        }
    }

    private void modificarPersona() {
        List datos = vista.pedirDatosPersona();
        Persona nueva = new Persona((String) datos.get(0), 
                                    (String) datos.get(1), 
                                     (long) datos.get(2)
                                    );
        boolean actualizado = modelo.update(nueva);
        if(actualizado){
            vista.mostrarMensaje("La persona ha sido actualizada correctamente");
        }else {
            vista.mostrarMensaje("El documento ingresado no existe en la base de datos");
        }
    }

    private void eliminarPersona() {
        long documento = vista.leerEntero("Ingrese el documento de la persona que desea eliminar");
        boolean eliminado = modelo.delete(documento);
        if(eliminado) {
            vista.mostrarMensaje("La persona ha sido eliminada correctamente");
        }else {
            vista.mostrarMensaje("El documento ingresado no existe en la base de datos");
        }
    }
    
}
