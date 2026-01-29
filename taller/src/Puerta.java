public class Puerta {
    private String posicion;
    private boolean abierta;

    public Puerta(String posicion){
        this.posicion = posicion;
    }

    public void abrir(){
        this.abierta = true;
    }
    public void cerrar(){
        this.abierta = false;
    }

    public boolean isAbierta(){
        return abierta;
    }


    public String mostrarInfo(){
        return this.posicion + ": " + (this.isAbierta() ? "Abierta" : "Cerrada");
    }
}
