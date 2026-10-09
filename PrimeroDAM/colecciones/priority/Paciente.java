package colecciones.priority;

public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private int prioridad;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }


    @Override
    public int compareTo(Paciente o) {
        if(this.prioridad > o.getPrioridad()){
            return 1;
        } else if(this.prioridad < o.getPrioridad()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "paciente " + this.nombre +
                " prioridad " + this.prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
