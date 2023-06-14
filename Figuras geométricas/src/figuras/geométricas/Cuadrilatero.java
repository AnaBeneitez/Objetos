package figuras.geométricas;

public abstract class Cuadrilatero extends Figura2D {
    protected float ladoA;
    protected float ladoB;
    protected float ladoC;
    protected float ladoD;
    
    public float getLadoA() {
        return this.ladoA;
    }
    
    public float getLadoB() {
        return this.ladoB;
    }
    
    public float getLadoC() {
        return this.ladoC;
    }
    
    public float getLadoD() {
        return this.ladoD;
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
    
    public void setLadoD(float d) {
        this.ladoD = d;
    }
}
