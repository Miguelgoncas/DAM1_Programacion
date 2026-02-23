package entregasyVehiculosReparto.comunicacion;

import entregasyVehiculosReparto.Service.Notificable;

public class EmailNotificacion implements Notificable {

    @Override
    public boolean enviar(String destino, String mensaje) {
        System.out.println("Enviando email a " + destino + " con el mensaje: " + mensaje);
        return true;
    }

    @Override
    public String canal() {
        return "Email";
    }
}
