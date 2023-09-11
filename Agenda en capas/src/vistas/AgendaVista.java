package vistas;

import java.util.ArrayList;
import java.util.List;

public class AgendaVista extends Consola {
    public void mostrarMenu(){
        System.out.println("1 - Agregar una persona");
        System.out.println("2 - Buscar por documento");
        System.out.println("3 - Listar personas");
        System.out.println("4 - Salir");
    }
    
    public int leerOpcion() {
        return (int) this.leerEntero("Ingrese la opción deseada");
    }
    
    public void mostrarMensaje(String msj) {
        System.out.println(msj);
    }
    
    public List pedirDatosPersona(){
        List salida = new ArrayList();
        String nombre = this.leerTexto("Ingrese el nombre");
        String apellido = this.leerTexto("Ingrese el apellido");
        long documento = this.leerEntero("Ingrese el documento");
        salida.add(nombre);
        salida.add(apellido);
        salida.add(documento);
        return salida;
    }
    
    public void mostrarPersona(List datos) {
        System.out.println("Nombre: " + (String)datos.get(0));
        System.out.println("Apellido: " + (String) datos.get(1));
        System.out.println("Documento: " + (long) datos.get(2));
        System.out.println("--------------------------------------");
    }
}
