
package tpobjetos;

import java.util.Scanner;

public class Consola {
    private Scanner sc;
    
    public Consola() {
        this.sc = new Scanner (System.in);
    }
    
    public String leerString(String msg){
        sc.nextLine();
        System.out.println(msg);
        String retorno = sc.nextLine();
        return retorno;
    }
    
    public int leerEntero(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
    
    public float leerFloat(String msg){
        System.out.println(msg);
        return sc.nextFloat();
    }
}
