public class Modulo {
    private String nombre;
    private int horas;
    private String profesor;

    public Modulo(String nombre, int horas, String profesor){
        this.nombre = nombre;
        this.horas = horas;
        this.profesor = profesor;
    }


    public String mostrarInfo(){
        return "Nombre del módulo: \n" + nombre + "\n Horas lectivas: \n" + horas + "\n Impartida por: \n" + profesor;
    }

    public String getNombre(){
        return this.nombre;
    }

}
