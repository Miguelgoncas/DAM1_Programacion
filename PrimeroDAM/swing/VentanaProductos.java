package swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaProductos extends JFrame
        implements ActionListener {

    private JPanel panel;

    private JLabel lblNombre;
    private JLabel lblPrecio;


    private JTextField txtNombre;
    private JTextField txtPrecio;

    private JButton btnGuardar;
    private JButton btnMostrar;


    private ProductoDAO dao = new ProductoDAO();

    public VentanaProductos() {

        setTitle("Gestión Productos");

        setSize(500, 400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        this.add(panel);

        // LABELS
        lblNombre = new JLabel("Nombre");

        lblNombre.setBounds(30, 30, 100, 30);

        panel.add(lblNombre);

        lblPrecio = new JLabel("Precio");

        lblPrecio.setBounds(30, 70, 100, 30);

        panel.add(lblPrecio);

        // TEXTFIELDS
        txtNombre = new JTextField();

        txtNombre.setBounds(120, 30, 150, 30);

        panel.add(txtNombre);

        txtPrecio = new JTextField();

        txtPrecio.setBounds(120, 70, 150, 30);

        panel.add(txtPrecio);

        // BOTONES
        btnGuardar = new JButton("Guardar");

        btnGuardar.setBounds(30, 130, 120, 40);

        btnGuardar.addActionListener(this);

        panel.add(btnGuardar);

        btnMostrar = new JButton("Mostrar");

        btnMostrar.setBounds(170, 130, 120, 40);

        btnMostrar.addActionListener(this);

        panel.add(btnMostrar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // BOTÓN GUARDAR
        if (e.getSource() == btnGuardar) {

            String nombre = txtNombre.getText();

            double precio =
                    Double.parseDouble(txtPrecio.getText());

            Producto producto =
                    new Producto(nombre, precio);

            dao.insertarProducto(producto);

            JOptionPane.showMessageDialog(
                    null,
                    "Producto guardado"
            );
        }


    }
}