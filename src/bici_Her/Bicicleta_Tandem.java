package bici_Her;

public class Bicicleta_Tandem extends Bicicleta{
    private int numAsientos;


    public Bicicleta_Tandem(int velocidadActual,int pinonActual, int platoActual, int numAsientos){
        super(velocidadActual,pinonActual,platoActual);
        this.numAsientos = numAsientos;
    }


    public void acelerar(){
        setVelocidadActual(getVelocidadActual()*4);
    }
    public Bicicleta_Tandem(int numAsientos){
        super(); // Llamamos al constructor del Padre que no tiene argumentos de entrada
        this.numAsientos = numAsientos;
    }

    public  Bicicleta_Tandem(int velocidadActual,int pinonActual,int numAsientos){
        super(velocidadActual, pinonActual); // Así estamos llamando al constructor que tiene estos dos
        // valores de entrada
        this.numAsientos = numAsientos;
    }
}
