package examen.model;

import examen.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoOnlineDAO {

    static final ArrayList<PedidoOnline> pedidos = new ArrayList<>();

    // Creo un metodo con la query para insertar un pedido en la base de datos
    public void insertarPedido(PedidoOnline pedido) {
        String insertSql = "INSERT INTO pedido_online (cliente,producto,precio_unitario,cantidad,total_pedido) VALUES (?,?,?,?,?)";

        Connection con = null;

        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();

            ps = con.prepareStatement(insertSql);


            ps.setString(1,pedido.getCliente());
            ps.setString(2, pedido.getProducto());
            ps.setDouble(3, pedido.getPrecio_unitario());
            ps.setInt(4,pedido.getCantidad());
            ps.setDouble(5,pedido.getTotal_pedido());


            int filas = ps.executeUpdate();
            //System.out.println("Número de filas insertadas = " + filas);
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

    // Creo un metodo con la query para obtener los pedidos
    public ArrayList<PedidoOnline> obtenerPedido() {

        String mostrarSQL = "select * from pedido_online;";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(mostrarSQL);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String cliente = rs.getString("cliente");
                String producto = rs.getString("producto");
                double precio_unitario = rs.getDouble("precio_unitario");
                int cantidad = rs.getInt("cantidad");
                double total_pedido = rs.getDouble("total_pedido");

                PedidoOnline ped = new PedidoOnline(id, cliente, producto, precio_unitario,
                        cantidad, total_pedido);

                pedidos.add(ped);
            }
            return pedidos;

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

    }

    // Creo metodo para actualizar pedido mediante id
    public PedidoOnline actualizarPedidoOnline(int idActualizar){
        String actualizarPorId = "Update pedido_online where id = ?;";


        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(actualizarPorId);

            ps.setInt(1,idActualizar);

            ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String cliente = rs.getString("cliente");
                    String producto = rs.getString("producto");
                    double precio_unitario = rs.getDouble("precio_unitario");
                    int cantidad = rs.getInt("cantidad");
                    double total_pedido = rs.getDouble("total_pedido");

                    PedidoOnline ped = new PedidoOnline(id, cliente, producto, precio_unitario,
                            cantidad, total_pedido);

                    return ped;
                }


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

        return null;

    }

    // Creo metodo para eliminar pedido mediante id
    public boolean eliminarPedidoOnline(int idEliminar){
        String eliminarPorId = "Delete from pedido_online where id = ?;";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(eliminarPorId);

            ps.setInt(1,idEliminar);

            int filasEliminadas = ps.executeUpdate();

            return filasEliminadas > 0;

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


    // Creo metodo para obtener mediante id
    public PedidoOnline obtenerPedidoPorID(int idBuscar) {
        String mostrarPorIdSQL = "select * from pedido_online where id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConexionBD.getConnection();
            ps = con.prepareStatement(mostrarPorIdSQL);

            ps.setInt(1, idBuscar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String cliente = rs.getString("cliente");
                String producto = rs.getString("producto");
                double precio_unitario = rs.getDouble("precio_unitario");
                int cantidad = rs.getInt("cantidad");
                double total_pedido = rs.getDouble("total_pedido");

                PedidoOnline ped = new PedidoOnline(id, cliente, producto, precio_unitario,
                        cantidad, total_pedido);

                return ped;
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
}





