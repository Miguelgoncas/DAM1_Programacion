package practica_Integral_Figuras.model;

import practica_Integral_Figuras.Service.Figura1D;

public class Segmento extends Figura1D {


    public Segmento(String color, int longitud) {
        super(color, longitud);
    }

    @Override
    public void dibuja() {
        System.out.println("Te he pintado el segmento");
    }

    @Override
    public void borra() {
        System.out.println("Te he borrado el segmento");
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
