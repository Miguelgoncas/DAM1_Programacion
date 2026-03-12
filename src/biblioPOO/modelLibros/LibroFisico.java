package biblioPOO.modelLibros;

public class LibroFisico extends Ejemplares{
    String autor;
    String editorial;
    int numeroPaginas;
    int ubicacionEstanteria;

    public LibroFisico(String paginas, String titulo, String fechaPublicacion, int diasPrestamo, String autor, String editorial, int numeroPaginas, int ubicacionEstanteria) {
        super(paginas, titulo, fechaPublicacion,  diasPrestamo);
        this.autor = autor;
        this. editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.ubicacionEstanteria = ubicacionEstanteria;
    }

    @Override
    public String toString() {
        return super.toString() +
                " autor " + autor +
                " editorial " + editorial +
                " numero de páginas" + numeroPaginas +
                " ubicación en estantería " + ubicacionEstanteria;
    }
}
