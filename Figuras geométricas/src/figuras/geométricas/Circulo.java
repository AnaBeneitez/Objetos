package figuras.geométricas;

public class Circulo extends Figura2D{
    protected float radio;
    protected final float pi = 3.1415926535f;
    
    public Circulo (float radio) {
        this.radio = radio;
    }
    
    public float getRadio() {
        return this.radio;
    }
    
    public void setRadio(float r) {
        this.radio = r;
    }
    
    @Override
    public float calcularArea() {
        return pi*radio*radio;
    }
    
    @Override
    public float calcularPerimetro() {
        return pi*radio*2;
    }
}
