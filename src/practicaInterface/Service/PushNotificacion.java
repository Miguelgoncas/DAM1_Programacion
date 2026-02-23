package practicaInterface.Service;

import practicaInterface.Interface.Contrato;

public class PushNotificacion implements Contrato {
    private String app;

    public PushNotificacion(String app) {
        this.app = app;
    }

    @Override
    public boolean enviar(String destinatario, String mensaje) {
        return destinatario.startsWith("device_");
    }

    @Override
    public String nombreCanal() {
        return "Push";
    }

    @Override
    public String toString() {
        return app;
    }
}
