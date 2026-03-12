package biblioPOO.modelUsuarios;

public class Estudiantes extends Persona{
    String universidad;
    int porcentajeReducionPenalizacion;
    int limitePrestamos;

    public Estudiantes(String dni, String nombre, String email,String universidad, int porcen, int limitePrestamos) {
        super(dni, nombre, email);
        this.universidad = universidad;
        this.porcentajeReducionPenalizacion = porcen;
        this.limitePrestamos = limitePrestamos;
    }
}
