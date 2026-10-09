package colecciones.ejercicio16;

public class Prestamo implements Comparable<Prestamo> {
    private Libro libro;
    private String nombreUsuario;
    private int prioridad;

    public Prestamo(Libro libro, String nombreUsuario, int prioridad) {
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.prioridad = prioridad;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Prestamo o) {
        return this.prioridad - o.getPrioridad() ;
    }

    @Override
    public String toString() {
        return "Prestamo " +
                "libro " + libro.getTitulo() +
                ", usuario " + nombreUsuario + '\'' +
                ", prioridad " + prioridad ;
    }
}
