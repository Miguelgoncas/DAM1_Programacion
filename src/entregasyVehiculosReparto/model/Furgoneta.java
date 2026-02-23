package entregasyVehiculosReparto.model;

public class Furgoneta extends Vehiculo{
    private boolean refrigerada;

    public Furgoneta( String matricula, double capacidadKg,double consumeBase,  boolean refrigerada){
        super(matricula,capacidadKg,consumeBase);
        this.refrigerada = refrigerada;
    }

    @Override
    public double costePorKm() {

        return ((consumeBase*PRECIO_GASOLINA) /100);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString() + "Furgoneta " +
                "refrigerada " + refrigerada +
                " " + costePorKm() + "\n ";
    }

    public boolean getRefrigerada() {
        return refrigerada;
    }
}
