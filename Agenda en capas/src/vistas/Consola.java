package vistas;

import java.util.Scanner;

public class Consola {
    protected Scanner sc;
    
    public Consola () {
        this.sc = new Scanner(System.in);
    }
    
    public long leerEntero(String msj){
        System.out.println(msj);
        long salida = sc.nextLong();
        sc.nextLine();
        return salida;
    }
    
    public double leerReal(String msj){
        System.out.println(msj);
        double salida = sc.nextDouble();
        sc.nextLine();
        return salida;
    }
    
    public String leerTexto(String msj){
        System.out.println(msj);
        return sc.nextLine();
    }
}
