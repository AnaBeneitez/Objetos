package figuras.geometricas;

public class Rectangulo extends Cuadrilatero {
    public Rectangulo (float ladoA, float ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoA;
        this.ladoD = ladoB;
    }

    @Override
    public float calcularArea() {
        return this.ladoA * this.ladoB;
    }

    @Override
    public float calcularPerimetro() {
        return (this.ladoA*2)+(this.ladoB*2);
    }
}
