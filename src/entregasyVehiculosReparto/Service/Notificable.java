package entregasyVehiculosReparto.Service;

public interface Notificable {
    boolean enviar(String destino, String mensaje);
    String canal();
}
