package figuras.geométricas;

public class Trapecio extends Cuadrilatero{
    public Trapecio (float ladoA, float ladoB, float ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.ladoD = ladoC;
    }

    public float calcularAltura() {
        float cateto = Math.abs(this.ladoA - this.ladoB)/2;
        return (float) Math.sqrt(Math.pow(this.ladoC,2) - Math.pow(cateto,2));
    }
    
    @Override
    public float calcularArea() {
        return (this.ladoA + this.ladoB)/ 2 * this.calcularAltura();
    }

    @Override
    public float calcularPerimetro() {
        return this.ladoA + this.ladoB + (this.ladoC * 2);
    }
    
}
