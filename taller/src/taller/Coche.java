package taller;

public class Coche {
    private int contRueda = 0;
    private int contPuerta = 0;

    private String marca;
    private String modelo;
    private Motor motor;
    private Rueda[] ruedas;
    private Puerta[] puertas;

    public Coche(String marca, String modelo, Motor motor, Rueda[] ruedas, Puerta[] puertas){
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.ruedas = ruedas;
        this.puertas = puertas;
    }

    public boolean estaLlenoRuedas() { return contRueda >= ruedas.length;}
    public boolean estaLlenoPuerta() { return contPuerta >= puertas.length; }


    public boolean crearRueda(int pulgadas, int presion){
        if (estaLlenoRuedas() ){
            return false;
        }
        return true;
    }

    public void arrancar(){

        this.motor.encenderMotor();
    }

    public void apagar(){
        this.motor.apagarMotor();

    }

    public boolean isEncendido(){
        return this.motor.isEncendido();
    }

    public String mostrarInfo(){

        String infoR = "";
        for (Rueda rueda : this.ruedas) {
             infoR += (rueda.mostrarInfo() + "\n") ;
        }
        String infoP = "";
        for( Puerta puerta : this.puertas){
             infoP += (puerta.mostrarInfo() + "\n") ;
        }

        return motor.mostrarInfo() + "\n"+ "\n" +  infoR + "\n" + infoP;
    }













    // Getters
    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public Motor getMotor(){
        return this.motor;
    }

    public Rueda[] getRueda(){
        return this.ruedas;
    }

    public Puerta[] getPuerta(){
        return this.puertas;
    }



    // Setters
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setMotor(Motor motor){
        this.motor = motor;
    }

    public void setRuedas(Rueda[] ruedas){
        this.ruedas = ruedas;
    }

    public void setPuertas(Puerta[] puerta){
        this.puertas = puerta;
    }
}
