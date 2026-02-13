package pooHerencia;

public class EjemploHerencia {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();

        /* observamos que .setNombre y apellidos son getter y setter definidos en
            la clase padre, pero los estamos usando en la clase hija.
         */
        
        alumno.setNombre("Andres");
        alumno.setApellido("Guzman");

        Profesor profesor = new Profesor();
        profesor.setNombre("Miguel");
        profesor.setApellido("González");
        profesor.setAsignatura("Matemáticas");

        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor" + profesor.getNombre() +
                profesor.getAsignatura());
                
         
        
        
        
        
        Alumno alumnoSuper = new Alumno("Carlos",  "Super", "Fuentezuelas");
        System.out.println("alumnoSuper = " + alumnoSuper);
        alumnoSuper.saltar();
    }
}
