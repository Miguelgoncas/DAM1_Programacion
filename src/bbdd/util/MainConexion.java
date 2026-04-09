package bbdd.util;

import bbdd.model.Alumno;
import bbdd.model.AlumnoDAO;

import java.util.ArrayList;

public class MainConexion {
    public static void main(String[] args) {

        // Creamos alumnoDAO para poder manejar las acciones de sql
        AlumnoDAO alumDAO = new AlumnoDAO();
        Alumno a1 = new Alumno("Luis", 45);
        Alumno a2 = new Alumno(4, "Gabri", 22);



        // Creamos alumno e insertamos en sql
        //alumDAO.insertarAlumno(a1);

        //alumDAO.insertarAlumno(a2);

        // borramos alumno
        //alumDAO.eliminarAlumno(6);

        // Para actualizar necesitamos el id, y este no tiene, deberiamos primer hacer consulta
        //alumDAO.actualizarAlumno(a1);


        int idABuscar = 7;
        if (alumDAO.obtenerAlumnoPorID(idABuscar) != null) {
            System.out.println(alumDAO.obtenerAlumnoPorID(idABuscar).toString());
        } else {
            System.out.println("Error, el registro podría no existir");
        }


        if(alumDAO.obtenerTodosAlumnos() != null){
            ArrayList<Alumno> arrAl = new ArrayList<Alumno>();
            arrAl.addAll(alumDAO.obtenerTodosAlumnos());

            System.out.println(arrAl.toString() );
        } else {
            System.out.println("Error, puede no haber registros");
        }

    }
}
