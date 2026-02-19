package practica_Integral_Figuras.Service;

public abstract class Figura {
    protected String color;

    public Figura(String color){
        this.color = color;
    }

    public void cambiaColor(String color){
        this.color = color;
    }

    public abstract void dibuja();

    public abstract void borra();

    public abstract double area();

    @Override
    public String toString() {
        return "color: " + color + '\'';
    }
}
