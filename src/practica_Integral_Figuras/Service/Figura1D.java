package practica_Integral_Figuras.Service;

public abstract class Figura1D extends Figura {
    private int longitud;

    public Figura1D(String color, int longitud) {
        super(color);
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return super.toString() + "Figura1D" +
                "longitud=" + longitud ;
    }
}
