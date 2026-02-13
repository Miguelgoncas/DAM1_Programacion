package pooHerencia;

public class Persona extends Animal{
    private String apellido;
    private int edad;
    private String email;

    public Persona() {
        super();
    }

    public Persona(String nombre, String apellido) {
        super(nombre);
        this.apellido = apellido;
    }

    public void andar(){

    }



    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nombre='" + getNombre() + '\'' + super.toString();

    }


}
