public class Curso {
    private String nombre;
    private String tutor;
    private int tam = 5;
    private Modulo[] modulos= new Modulo[tam];
    private Alumno[] alumnos = new Alumno[tam];
    private int contModulo = 0;
    private int contAlumno = 0;

    public Curso(String nombre, String tutor){
        this.nombre = nombre;
        this.tutor = tutor;
    }


    public boolean hayAlumnos(){
        return contAlumno > 0;
    }

    public Modulo buscarModulo(String nombre){
        for(Modulo modulo: modulos){
            if(modulo != null && modulo.getNombre().equalsIgnoreCase(nombre)){
                return modulo;
            }
        }
        return null;
    }

    public boolean agregarModulo(Modulo modulo){
        if(contModulo < modulos.length){
            modulos[contModulo] = modulo;
            contModulo++;
            return true;
        }
        return false;
    }

    public String listarModulos(){
        String mod = "";
        for(Modulo modulo : modulos){
            if(modulo != null)
            mod += modulo.getNombre() + "\n";
        }
        return mod;
    }


    public boolean matricularAlumno(Alumno alum){
        if(contAlumno < alumnos.length){
            alumnos[contAlumno] = alum;
            contAlumno++;
            return true;
        }
        return false;
    }

    public String listarAlumnos(){
        String alum = "";
        for(Alumno alumno : alumnos){
            if(alumno != null)
           alum += "Alumno: " +  alumno.getNombre() + " DNI: " + alumno.getDni() + "\n" ;
        }
        return alum;
    }


    public Alumno buscarAlumno(String dni){
        if(alumnos !=null){
            for(Alumno alumnos : this.alumnos){
                if(alumnos.getDni().equals(dni)){
                    return alumnos;
                }
            }
        }
        return null;
    }
}
