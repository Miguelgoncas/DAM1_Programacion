public class HistorialMedico {
    // Declaro los atributos
    private Medicamento[] medicamentos;
    private RegistroMedico[] registros;
    private int contadorMedicamentos = 0;
    private int contadorRegistros = 0;

    // Constructor de la clase
    public HistorialMedico(Medicamento[] medicamentos, RegistroMedico[] registros) {
        this.medicamentos = medicamentos;
        this.registros = registros;
    }

    // Metodo para añadir un medicamento al historial
    public boolean añadirMedicamento(Medicamento medicamento) {
        // Verifico que haya espacio en el array
        if (contadorMedicamentos < medicamentos.length) {
            medicamentos[contadorMedicamentos] = medicamento;
            // Incremento el contador de medicamentos para no sobrescribir el siguiente
            contadorMedicamentos++;
            return true;
        }
        return false;
    }

    // Metodo para añadir un registro medico al historial
    public boolean añadirRegistroMedico(RegistroMedico registro) {
        // Verifico que haya espacio en el array
        if (contadorRegistros < registros.length) {
            registros[contadorRegistros] = registro;
            // Incremento el contador de registros para no sobrescribir el siguiente
            contadorRegistros++;
            return true;
        }
        return false;
    }

    public String mostrarHistorial(){
        // Creo un String vacio para almacenar el String que devuelve el metodo de medicamentos
        String infoMed = "";
        for(Medicamento medicamento: this.medicamentos){
            infoMed += medicamento.mostrarInfo();
        }
        // Creo un String vacio para almacenar el String que devuelve el metodo de registros
        String infoReg = "";
        for(RegistroMedico registro: this.registros){
            infoReg += registro.mostrarRegistro();
    }
        // Devuelvo las variables que he creado para que almacenes la información concatenadas entre ellas
        return   infoMed + "\nRegistros Médicos:" + infoReg;
    }
}
