package datos;

public class Cliente extends Persona {
    protected int saldoCtaCte;
    
    public Cliente(String nombre, String apellido, int documento, int saldo) {
//        this.apellido = apellido;
//        this.nombre = nombre;
//        this.documento = documento;
        super(nombre, apellido, documento);
        this.saldoCtaCte = saldo;
    }
    
    public int getSaldoCtaCte() {
        return this.saldoCtaCte;
    }
    
    public void setSaldoCtaCte(int saldo) {
        this.saldoCtaCte = saldo;
    }
    
    @Override
    public String getApellido() {
        //return "[Cliente] "+this.apellido;
        String salida= "[Cliente]";
        
        return salida + super.getApellido();
    }
}
