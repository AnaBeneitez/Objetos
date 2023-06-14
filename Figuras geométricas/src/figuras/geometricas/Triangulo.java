package figuras.geometricas;

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
        float semiPerimetro = this.calcularPerimetro() / 2.00f;
        double formula = Math.sqrt(semiPerimetro * (semiPerimetro - ladoA) * (semiPerimetro - ladoB) * (semiPerimetro - ladoC));
        return (float) formula;
    }
    
    @Override
    public float calcularPerimetro() {
        return this.ladoA + this.ladoB + this.ladoC;
    }
}
