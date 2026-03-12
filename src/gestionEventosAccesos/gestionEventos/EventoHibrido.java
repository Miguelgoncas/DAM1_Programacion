package gestionEventosAccesos.gestionEventos;

import java.util.Date;

public class EventoHibrido extends Eventos{
    private String ubicacion;
    private String url;

    public EventoHibrido(String codigo, String nombre, String fecha, double precioBase, int aforoMaximo,String ubicacion,String url) {
        super(codigo, nombre, fecha, precioBase, aforoMaximo);
        this.ubicacion = ubicacion;
        this.url = url;
    }


    @Override
    public double calcularPrecioFinal() {

        return precioBase * 1.05;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", ubicacion " + ubicacion +
                ", url " + url;
    }
}
