package figuras.geométricas;

public class FigurasGeométricas {

    public static void main(String[] args) {
        Circulo figura1 = new Circulo(6);
        System.out.println(figura1.calcularPerimetro());
        System.out.println(figura1.calcularArea());
    }
    
}
