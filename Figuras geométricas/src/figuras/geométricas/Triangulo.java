package figuras.geométricas;

public class Triangulo extends Figura2D{
    protected float ladoA;
    protected float ladoB;
    protected float ladoC;
    
    public Triangulo(float a, float b, float c) {
        this.ladoA = a;
        this.ladoB = b;
        this.ladoC = c;
    }
    
    public float getLadoA() {
        return this.ladoA;
    }
    
    public float getLadoB() {
        return this.ladoB;
    }
    
    public float getLadoC() {
        return this.ladoC;
    }
    
    public void setLadoA(float a) {
        this.ladoA = a;
    }
    
    public void setLadoB(float b) {
        this.ladoB = b;
    }
    
    public void setLadoc(float c) {
        this.ladoC = c;
    }

    @Override
    public float calcularArea() {
        
    }

    @Override
    public float calcularPerimetro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
