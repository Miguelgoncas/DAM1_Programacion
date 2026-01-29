public class Motor {
    // Declaramos atributos

    private int cilindrada;
    private int caballos;
    private boolean encendido;

    // Declaramos constructor
    public Motor(int cilindrada, int caballos){
        this.cilindrada = cilindrada;
        this.caballos = caballos;
    }



    public String mostrarInfo(){
        return "Motor: " + this.cilindrada + "cc - " + this.caballos + "CV - Encendido: " + (isEncendido() ? "Sí" : "No");
    }


    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }

    public void setCaballos(int caballos){
        this.caballos = caballos;
    }
    public int getCaballos() {
        return caballos;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void encenderMotor(){
        this.encendido = true;
    }

    public void apagarMotor(){
        this.encendido = false;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}
