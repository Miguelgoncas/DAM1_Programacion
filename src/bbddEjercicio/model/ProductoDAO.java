package bbddEjercicio.model;

import bbddEjercicio.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

    public int insertarProducto(Producto pro){
        // Creo la query
        String insertarPro = "Insert into producto (nombre,precio,stock) VALUES (?,?,?)";

        // Inicializo a null
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBaseDatos.getConnection();
            ps = con.prepareStatement(insertarPro);

            // Vamos sacando la información del Producto e insertamos

            ps.setString(1, pro.getNombre());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3,pro.getStock());

            // Guardamos en variable y devolvemos
            int filas = 0;
            return filas = ps.executeUpdate();

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


    public ArrayList<Producto> obtenerProductos(){

        // Query
        String obtenerTodos = "select * from producto";

        // Conexiones
        Connection con = null;
        PreparedStatement ps = null;

        // Creo arrayList
        ArrayList<Producto> arrProducto = new ArrayList<Producto>();

        try{

            con = ConexionBaseDatos.getConnection();
            ps = con.prepareStatement(obtenerTodos);

            // Creamos ResultSet para almacenar información

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                // Guardamos la información en variables para luego almacenar
                int idProducto = rs.getInt("id");
                String nombreProducto = rs.getString("nombre");
                double precioProducto = rs.getDouble("precio");
                int stockProducto = rs.getInt("stock");

                Producto prod = new Producto(idProducto,nombreProducto,precioProducto,stockProducto);
                arrProducto.add(prod);
            }
            return arrProducto;

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


    public Producto obtenerProductoID(int id){
        // Query

        String obtenerPorId = "select * from producto where id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = ConexionBaseDatos.getConnection();
            ps = con.prepareStatement(obtenerPorId);

            ps.setInt(1,id);

            // Creamos ResultSet para almacenar la información

            ResultSet rs = ps.executeQuery();

            if( rs.next()){
                // Vamos guardando
                int idProducto = rs.getInt("id");
                String nombreProducto = rs.getString("nombre");
                double precioProducto = rs.getDouble("precio");
                int stockProducto = rs.getInt("stock");

                Producto prod = new Producto(idProducto,nombreProducto,precioProducto,stockProducto);
                return prod;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public int  actualizarProducto(int id){
        // Query
        String updateProducto = "Update producto set nombre= ?, precio = ?, stock= ?" ;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBaseDatos.getConnection();
            ps = con.prepareStatement(updateProducto);
            Producto pro = obtenerProductoID(id);

            ps.setString(1, pro.getNombre());
            ps.setDouble(2,pro.getPrecio());
            ps.setInt(3,pro.getStock());

            int filas = ps.executeUpdate();
            return filas;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try{
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int eliminarProducto(int id) {

        return 0;
    }







}
