package entregasyVehiculosReparto.model;

import entregasyVehiculosReparto.Service.Recargable;

public class Dron extends Vehiculo implements Recargable {
    private double autonomiaMin;
    private double pesoMaxPaquete;
    private double energia;

    public Dron(String matricula, double capacidadKg, double consumeBase,
                double autonomiaMin, double pesoMaxPaquete, double energia) {
        super(matricula, capacidadKg, consumeBase);
        this.autonomiaMin = autonomiaMin;
        this.pesoMaxPaquete = pesoMaxPaquete;
        this.energia = energia;

    }

    @Override
    public double costePorKm() {
        return ((consumeBase*PRECIO_ELECTRICIDAD) /100);
    }

    @Override
    public double autonomiaEstimada() {
        if(consumeBase == 0) return 0;
        return (energia / consumeBase) *100;
    }

    @Override
    public String toString() {
        return super.toString() + "Dron" +
                "autonomiaMin " + autonomiaMin +
                ", pesoMaxPaquete " + pesoMaxPaquete +
                " " + autonomiaEstimada() + "\n ";
    }

    @Override
    public int nivelBateria() {
        return this.nivelBateria();
    }

    @Override
    public void recargar(int minutos) {

    }
}
