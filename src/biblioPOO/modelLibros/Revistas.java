package biblioPOO.modelLibros;

public class Revistas extends  Ejemplares{
    String numeroEdicion;
    String periodicidad;
    String categoria;

    public Revistas(String paginas, String titulo, String fechaPublicacion,  int diasPrestamo, String numero, String peri, String categoria) {
        super(paginas, titulo, fechaPublicacion, diasPrestamo);
        this.numeroEdicion = numero;
        this.periodicidad = peri;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() +
                " numero de edición " + numeroEdicion +
                " periodicidad " + periodicidad +
                " categoría " + categoria;
    }
}
