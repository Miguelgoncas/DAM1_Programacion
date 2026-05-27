package swing;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    // INSERTAR PRODUCTO
    public void insertarProducto(Producto producto) {

        String sql =
                "INSERT INTO productos(nombre, precio) VALUES (?, ?)";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());

            ps.executeUpdate();

            System.out.println("Producto insertado");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // MOSTRAR PRODUCTOS
    public void mostrarProductos() {

        String sql = "SELECT * FROM productos";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " - "
                                + rs.getString("nombre")
                                + " - "
                                + rs.getDouble("precio")
                );
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // BUSCAR PRODUCTO
    public void buscarProducto(String nombre) {

        String sql =
                "SELECT * FROM productos WHERE nombre = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getString("nombre")
                                + " - "
                                + rs.getDouble("precio")
                );

            } else {

                System.out.println("Producto no encontrado");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
