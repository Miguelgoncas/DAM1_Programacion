package ficheros;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

public class Persona implements Comparator<Persona>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private double salario;
    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    public Persona(String dni, String nombre, String apellidos, int edad, double salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salario = salario;
    }
    public Persona() {

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

    @Override
    public int compare(Persona o1, Persona o2) {
        return 0;
    }
}
