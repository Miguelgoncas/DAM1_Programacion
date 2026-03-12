package gestionEventosAccesos.gestionAsistentes;

public class PublicoGeneral extends Asistentes{


    public PublicoGeneral(String dni, String nombre, String email) {
        super(dni, nombre, email);
    }

    @Override
    public double calcularDinero(double precio) {
        return precio;
    }




}
