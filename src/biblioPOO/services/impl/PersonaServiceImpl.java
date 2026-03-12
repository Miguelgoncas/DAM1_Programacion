package biblioPOO.services.impl;

import biblioPOO.modelLibros.Ejemplares;
import biblioPOO.services.EjemplaresService;
import biblioPOO.services.PersonaService;

public class PersonaServiceImpl implements PersonaService {
     final EjemplaresService ejemplaresService;

    public PersonaServiceImpl(EjemplaresService ejemplaresService) {
        this.ejemplaresService = ejemplaresService;
    }

    @Override
    public boolean solicitarPrestamo(Ejemplares e) {
        if(!e.isDisponible()) {
            return false;
        }
         return ejemplaresService.prestar(e);

    }

    @Override
    public boolean devolverLibro(Ejemplares e) {
        return ejemplaresService.devolver(e);
    }
}
