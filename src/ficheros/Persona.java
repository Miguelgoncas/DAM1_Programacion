package ficheros;

public class Persona {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona " +
                "dni='" + dni + '\'' +
                ", nombre " + nombre + '\'' +
                ", apellidos " + apellidos + '\'' +
                ", edad " + edad ;
    }
}
