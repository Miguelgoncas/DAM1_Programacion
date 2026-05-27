package ficheros.repasoGeneral.ventas;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadTotal;


    public Producto(String nombre, double precio, int cantidadTotal) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadTotal = cantidadTotal;
    }

    public double getTotal() {
        return precio * cantidadTotal;
    }

}
