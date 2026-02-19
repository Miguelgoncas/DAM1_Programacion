package practica_Integral_Figuras.Service;

public  abstract class Figura2D extends Figura {
    protected String colorRelleno;

    public Figura2D(String color, String relleno) {
        super(color);
        this.colorRelleno = relleno;
    }


    public  void cambiaRelleno(String relleno){
        this.colorRelleno = relleno;
    }

    @Override
    public String toString() {
        return super.toString() + "Figura2D " +
                "colorRelleno='" + colorRelleno + '\'';
    }
}
