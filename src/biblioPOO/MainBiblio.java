package biblioPOO;

import biblioPOO.modelLibros.Ejemplares;
import biblioPOO.modelLibros.LibroDigital;
import biblioPOO.services.EjemplaresService;
import biblioPOO.services.impl.EjemplaresServiceImpl;

public class MainBiblio {
    static void main(String[] args) {
        final EjemplaresServiceImpl ejemplaresService = new EjemplaresServiceImpl();


        LibroDigital e1 = new LibroDigital("150","Dracula","5",6,
                "Carlos",4.06,"TXT","google");

        ejemplaresService.prestar(e1);

    }
}
