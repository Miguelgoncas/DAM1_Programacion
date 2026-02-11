import java.util.Comparator;

public class Persona implements Comparable<Persona> {
    public static final Comparator<Persona> COMPARAPORNOMBRE = new Comparator<Persona>();


    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }



    public String toString(){
        return "Nombre: " + nombre + ", Edad: " + edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.getNombre());
    }
}
