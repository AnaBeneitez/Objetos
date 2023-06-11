package idra_herencia;

import datos.Cliente;
import datos.Persona;

public class Programa {

    public static void main(String[] args) {
        Persona p;
        Cliente c;
        
        p = new Persona("Esteban", "Santini", 12345678);
        System.out.println(
                p.getApellido()+", "+
                p.getNombre()+" ("+
                p.getDocumento()+")"
        );
        System.out.println(p);
        
        c = new Cliente("Perez", "Juan", 22334455, -500);
        System.out.println(
                c.getApellido()+", "+
                c.getNombre()+" ("+
                c.getDocumento()+") $"+
                c.getSaldoCtaCte()
        );
    }
    
}
