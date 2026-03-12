package biblioPOO.modelUsuarios;

public class Profesores extends Persona{
    int departamento;
    boolean prioridadPrestamo;
    int limitePrestamos;

    public Profesores(String dni, String nombre, String email, int departamento, boolean prioridadPrestamo, int limitePrestamos) {
        super(dni, nombre, email);
        this.departamento = departamento;
        this.prioridadPrestamo = prioridadPrestamo;
        this.limitePrestamos = limitePrestamos;
    }
}
