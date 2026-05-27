package ejerciciosExcepciones.excep;

public class DividirPorCeroException extends Exception {
    private String mensaje;

    public DividirPorCeroException(String mensaje) {
        this.mensaje = mensaje;
    }

    public DividirPorCeroException() {
        this.mensaje = "No puedes dividir por 0";
    }



    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
