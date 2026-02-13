package pooHerencia;

public class Animal {
    private String nombre;
    private boolean vivo;

    public Animal(){
    }

    public Animal(String nombre){
        this.nombre = nombre;
    }


    public void saltar(){
        System.out.println("Boing");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
