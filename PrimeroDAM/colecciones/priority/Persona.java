package colecciones.priority;

public class Persona implements Comparable<Persona>{

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String dni, String nombre, String apellido, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona " +
                "dni " + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad ;
    }

    @Override
    public int compareTo(Persona o) {
        if (this.getEdad() > o.getEdad()) {
            return 1;
        } else if (this.getEdad() < o.getEdad()) {
            return -1;

        }
        return 0;/*else if( this.getApellido().compareTo(o.getApellido()) != 0){
            return this.getApellido().compareTo(o.getApellido());
        } else if (this.nombre.compareTo(o.getNombre()) != 0) {
            return this.nombre.compareTo(o.getNombre());
        } else {
            return this.getDni().compareTo(o.getDni());
        }*/

    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
