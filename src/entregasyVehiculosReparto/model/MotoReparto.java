package entregasyVehiculosReparto.model;

public class MotoReparto extends Vehiculo{
    private int cilindrada;

    public MotoReparto(String matricula, double capacidadKg, double consumeBase, int cilindrada) {
        super(matricula, capacidadKg, consumeBase);
        this.cilindrada = cilindrada;
    }


    @Override
    public double costePorKm() {
        return ((consumeBase*PRECIO_GASOLINA) /100);
    }



    @Override
    public String toString() {
        return super.toString() + "MotoReparto " +
                "cilindrada " + cilindrada +
                " " + costePorKm() + "\n ";
    }
}
