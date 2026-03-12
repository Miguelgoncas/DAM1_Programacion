package entregasyVehiculosReparto.model;

public abstract class Vehiculo {
    final double PRECIO_GASOLINA = 1.5;
    final double PRECIO_ELECTRICIDAD = 0.2;
    String matricula;
    double capacidadKg;
    double consumeBase;
    boolean disponible;

    public Vehiculo(String matricula, double capacidadKg, double consumeBase) {
        this.matricula = matricula;
        this.capacidadKg = capacidadKg;
        this.consumeBase = consumeBase;
    }

    public abstract double costePorKm();

    public  double autonomiaEstimada(){

        return 0;
    }

    public final void marcarEnRuta(){

    }

    @Override
    public String toString() {
        return "Vehiculo " +
                "matricula " + matricula + ' ' +
                ", capacidadKg " + capacidadKg +
                ", consumeBase " + consumeBase +
                ", disponible " + disponible ;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        return matricula.equals(vehiculo.matricula);
    }

    public boolean getDisponible(){
        return true;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
}
