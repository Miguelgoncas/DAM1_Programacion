package gestionEventosAccesos.service;

import java.util.ArrayList;

public class GestorEventos {
    private ArrayList<Inscripcion> inscripciones;

    public GestorEventos() {
        inscripciones = new ArrayList<>();
    }

    public boolean registrarInscripciones(String codEvento,String dni){

        for (Inscripcion i : inscripciones){
            if(i.getCodigoEvento().equals(codEvento) &&
                    i.getDniAsistente().equals(dni)){
                return false;
            }
        }



        inscripciones.add(new Inscripcion(codEvento,dni));
        return true;
    }
}
