package tpobjetos;

public class Menu {
    public Consola teclado;
    public Persona[] personas;
    public int personasAgendadas;
    
    public Menu() {
        teclado = new Consola();
        personas = new Persona[100];
        personasAgendadas = 0;
    }
    
    public void mostrarMenu() {
        
        int opcion = 0;
        
        while(opcion != 4) {
            System.out.println("1 - Guardar persona");
            System.out.println("2 - Buscar persona");
            System.out.println("3 - Listar personas");
            System.out.println("4 - Salir");
            opcion = teclado.leerEntero("Ingrese la opción deseada");

            switch(opcion) {
                case 1 -> this.guardarPersona();
                case 2 -> this.buscarPersona();
                case 3 -> this.listarPersonas();
                case 4 -> System.out.println("Muchas gracias!");
                default -> System.out.println("Opción incorrecta"); 
            }
        }
    }
    
    public void guardarPersona() {
        
        if(personasAgendadas < personas.length) {
            String nombre = teclado.leerString("Ingrese el nombre");
            String apellido = teclado.leerString("Ingrese el apellido");
            int documento = teclado.leerEntero("Ingrese el documento");
            Persona nueva = new Persona(nombre, apellido, documento);   
            this.personas[personasAgendadas] = nueva;
            personasAgendadas++;
        }else {
            System.out.println("No hay espacio disponible para agendar");
        }
    }
    
    public void buscarPersona() {
        int aBuscar = teclado.leerEntero("Ingrese el documento de la persona buscada");
        var encontrado = false;
        for(int i = 0; i < personasAgendadas && encontrado == false; i++) {
            if(aBuscar == this.personas[i].documento) {
                System.out.println("Nombre: " + this.personas[i].nombre);
                System.out.println("Apellido: " + this.personas[i].apellido);
                encontrado = true;
            }
        }        
       if(encontrado == false) System.out.println("El documento no existe en la base de datos");
    }
    
    public void listarPersonas() {
        if(personasAgendadas == 0) {
            System.out.println("No hay nadie agendado");
        }
        for(int i = 0; i < personasAgendadas; i++) {
            System.out.println("Nombre: " + this.personas[i].nombre);
            System.out.println("Apellido: " + this.personas[i].apellido);
            System.out.println("DNI: " + this.personas[i].documento);
        }
    }
}
