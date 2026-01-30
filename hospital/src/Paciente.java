public class Paciente {
    // Declaro los atributos
    private String nombre;
    private String dni;
    private int edad;
    private HistorialMedico historial;

    // Constructor de la clase
    public Paciente(String nombre, String dni, int edad, HistorialMedico historial) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.historial = historial;
    }

    // Metodo para mostrar la información del paciente
    public String mostrarFicha() {
        return "Nombre: " + nombre + "\n DNI: " + dni + "\n Edad: " + edad + "\n" +
               "Historial Médico:\n" + historial.mostrarHistorial();
    }

    // Metodo para comprobar si el paciente es mayor de edad
    public boolean esMayordeEdad() {
        // Devuelvo directamente true o false según la condición
        return edad >= 18;
    }
}
