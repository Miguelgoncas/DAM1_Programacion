package biblioPOO.modelLibros;

public class LibroDigital extends Ejemplares{
    String autor;
    double tamañoMB;
    String formatoArchivo;
    String urlDescargar;

    public LibroDigital(String paginas, String titulo, String fechaPublicacion,  int diasPrestamo, String autor, double tamañoMB, String formato, String url) {
        super(paginas, titulo, fechaPublicacion, diasPrestamo);
        this.tamañoMB = tamañoMB;
        this.autor = autor;
        this.formatoArchivo = formato;
        this.urlDescargar = url;
    }

    @Override
    public String toString() {
        return super.toString() +
                " autor " + autor +
                " tamañoMB " + tamañoMB +
                " formato de archivo " + formatoArchivo +
                " url " + urlDescargar;
    }
}
