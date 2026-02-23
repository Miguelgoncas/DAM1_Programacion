package practicaInterface.Interface;

public interface Contrato {
    boolean enviar(String destinatario, String mensaje);
    String nombreCanal();

    public String toString();


}
