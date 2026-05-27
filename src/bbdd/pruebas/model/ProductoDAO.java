package bbdd.pruebas.model;

import bbdd.pruebas.util.ConexionBDP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAO {

    public ProductoDAO(){

    }
    public void insertarAlumno(Producto producto) {

        // Create el comando sql y guardamos en String, query
        String sql = "INSERT INTO producto (nombre,stock,precio) VALUES (?,?,?)";

        Connection con = null;


        PreparedStatement ps = null;

        try {
            con = ConexionBDP.getConnection();

            // Prepare statement, preparar query, necesario para poder agregar la información

            ps = con.prepareStatement(sql);

            // El 1 representa la primera posición de la cadena sql, la primera interrogación
            ps.setString(1, producto.getNombre());

            // Aquí representa la segunda interrogación
            ps.setInt(2, producto.getStock());

            ps.setDouble(3,producto.getPrecio());

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
}
