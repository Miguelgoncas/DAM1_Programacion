package ejerciciosExcepciones.excep;

public class RaizNegativaException extends ArithmeticException{
    private String mensaje;

    public RaizNegativaException(){
        this.mensaje = "Raiz negativa";
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
