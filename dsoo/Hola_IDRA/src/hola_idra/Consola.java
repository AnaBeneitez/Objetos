package hola_idra;

import java.util.Scanner;

public class Consola {
    private Scanner sc;
    
    public Consola() {
        this.sc = new Scanner(System.in);
    }
    
    public String leerString(String msg){
        System.out.println(msg);
        return sc.nextLine();
    }
    
    public int leerEntero(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
    
    public float leerFloat(String msg) {
        System.out.println(msg);
        return sc.nextFloat();
    }
}
