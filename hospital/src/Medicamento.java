public class Medicamento {
    // Declaro los atributos
    private String nombre;
    private int dosisMG;
    private int diasTratamiento;

    // Constructor de la clase
    public Medicamento(String nombre, int dosisMG, int diasTratamiento) {
        this.nombre = nombre;
        this.dosisMG = dosisMG;
        this.diasTratamiento = diasTratamiento;
    }
    // Metodo para mostrar la información del medicamento
    public String mostrarInfo() {
        return "Medicamento: \n" + nombre + "\n Dosis: " + dosisMG + "mg  \n Duración: " + diasTratamiento + " días \n";
    }
}
