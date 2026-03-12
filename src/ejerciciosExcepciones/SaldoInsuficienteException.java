package ejerciciosExcepciones;

public class SaldoInsuficienteException extends Exception{
    private String mensaje ;

    public SaldoInsuficienteException(){
        this.mensaje = "No puedes retirar más dinero del disponible";
    }

    public String getMensaje(){
        return this.mensaje;
    }

}
