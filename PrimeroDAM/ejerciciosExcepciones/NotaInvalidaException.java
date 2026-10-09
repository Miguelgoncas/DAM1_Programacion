package ejerciciosExcepciones;

public class NotaInvalidaException extends Exception{
    private String menssage;

    public NotaInvalidaException(){
        this.menssage = "la nota tiene que ser entre 0 y 10";
    }

    public NotaInvalidaException(String mensaje){
        this.menssage = mensaje;
    }


    @Override
    public String getMessage() {
        return this.menssage;
    }
}
