package entregasyVehiculosReparto.envios;

import entregasyVehiculosReparto.model.Furgoneta;
import entregasyVehiculosReparto.model.Vehiculo;

public class EnvioRefrigerado extends Envio{

    public EnvioRefrigerado(String codigo, double distanciaKm, double pesoKg, String destino) {
        super(codigo, distanciaKm, pesoKg, destino);
    }

    @Override
    public double calcularCoste() {
        return 0;
    }

    @Override
    public boolean esValidoPara(Vehiculo v) {
        return ((v instanceof Furgoneta) && ((Furgoneta) v).getRefrigerada());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
