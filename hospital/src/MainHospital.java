public class MainHospital {
    public static void main(String[] args) {
        // Crear array de medicamentos
        Medicamento m1 = new Medicamento("Omeprazol", 20, 14);
        Medicamento m2 = new Medicamento("Ibuprofeno", 600, 7);
        Medicamento m3 = new Medicamento("Paracetamol", 500, 10);
        Medicamento[] medicamentos = {m1, m2, m3};

        // Crear array de registros medicos
        RegistroMedico r1 = new RegistroMedico("19/01/2026", "Dolor de espalda", "Doctor Gabriel");
        RegistroMedico r2 = new RegistroMedico("20/01/2026" , "Dolor de cabeza", "Doctora Alma");
        RegistroMedico r3 = new RegistroMedico("21/01/2026", "Inflamación de muñeca", "Doctor Gabriel");
        RegistroMedico[] registros = {r1, r2, r3};

        // Creo array de historial medico y meto los arrays de medicamentos y registros
        HistorialMedico historial = new HistorialMedico(medicamentos, registros);


        // Creo array de pacientes y les asigno el mismo historial medico
        Paciente p1 = new Paciente("Miguel", "12348538A", 25, historial);
        Paciente p2 = new Paciente("Ana", "12470638A", 17, historial);
        Paciente p3 = new Paciente("Luis", "11469525C", 30, historial);

        // Muestro la ficha de cada paciente
        System.out.println(p1.mostrarFicha());
        System.out.println("-------------------------");
        System.out.println("");
        System.out.println(p2.mostrarFicha());
        System.out.println("-------------------------");
        System.out.println("");
        System.out.println(p3.mostrarFicha());

    }
}
