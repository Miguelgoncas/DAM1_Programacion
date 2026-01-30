public class RegistroMedico {
    // Declaro los atributos
    private String fecha;
    private String descripcion;
    private String medico;

    // Constructor de la clase
    public RegistroMedico(String fecha, String descripcion, String medico) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.medico = medico;
    }

    // Metodo para mostrar la información
    public String mostrarRegistro() {
        return "Fecha: " + fecha + "\n Descripción: " + descripcion + "\n Médico: " + medico;
    }
}
