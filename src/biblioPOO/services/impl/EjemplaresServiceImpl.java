package biblioPOO.services.impl;

import biblioPOO.modelLibros.Ejemplares;
import biblioPOO.services.EjemplaresService;

public class EjemplaresServiceImpl implements EjemplaresService {


    @Override
    public boolean prestar(Ejemplares e) {
        if(!e.isDisponible()){
            return false;
        }
        e.setDisponible(true);
        return true;

    }

    @Override
    public boolean devolver(Ejemplares e) {
        if(isDisponible(e)){
            e.setDisponible(true);
            return false;
        }
        return true;
    }

    @Override
    public boolean isDisponible(Ejemplares e) {
        return false;
    }

    @Override
    public double calcularPenalizacion() {
        return 0;
    }
}
