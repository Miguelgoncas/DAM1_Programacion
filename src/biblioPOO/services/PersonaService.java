package biblioPOO.services;

import biblioPOO.modelLibros.Ejemplares;

public interface PersonaService {

    boolean solicitarPrestamo(Ejemplares e);

    boolean devolverLibro(Ejemplares e);
}
