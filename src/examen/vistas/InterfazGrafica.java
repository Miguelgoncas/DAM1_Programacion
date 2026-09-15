package examen.vistas;

import examen.model.PedidoOnline;
import examen.model.PedidoOnlineDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame implements ActionListener {

    // Creo el panel, botones, inputs
    private JPanel panel;

    private JLabel lblCliente;
    private JLabel lblProducto;
    private JLabel lblPrecio;
    private JLabel lblCantidad;
    private JLabel lblTotal;


    private JTextField txtCliente;
    private JTextField txtProducto;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtTotal;

    private JButton btnInsertar;
    private JButton btnLimpiar;
    private JButton btnBuscar;


    private PedidoOnlineDAO dao = new PedidoOnlineDAO();

    // Creo construstor para poder usarlo desde el main. Le pongo nombre, tamaño e inicio todos los componentes
    public InterfazGrafica() {

        setTitle("Gestión Pedidos");

        setSize(500, 400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {
        // creo el panel
        panel = new JPanel();

        panel.setLayout(null);

        this.add(panel);

        // Creo los diferentes textos y les pongo nombre y tamaño

        lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(50, 50, 100, 30);
        panel.add(lblCliente);

        lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(50, 100, 100, 30);
        panel.add(lblProducto);

        lblPrecio = new JLabel("Precio Unitario:");
        lblPrecio.setBounds(50, 150, 100, 30);
        panel.add(lblPrecio);

        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(50, 200, 100, 30);
        panel.add(lblCantidad);

        lblTotal = new JLabel("Total Pedido:");
        lblTotal.setBounds(50, 250, 100, 30);
        panel.add(lblTotal);


        // Creo los diferentes inputs para poder introducir la información que se solicita
        txtCliente = new JTextField();
        txtCliente.setBounds(200, 50, 200, 30);
        panel.add(txtCliente);

        txtProducto = new JTextField();
        txtProducto.setBounds(200, 100, 200, 30);
        panel.add(txtProducto);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(200, 150, 200, 30);
        panel.add(txtPrecio);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(200, 200, 200, 30);
        panel.add(txtCantidad);

        txtTotal = new JTextField();
        txtTotal.setBounds(200, 250, 200, 30);
        panel.add(txtTotal);

        // Creo los botones necesarios para poder realizar las acciones

        btnInsertar = new JButton("Guardar");
        btnInsertar.setBounds(30, 300, 120, 30);
        btnInsertar.addActionListener(this);
        panel.add(btnInsertar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(180, 300, 120, 30);
        btnLimpiar.addActionListener(this);
        panel.add(btnLimpiar);

        btnBuscar = new JButton("Buscar Por Id");
        btnBuscar.setBounds(330,300,120,30);
        btnBuscar.addActionListener(this);
        panel.add(btnBuscar);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cuando se pulse el botón guardar llegará aquí y se creará e insertará en la base de datos
        if (e.getSource() == btnInsertar) {
            String cliente = txtCliente.getText();
            String producto = txtProducto.getText();
            double precio_unitario = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double total_pedido = Double.parseDouble(txtTotal.getText());

            PedidoOnline pedido = new PedidoOnline(0, cliente, producto, precio_unitario, cantidad, total_pedido);

            dao.insertarPedido(pedido);
            JOptionPane.showMessageDialog(
                    null,
                    "Producto guardado"
            );
        }

        // Cuando se pulse el botón se pondrán todas las casillas en blanco
        if (e.getSource() == btnLimpiar) {
            txtCliente.setText("");
            txtProducto.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
            txtTotal.setText("");
        }


        // Muestra un panel donde te pide id y te muestra su información de la base de datos
        if (e.getSource() == btnBuscar){
            String numeroStr = JOptionPane.showInputDialog(null,"Inserta el ID");
            int numero = 0;
            try{
                numero = Integer.parseInt(numeroStr);
            }catch(NumberFormatException exception){
                throw new NumberFormatException();
            }
            JOptionPane.showMessageDialog(null,dao.obtenerPedidoPorID(numero));
        }


    }
}
