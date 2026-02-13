package bici_Her;

public class Bicicleta {
    //declaro atributos de la clase
    private int velocidadActual;
    private int pinonActual;
    private int platoActual;

    //creo constructores
    public Bicicleta(int velocidadActual, int pinonActual, int platoActual) {
        this.velocidadActual = velocidadActual;
        this.pinonActual = pinonActual;
        this.platoActual = platoActual;
    }

    public Bicicleta() {
        this.velocidadActual = 0;
        this.pinonActual = 1;
        this.platoActual = 1;
    }

    public Bicicleta(int velocidadActual, int pinonActual) {
        this.velocidadActual = velocidadActual;
        this.pinonActual = pinonActual;

    }


    public Bicicleta(String pinonactual, int nombre) {
        this.velocidadActual = velocidadActual;


    }

    public void acelerar() {
        this.velocidadActual = this.velocidadActual*2;
    }

    public void frenar() {
        this.velocidadActual = this.velocidadActual/2;
    }

    public void cambiarPlato(int plato) {
        this.platoActual = plato;
    }

    //sobrecarga de métodos
    public void cambiarPlato() {
        this.platoActual = 1;
    }

    public void cambiarPinon(int pinon) {
        this.pinonActual = pinon;
    }
    //sobrecarga de métodos
    public void cambiarPinon() {
        this.pinonActual = 1;
    }


    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getVelocidadActual() {
        return this.velocidadActual;
    }

    public void setPinonActual(int pinonActual) {
        this.pinonActual = pinonActual;
    }

    public int getPinonActual() {
        return this.pinonActual;
    }

    public void setPlatoActual(int platoActual) {
        this.platoActual = platoActual;
    }

    public int getPlatoActual() {
        return this.platoActual;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "velocidadActual=" + velocidadActual +
                ", pinonActual=" + pinonActual +
                ", platoActual=" + platoActual +
                '}';
    }
}
