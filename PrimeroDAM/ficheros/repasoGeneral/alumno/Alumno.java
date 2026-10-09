package ficheros.repasoGeneral.alumno;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellido;
    private double nota;

    public Alumno (String dni, String nombre, String apellido, double nota){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getNota() {
        return nota;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nota=" + nota +
                '}';
    }
}
