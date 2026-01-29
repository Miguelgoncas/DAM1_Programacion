package taller;

public class Rueda {
    private int pulgadas;
    private double presion;

    public Rueda(int pulgadas, double presion){
        this.pulgadas = pulgadas;
        this.presion = presion;
    }

    public void inflar(double cantidad){
        this.presion += cantidad;
    }

    public void desinflar(double cantidad){
        this.presion -= cantidad;
    }

    public String mostrarInfo(){
        return "taller.Rueda " + this.pulgadas + "\" - Presión: " + this.presion ;
    }
}
