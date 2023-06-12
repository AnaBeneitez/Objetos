package tpobjetos;

public class Menu {
    public Consola teclado;
    public Persona gente[];
    public int personasAgendadas;
    
    public Menu () {
        this.teclado = new Consola();
        this.gente = new Persona [100];
        this.personasAgendadas = 0;
    }
    
    public void mostrarMenu() {
        int eleccion;
        
        do {
            System.out.println("1 - Agendar un nuevo contacto");
            System.out.println("2 - Buscar contacto");
            System.out.println("3 - Listar contactos");
            System.out.println("4 - Cerrar agenda");
            eleccion = teclado.leerEntero("Elija la opción deseada");
            
            switch(eleccion){
                case 1 -> this.agregarPersona();
                case 2 -> this.buscarPersona();
                case 3 -> this.listarPersonas();
                case 4 -> System.out.println("Muchas gracias");
                default -> System.out.println("Opción incorrecta");
            }
        }while(eleccion != 4);
        
    }
    
    private void agregarPersona(){
        if(this.personasAgendadas < gente.length) {
            String nombre = teclado.leerString("Ingrese el nombre");
            String apellido = teclado.leerString("Ingrese el apellido");
            int documento = teclado.leerEntero("Ingrese el documento");
            Persona nueva = new Persona(nombre, apellido, documento);
            this.gente[this.personasAgendadas] = nueva;
            this.personasAgendadas++;
        }
        else System.out.println("No hay más lugar para agendar");
    }
    
    private void buscarPersona() {
        var encontrado = false;
        int aBuscar = teclado.leerEntero("Ingrese el documento de la persona que desea buscar");
        for(int i = 0; i < this.personasAgendadas && !encontrado; i++) {
            if(aBuscar == this.gente[i].documento) {
                this.mostrarPersona(this.gente[i]);
                encontrado = true;
            }
        }
        if(!encontrado) System.out.println("El documento no existe en la base de datos");
    }
    
    private void listarPersonas() {
        for(int i = 0; i < this.personasAgendadas; i++){
            this.mostrarPersona(this.gente[i]);
        }
    }
    
    private void mostrarPersona(Persona aMostrar) {
        System.out.println("Nombre: " + aMostrar.nombre);
        System.out.println("Apellido: " + aMostrar.apellido);
        System.out.println("DNI: " + aMostrar.documento);
    }
}
