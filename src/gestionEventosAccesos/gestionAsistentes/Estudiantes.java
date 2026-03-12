package gestionEventosAccesos.gestionAsistentes;

public class Estudiantes extends Asistentes{

    public Estudiantes(String dni, String nombre, String email) {
        super(dni, nombre, email);

    }

    @Override
    public double calcularDinero(double precioEvento) {
        return precioEvento * 0.5;
    }


}
