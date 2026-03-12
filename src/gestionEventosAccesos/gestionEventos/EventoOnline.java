package gestionEventosAccesos.gestionEventos;

import java.util.Date;

public class EventoOnline extends Eventos{
    private String url;

    public EventoOnline(String codigo, String nombre, String fecha, double precioBase, int aforoMaximo,String url) {
        super(codigo, nombre, fecha, precioBase, aforoMaximo);
        this.url = url;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 0.80;
    }

    @Override
    public String toString() {
        return super.toString() +
                " url " + url;
    }
}
