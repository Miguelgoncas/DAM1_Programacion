package SegundoDAM.AccesoDatos.serializable.ejercicios;

import java.io.Serializable;

public class Videojuego implements Serializable {
    private String nombre;
    private String genero;
    private String plataforma;
    private String descripcion;
    private int anio;

    public Videojuego(String nombre, String genero, String plataforma, String descripcion, int anio) {
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.descripcion = descripcion;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", anio=" + anio +
                '}';
    }
}
