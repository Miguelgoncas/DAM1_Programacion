package practica_Integral_Figuras.model;

import practica_Integral_Figuras.Service.Figura2D;

public class Circulo extends Figura2D {
    private double radio;

    public Circulo(String color,String relleno, double radio) {
        super(color, relleno);
        this.radio = radio;
    }

    // implementamos los métodos del padre, así no tenemos que crear esta clase abstracta,
    // las clases abstractas no puede crear objetos, por eso tenemos que no hacerlo
    @Override
    public void dibuja() {
        System.out.println("Te he pintado el circulo");
    }

    @Override
    public void borra() {
        System.out.println("Te he borrado el area");
    }

    @Override
    public double area() {
        // Usamos la clase Math para poder usar PI y el pow para elevar
        return Math.PI*Math.pow(radio,radio);
    }

    @Override
    public String toString() {
        return super.toString() + " Circulo" +
                "radio=" + radio ;
    }
}
