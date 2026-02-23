package entregasyVehiculosReparto.envios;

import entregasyVehiculosReparto.model.Vehiculo;

public class EnvioEstandar extends  Envio{

    public EnvioEstandar(String codigo, double distanciaKm, double pesoKg, String destino) {
        super(codigo, distanciaKm, pesoKg, destino);
    }

    @Override
    public double calcularCoste() {
         return (super.calcularCostePorKg() + COSTE_BASE + (COSTE_POR_KM * distanciaKm));
    }

    @Override
    public boolean esValidoPara(Vehiculo v) {
        return super.esValidoPara(v);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString() + " con un coste de " + calcularCoste();
    }
}
