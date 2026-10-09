package SegundoDAM.AccesoDatos.serializable.ejercicios;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String eMail;
    private int anioNacimiento;

    public Persona(String nombre, String eMail, int anioNacimiento) {
        this.nombre = nombre;
        this.eMail = eMail;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", eMail='" + eMail + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                '}';
    }
}
