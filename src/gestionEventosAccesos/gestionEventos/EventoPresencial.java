package gestionEventosAccesos.gestionEventos;

import java.util.Date;

public class EventoPresencial extends Eventos{
    private String ubicacion;

    public EventoPresencial(String codigo, String nombre, String fecha, double precioBase, int aforoMaximo, String ubicacion) {
        super(codigo, nombre, fecha, precioBase, aforoMaximo);
        this.ubicacion = ubicacion;
    }


    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.10;
    }

    @Override
    public String toString() {
        return super.toString() +
                " ubicacion " + ubicacion;
    }
}
