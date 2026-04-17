package bbddEjercicio.model;

import bbddEjercicio.util.ConexionBaseDatos;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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

            return ps.executeUpdate();

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

                return new Producto(idProducto,nombreProducto,precioProducto,stockProducto);
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

    public int  actualizarProducto(int id, String nombre, double precio, int stock){
        // Query
        String updateProducto = "Update producto set nombre= ?, precio = ?, stock= ? where id = ?" ;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBaseDatos.getConnection();
            ps = con.prepareStatement(updateProducto);
            Producto pro = obtenerProductoID(id);

            ps.setString(1, nombre);
            ps.setDouble(2,precio);
            ps.setInt(3,stock);
            ps.setInt(4,id);

            return ps.executeUpdate();

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
        // Creo query
        String queryBorrar = "Delete from producto where id = ?";

        Connection con = null;

        PreparedStatement ps = null;

        try {
            // Realizamos conexión
            con = ConexionBaseDatos.getConnection();
            ps = con.prepareStatement(queryBorrar);

            // Le damos el id que queramos borrar

            ps.setInt(1,id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Creo metodo para meter los productos del fichero en la BBDD
    public int cargaficheroProductos(){
        // Creo la query
        String insertarPro = "Insert into producto (nombre,precio,stock) VALUES (?,?,?)";


        Connection con = null;

        PreparedStatement ps = null;
        LecturaFichero lf = new LecturaFichero();

        // Creo un HashSet y le meto la información del archivo gracias al metodo creado
        HashSet<Producto> hProducto = new HashSet<>(lf.leerArchivo());

        try {
             con = ConexionBaseDatos.getConnection();
             ps = con.prepareStatement(insertarPro);


            Iterator<Producto> it = hProducto.iterator();
            while(it.hasNext()){
                Producto p = it.next();
                ps.setString(1,p.getNombre());
                ps.setDouble(2,p.getPrecio());
                ps.setInt(3,p.getStock());
                return ps.executeUpdate();
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


        return 0;
    }




    }




