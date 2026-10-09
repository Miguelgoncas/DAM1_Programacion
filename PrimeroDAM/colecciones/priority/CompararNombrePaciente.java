package colecciones.priority;

import java.util.Comparator;

public class CompararNombrePaciente implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
