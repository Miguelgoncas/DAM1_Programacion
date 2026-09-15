package examen.model;

public class PedidoOnline {
    // Creo clase de PedidoOnline con sus atributos y getters and setters
    private int id;
    private String cliente;
    private String producto;
    private double precio_unitario;
    private int cantidad;
    private double total_pedido;

    public PedidoOnline(int id, String cliente, String producto, double precio_unitario, int cantidad, double total_pedido) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.total_pedido = total_pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }

    @Override
    public String toString() {
        return "PedidoOnline " +
                "id " + id +
                ", cliente " + cliente + '\'' +
                ", producto " + producto + '\'' +
                ", precio unitario " + precio_unitario +
                ", cantidad " + cantidad +
                ", total_pedido " + total_pedido;
    }
}
