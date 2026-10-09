package colecciones.priority;

import java.util.Comparator;

public class CompararPrioridad implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
        return o1.getPrioridad() - o2.getPrioridad();
    }
}
