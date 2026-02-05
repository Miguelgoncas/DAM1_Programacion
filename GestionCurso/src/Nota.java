public class Nota {
    private String nombreModulo;
    private double calificacion;

    public Nota(String nombreModulo, double calificacion){
        this.nombreModulo = nombreModulo;
        this.calificacion = calificacion;
    }

    public String mostrarInfo(){
        return "Has sacado un total de: " + calificacion + ", en " + nombreModulo;
    }


    public double getCalificacion(){
        return calificacion;
    }

    public String getNombreModulo(){
        return nombreModulo;
    }
}
