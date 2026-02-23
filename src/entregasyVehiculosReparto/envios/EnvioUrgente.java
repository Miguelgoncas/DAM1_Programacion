package entregasyVehiculosReparto.envios;

import entregasyVehiculosReparto.model.Vehiculo;

public class EnvioUrgente extends Envio{
    boolean prioridad;
    int costeExtra;

    public EnvioUrgente(String codigo, double distanciaKm, double pesoKg, String destino, boolean prioridad) {
        super(codigo, distanciaKm, pesoKg, destino);
        this.prioridad = prioridad;
        this.costeExtra = prioridad ? 10 : 0;
    }


    @Override
    public double calcularCoste() {
        return (super.calcularCostePorKg() + COSTE_BASE + (COSTE_POR_KM * distanciaKm) + costeExtra);
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString() + " con prioridad " + (prioridad ? "alta" : "normal") + " y un coste de " + calcularCoste();
    }
}
