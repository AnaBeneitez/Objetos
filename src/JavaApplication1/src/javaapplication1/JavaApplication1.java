package javaapplication1;

import java.util.ArrayList;
import java.util.List;

public class JavaApplication1 {

    public static void main(String[] args) {
        // TODO code application logic here
        List <Persona> personas = new ArrayList();
        personas.add(new Persona());
        personas.add(new Persona());
        System.out.println(personas.size());
        personas.remove(new Persona());
        //Persona personas[] = new Persona[10];
        for(Persona p : personas) {
            System.out.println("p");
        }
        //personas.forEach(action);
    }
    
}
