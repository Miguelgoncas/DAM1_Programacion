package practicaInterface;

import practicaInterface.Interfacee.Contrato;

public class EmailNotificacion implements Contrato {

    private String remitente;


    public EmailNotificacion(String remitente){
        this.remitente = remitente;
    }
    @Override
    public boolean enviar(String destinatario, String mensaje) {
        return destinatario.contains("@");

    }

    @Override
    public String nombreCanal() {
        return "Email";
    }

    @Override
    public String toString() {
        return remitente;
    }

}
