package biblioPOO.modelUsuarios;

public class UsuarioEstandar extends Persona{
    int limitePrestamos;
    double penalizacionDia;

    public UsuarioEstandar(String dni, String nombre, String email, int limitePrestamos, double pena) {
        super(dni, nombre, email);
        this.limitePrestamos = limitePrestamos;
        this.penalizacionDia = pena;
    }
}
