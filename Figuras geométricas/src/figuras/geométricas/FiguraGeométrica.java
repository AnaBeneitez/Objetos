package figuras.geométricas;

public class FiguraGeométrica {

    public static void main(String[] args) {
        Figura2D [] arreglo = new Figura2D [4];
        
        Circulo figura1 = new Circulo(6);
        Triangulo figura2 = new Triangulo (4,5,7);
        Rectangulo figura3 = new Rectangulo (12, 6);
        Trapecio figura4 = new Trapecio(8,12,5);
        
        arreglo[0] = figura1;
        arreglo[1] = figura2;
        arreglo[2] = figura3;
        arreglo[3] = figura4;
        
        System.out.println(figura1.calcularPerimetro());
        System.out.println(figura1.calcularArea());
        System.out.println(figura2.calcularPerimetro());
        System.out.println(figura2.calcularArea());
        System.out.println(figura3.calcularPerimetro());
        System.out.println(figura3.calcularArea());
        System.out.println(figura4.calcularPerimetro());
        System.out.println(figura4.calcularArea());
                
        for(int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i].calcularPerimetro());
            System.out.println(arreglo[i].calcularArea());
            System.out.println(arreglo[i].getClass());
        }

    }
    
}
