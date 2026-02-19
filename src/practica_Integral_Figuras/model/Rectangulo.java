package practica_Integral_Figuras.model;

import practica_Integral_Figuras.Service.Figura2D;

public class Rectangulo extends Figura2D {
    private double base;
    private double altura;

    public Rectangulo(String color, String relleno, double base, double altura) {
        super(color, relleno);
        this.base = base;
        this.altura = altura;
    }


    @Override
    public void dibuja() {
        System.out.println("Te he pintado el rectangulo");
    }

    @Override
    public void borra() {
        System.out.println("Te he borrado el rectangulo");
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }

    public String toString(){
        return super.toString() + "base: " + this.base + " altura " + this.altura;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.base == ((Rectangulo)obj).base &&
        this.altura == ((Rectangulo)obj).altura &&
        this.color.equals(((Rectangulo)obj).color)&&
        this.colorRelleno.equals(((Rectangulo)obj).colorRelleno)){
            return true;
        }
        return false;
    }
}
