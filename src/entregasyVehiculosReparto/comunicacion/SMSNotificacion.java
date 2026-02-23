package entregasyVehiculosReparto.comunicacion;

import entregasyVehiculosReparto.Service.Notificable;

public class SMSNotificacion implements Notificable {

    @Override
    public boolean enviar(String destino, String mensaje) {
        System.out.println("Enviando SMS a " + destino + " con el mensaje: " + mensaje);
        return true;
    }

    @Override
    public String canal() {
        return "SMS";
    }
}
