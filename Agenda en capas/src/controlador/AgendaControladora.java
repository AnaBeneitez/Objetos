package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Agenda;
import modelo.DocumentoRepetidoException;
import modelo.Persona;
import vistas.AgendaVista;

public class AgendaControladora {
    protected AgendaVista vista;
    protected Agenda modelo;
    
    public AgendaControladora() {
        this.vista = new AgendaVista();
        this.modelo = new Agenda();
    }
    
    public void mostrarAgenda(){
        int op = 0;
        do{
            vista.mostrarMenu();
            op = vista.leerOpcion();
            ejecutarOpcion(op);
        }while (op != 4);
    }

    private void ejecutarOpcion(int op) {
        switch (op){
        case 1:
            agregarPersona(); 
            break;
        case 2:
            buscarPorDocumento();
            break;
        case 3: 
            mostrarGente(); 
            break;
        case 4:
            break;
            default: vista.mostrarMensaje("Opción incorrecta");
      }
    }

    private void agregarPersona() {
        List datos = vista.pedirDatosPersona();
        Persona p = new Persona( (String)datos.get(0),
                                 (String) datos.get(1),
                                 (long) datos.get(2));
        try {
            this.modelo.agregarPersona(p);
            vista.mostrarMensaje("Se ha agregado correctamente");
            vista.mostrarPersona(datos);
        } catch (DocumentoRepetidoException ex){
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    private void mostrarGente() {
        for(Persona p: modelo.getGente()){
            List datos = new ArrayList();
            datos.add(p.getNombre());
            datos.add(p.getApellido());
            datos.add(p.getDocumento());
            vista.mostrarPersona(datos);
        }
    }

    private void buscarPorDocumento() {
        long docBuscar = vista.leerEntero("Ingrese el documento a buscar");
        boolean encontrado = false;
        for(Persona p: modelo.getGente()){
            if(p.getDocumento() == docBuscar){
                encontrado = true;
                List datos = new ArrayList();
                datos.add(p.getNombre());
                datos.add(p.getApellido());
                datos.add(p.getDocumento());
                vista.mostrarMensaje("El documento ingresado corresponde a:");
                vista.mostrarPersona(datos);
            }
        }
        if(!encontrado) vista.mostrarMensaje("El documento ingresado no se encuentra en la agenda");
    }
}
