package bici_Her;

public class Bicicleta_Montania  extends Bicicleta{
    private int suspension;

    public Bicicleta_Montania(int velocidadActual,int pinonActual, int platoActual,int suspension){
        super(velocidadActual,pinonActual,platoActual);
        this.suspension = suspension;
    }


    public void cambiarSuspension(int suspension){
        this.suspension = suspension;
    }
    public void acelerar(){
         setVelocidadActual(getVelocidadActual()*3);
    }


    @Override
    public String toString() {
        return super.toString() + "Bicicleta_Montania{" +
                "suspension=" + suspension +
                '}';
    }
}
