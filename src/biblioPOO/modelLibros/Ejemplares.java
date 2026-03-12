package biblioPOO.modelLibros;

public abstract class Ejemplares {
    private String paginas;
    private String titulo;
    private String fechaPublicacion;
    private boolean disponible;
    private int diasPrestamo;

    public Ejemplares(String paginas, String titulo, String fechaPublicacion, int diasPrestamo) {
        this.paginas = paginas;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.diasPrestamo = diasPrestamo;
    }


    @Override
    public String toString() {
        return "Ejemplares" +
                "paginas " + paginas +
                ", titulo " + titulo +
                ", fechaPublicacion " + fechaPublicacion +
                ", disponible " + disponible +
                ", diasPrestamo " + diasPrestamo ;
    }


    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
