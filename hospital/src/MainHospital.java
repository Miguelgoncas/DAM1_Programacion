public class MainHospital {
    public static void main(String[] args) {
        // Creo medicamentos
        Medicamento m1 = new Medicamento("Omeprazol", 20, 14);
        Medicamento m2 = new Medicamento("Ibuprofeno", 600, 7);
        Medicamento m3 = new Medicamento("Paracetamol", 500, 10);

        // Creo registros
        RegistroMedico r1 = new RegistroMedico("19/01/2026", "Dolor de espalda", "Doctor Gabriel");
        RegistroMedico r2 = new RegistroMedico("20/01/2026", "Dolor de cabeza", "Doctora Alma");
        RegistroMedico r3 = new RegistroMedico("21/01/2026", "Inflamación de muñeca", "Doctor Gabriel");

        // Creo historiales
        HistorialMedico historial1 = new HistorialMedico(new Medicamento[] { m2 }, new RegistroMedico[] { r1 });
        HistorialMedico historial2 = new HistorialMedico(new Medicamento[] { m3 }, new RegistroMedico[] { r2 });
        HistorialMedico historial3 = new HistorialMedico(new Medicamento[] { m2 }, new RegistroMedico[] { r3 });

        // Creo pacientes
        Paciente p1 = new Paciente("Miguel", "12348538A", 25, historial1);
        Paciente p2 = new Paciente("Ana", "12470638A", 17, historial2);
        Paciente p3 = new Paciente("Luis", "11469525C", 30, historial3);

        // Muestro la ficha de cada cliente
        System.out.println(p1.mostrarFicha());
        System.out.println("-------------------------\n");
        System.out.println(p2.mostrarFicha());
        System.out.println("-------------------------\n");
        System.out.println(p3.mostrarFicha());
    }
}
