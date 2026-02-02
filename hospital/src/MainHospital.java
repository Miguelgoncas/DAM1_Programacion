import javax.swing.*;

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

        // Creo historiales vacíos y les añados medicamentos y registros
        HistorialMedico h1 = new HistorialMedico();
        h1.MaxhistorialMedico(5,5);
        if(!h1.añadirMedicamento(m1))
            System.out.println("No se ha podido crear el medicamento");
        if(!h1.añadirMedicamento(m2))
            System.out.println("No se ha podido crear el medicamento");
        if(!h1.añadirRegistroMedico(r1))
            System.out.println("No se ha podido crear el registro");

        HistorialMedico h2 = new HistorialMedico();
        h2.MaxhistorialMedico(5,5);
        if(!h2.añadirMedicamento(m3))
            System.out.println("No se ha podido crear el medicamento");
        if(!h2.añadirRegistroMedico(r2))
            System.out.println("No se ha podido crear el registro");

        HistorialMedico h3 = new HistorialMedico();
        h3.MaxhistorialMedico(5,5);

        if(!h3.añadirMedicamento(m2))
            System.out.println("No se ha podido crear el medicamento");
        if(!h3.añadirMedicamento(m1))
            System.out.println("No se ha podido crear el medicamento");
        if(!h3.añadirRegistroMedico(r3))
            System.out.println("No se ha podido crear el registro");



        // Creo pacientes
        Paciente p1 = new Paciente("Miguel", "12348538A", 25, h1);
        Paciente p2 = new Paciente("Alejandro", "13796481X", 17, h2);
        Paciente p3 = new Paciente("Luis", "11469525C", 30, h3);

        Paciente[] pacientes = {p1,p2,p3};


        // Muestro la ficha de cada cliente
        for(Paciente paciente : pacientes){
            JOptionPane.showMessageDialog(null, paciente.mostrarFicha());
        }

    }
}
