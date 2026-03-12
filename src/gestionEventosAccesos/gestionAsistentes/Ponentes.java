package gestionEventosAccesos.gestionAsistentes;

public class Ponentes extends Asistentes{

    public Ponentes(String dni, String nombre, String email) {
        super(dni, nombre, email);
    }

    @Override
    public double calcularDinero(double precioEvento) {
        return 0;
    }


}
