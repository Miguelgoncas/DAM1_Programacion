package practica_Integral_Figuras.model;

import practica_Integral_Figuras.Service.Figura2D;

public class Triangulo extends Figura2D {
    private double base;
    private double altura;

    public Triangulo(String color, String colorRelleno,double base, double altura){
        super(color,colorRelleno);
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area(){
        return (base*altura) / 2;
    }
    @Override
    public void dibuja() {
        System.out.println("Te he pintado el triangulo");
    }

    @Override
    public void borra() {
        System.out.println("Te he borrado el triangulo");
    }
}
