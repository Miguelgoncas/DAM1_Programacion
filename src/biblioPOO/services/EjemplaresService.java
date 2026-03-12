package biblioPOO.services;

import biblioPOO.modelLibros.Ejemplares;

public interface EjemplaresService {

    boolean prestar(Ejemplares e);

    boolean devolver(Ejemplares e);

    boolean isDisponible(Ejemplares e);

    double calcularPenalizacion();
}
