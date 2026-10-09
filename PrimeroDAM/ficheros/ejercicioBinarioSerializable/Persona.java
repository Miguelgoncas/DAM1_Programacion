package ficheros.ejercicioBinarioSerializable;

import java.io.Serializable;
import java.util.Comparator;

public class Persona implements Comparable<Persona>, Serializable {

    private static final long serialVersionUID = 1L;
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


    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }


    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona o) {
        return getApellido().compareTo(o.getApellido());
    }
}
