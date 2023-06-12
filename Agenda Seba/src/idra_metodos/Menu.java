package idra_metodos;

public class Menu {
    protected Persona persona;
    protected Consola teclado;
    
    public Menu()
    {
        this.teclado = new Consola();
    }
    
    

    public void mostrarMenu(){
        int opcion ;
        
        do {
            System.out.println("Opcion 1: Crear Persona");
            System.out.println("Opcion 2: Buscar Persona");
            System.out.println("Opcion 3: Listar Personas");
            System.out.println("Opcion 4: Salir");
            opcion = teclado.leerEntero("Ingrese la opcion");
            
            switch(opcion){
                case 1:
                    this.crearPersona();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                
            }
        } while(opcion != 4);   
        
    }

    private void crearPersona() {
        String nombre = teclado.leerString("Ingrese nombre");
        String apellido = teclado.leerString ("Ingrese apellido");
        
        this.persona = new Persona(nombre,apellido);
        
    }
}
