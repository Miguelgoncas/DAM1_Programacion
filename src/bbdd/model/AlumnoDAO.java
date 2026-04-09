package bbdd.model;

import bbdd.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {

    // Crear alumno

    public void insertarAlumno(Alumno alumno) {

        // Create el comando sql y guardamos en String, query
        String sql = "INSERT INTO alumno (nombre,edad) VALUES (?,?)";

        Connection con = null;

        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();

            // Prepare statement, preparar query, necesario para poder agregar la información

            ps = con.prepareStatement(sql);

            // El 1 representa la primera posición de la cadena sql, la primera interrogación
            ps.setString(1, alumno.getNombre());

            // Aquí representa la segunda interrogación
            ps.setInt(2, alumno.getEdad());

            int filas = ps.executeUpdate(); // Como devuelve un int, guardamos
            System.out.println("Número de filas insertadas = " + filas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public void eliminarAlumno(int id) {
        // Query para borrar fila
        String queryBorrar = "Delete from alumno where id = ?";

        Connection con = null;

        PreparedStatement ps = null;

        try {
            // Realizamos conexión
            con = ConexionBD.getConnection();

            // Preparamos  statement
            ps = con.prepareStatement(queryBorrar);

            // decimos id a eliminar
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            System.out.println("Número de filas borradas = " + filas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    public void actualizarAlumno(Alumno a) {

        String updateSql = "Update alumno set nombre= ? , edad = ? , where id= ? ";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // realizamos conexión y prepare Statement
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(updateSql);

            // Rellenamos primer interrogación
            ps.setString(1, a.getNombre());

            // Segunda interrogación
            ps.setInt(2, a.getEdad());

            // Tercera interrogación
            ps.setInt(3, a.getId());

            int filas = ps.executeUpdate();
            System.out.println("Número de filas actualizadas = " + filas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }


    // Obtener por id
    public Alumno obtenerAlumnoPorID(int id) {
        // Query
        String mostrarSQL = "select * from alumno where id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(mostrarSQL);

            ps.setInt(1, id);

            // Una consulta devuelve un ResultSet

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                // Nombre del nombre que queramos, mismo nombre que la bbdd
                int idalumno = rs.getInt("id");
                String nombreAlumno = rs.getString("nombre");
                int edadAlumno = rs.getInt("edad");

                Alumno alum = new Alumno(idalumno, nombreAlumno, edadAlumno);
                return alum;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new NullPointerException("Error, da nulo") ;
        }  finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public ArrayList<Alumno> obtenerTodosAlumnos(){

        //Creo query
        String obtenerAlumnos = "Select * from alumno";

        // Realizo conexiones
        Connection con = null;
        PreparedStatement ps = null;

        //Creo arrayList
        ArrayList<Alumno> arrAlumno = new ArrayList<Alumno>();

        try {
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(obtenerAlumnos);

            ResultSet rs = ps.executeQuery();

            // Como ahora vamso a trabajar con muchos creamos un while y vamos guardando en array
            while(rs.next()){
                // Nombre del nombre que queramos, mismo nombre que la bbdd
                int idalumno = rs.getInt("id");
                String nombreAlumno = rs.getString("nombre");
                int edadAlumno = rs.getInt("edad");

                Alumno alum = new Alumno(idalumno, nombreAlumno, edadAlumno);

                arrAlumno.add(alum);

            }

            return arrAlumno;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new NullPointerException("Error");
            } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        }

    }


