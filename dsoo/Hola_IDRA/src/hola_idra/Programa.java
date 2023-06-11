package hola_idra;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Consola pedirDatos = new Consola ();
        int edad = pedirDatos.leerEntero("Ingrese su edad");
        System.out.println("Usted tiene " + edad + " años.");
    }
    
}
