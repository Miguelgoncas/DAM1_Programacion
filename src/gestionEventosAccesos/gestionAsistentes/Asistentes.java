package gestionEventosAccesos.gestionAsistentes;

public abstract class Asistentes  {
    String dni;
    String nombre;
    String email;


    public Asistentes(String dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        
    }

    public abstract double calcularDinero(double precioEvento);

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asistentes asis = (Asistentes) o;

        return dni.equals(asis.dni);
    }


    public String getDni(){
        return dni;
    }



}
