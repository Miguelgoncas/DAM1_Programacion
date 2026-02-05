public class Alumno {
    private String nombre;
    private String dni;
    private int tam = 5;
    private Nota[] notas = new Nota[tam];
    private int contNotas = 0;

    public Alumno(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;

    }


    public boolean setNotas(String nombreModulo, double calificacion){

        if(contNotas < notas.length) {
            Nota n1 = new Nota(nombreModulo, calificacion);
            notas[contNotas] = n1;
            contNotas++;
        }
        return false;
    }

    public double media(){
        double med = 0;
        for(Nota nota : notas){
            if(notas != null){
                med += nota.getCalificacion();
            }
            return med;
        }
        return med;
    }

    public String mostrarInfo(){
        String not = "";
        if(notas != null) {
            for (Nota nota : notas) {
                if(notas != null)
                    not += "El alumno: " + this.nombre + " tiene unas notas de: " + nota.getNombreModulo() + ": " + nota.getCalificacion();
            }
        }
        return null;
    }


    public String getNombre(){
        return this.nombre;
    }
    public String getDni(){
        return this.dni;
    }





}
