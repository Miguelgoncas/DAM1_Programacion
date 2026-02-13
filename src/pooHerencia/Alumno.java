package pooHerencia;

public class Alumno extends Persona {
                // Con extends estamos herendando todo de Persona
                // Convirtiendolo en su hijo
    private String instituto;
    private double notaMatematica;
    private double notaCastellano;
    private double notaHistoria;

    public Alumno(String nombre, String apellido, String instituto){
        // Usamos Super para llamar al constructor de más arriba, cuando necesitamos atributos que nosotros no tenemos
        super(nombre, apellido);
        this.instituto = instituto;
    }



    public Alumno() {
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaCastellano() {
        return notaCastellano;
    }

    public void setNotaCastellano(double notaCastellano) {
        this.notaCastellano = notaCastellano;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "instituto='" + instituto + '\'' +
                ", notaMatematica=" + notaMatematica +
                ", notaCastellano=" + notaCastellano +
                ", notaHistoria=" + notaHistoria +
                '}';
    }
}
