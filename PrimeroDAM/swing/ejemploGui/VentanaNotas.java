package swing.ejemploGui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Ventana principal de la aplicación de notas.
 *
 * Extiende JFrame → ya ES una ventana. Cada cosa que añadas
 * al JFrame aparece dentro de esa ventana.
 *
 * Componentes usados:
 *   JLabel       → texto estático (etiqueta)
 *   JTextField   → caja de texto donde el usuario escribe
 *   JButton      → botón clicable
 *   JTable       → tabla de filas y columnas
 *   JScrollPane  → añade scroll a otro componente (aquí a la tabla)
 *   JOptionPane  → ventanas emergentes (alert, confirm, input)
 *
 * Layout managers (cómo se colocan los componentes):
 *   BorderLayout → divide en NORTH, SOUTH, EAST, WEST, CENTER
 *   GridLayout   → rejilla de filas×columnas (todas iguales)
 *   FlowLayout   → los pone en fila, uno detrás de otro
 */
public class VentanaNotas extends JFrame {

    // ── Componentes de entrada ──────────────────────────────────────────────
    private JTextField txtNombre;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;

    // ── Botones ─────────────────────────────────────────────────────────────
    private JButton btnAñadir;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    // ── Tabla ───────────────────────────────────────────────────────────────
    private JTable tabla;
    private DefaultTableModel modeloTabla; // gestiona los datos de la tabla

    // ── Etiqueta de media general ────────────────────────────────────────────
    private JLabel lblMedia;

    public VentanaNotas() {
        configurarVentana();
        construirFormulario();
        construirTabla();
        construirBotones();
        conectarEventos();
    }

    // ────────────────────────────────────────────────────────────────────────
    // 1. CONFIGURACIÓN BASE DE LA VENTANA
    // ────────────────────────────────────────────────────────────────────────
    private void configurarVentana() {
        setTitle("Registro de Notas");
        setSize(600, 450);
        setLocationRelativeTo(null);       // centra la ventana en pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE); // cierra la app al cerrar la ventana

        /*
         * BorderLayout: el layout por defecto de JFrame.
         * Divide el espacio en 5 zonas:
         *
         *   +──────────────────+
         *   |      NORTH       |
         *   +──────────────────+
         *   | WEST | CENTER | EAST |
         *   +──────────────────+
         *   |      SOUTH       |
         *   +──────────────────+
         */
        setLayout(new BorderLayout(10, 10));
    }

    // ────────────────────────────────────────────────────────────────────────
    // 2. FORMULARIO DE ENTRADA (zona NORTH)
    // ────────────────────────────────────────────────────────────────────────
    private void construirFormulario() {
        /*
         * JPanel: contenedor sin decoración. Agrupa componentes.
         * GridLayout(filas, columnas): coloca todo en una rejilla.
         * Aquí: 2 filas × 4 columnas → etiquetas arriba, campos abajo.
         */
        JPanel panelFormulario = new JPanel(new GridLayout(2, 4, 8, 4));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del alumno"));

        // Fila 1: etiquetas
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(new JLabel("Nota 1:"));
        panelFormulario.add(new JLabel("Nota 2:"));
        panelFormulario.add(new JLabel("Nota 3:"));

        // Fila 2: campos de texto
        txtNombre = new JTextField();
        txtNota1  = new JTextField();
        txtNota2  = new JTextField();
        txtNota3  = new JTextField();

        panelFormulario.add(txtNombre);
        panelFormulario.add(txtNota1);
        panelFormulario.add(txtNota2);
        panelFormulario.add(txtNota3);

        // Añadimos el panel al NORTH del JFrame
        add(panelFormulario, BorderLayout.NORTH);
    }

    // ────────────────────────────────────────────────────────────────────────
    // 3. TABLA (zona CENTER)
    // ────────────────────────────────────────────────────────────────────────
    private void construirTabla() {
        /*
         * DefaultTableModel: el "modelo" que almacena los datos de la tabla.
         * La tabla (JTable) solo es la vista; el modelo guarda los datos.
         * Pasamos los nombres de las columnas y 0 filas iniciales.
         */
        String[] columnas = {"Nombre", "Nota 1", "Nota 2", "Nota 3", "Media"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            // Hacemos las celdas no editables directamente en la tabla
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        tabla = new JTable(modeloTabla);
        tabla.setRowHeight(24);
        tabla.getTableHeader().setReorderingAllowed(false); // no se pueden reordenar columnas

        /*
         * JScrollPane: envuelve la tabla para que aparezca la barra de scroll
         * cuando hay muchas filas. Sin él, la cabecera tampoco se vería.
         */
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
    }

    // ────────────────────────────────────────────────────────────────────────
    // 4. BOTONES Y PIE (zona SOUTH)
    // ────────────────────────────────────────────────────────────────────────
    private void construirBotones() {
        /*
         * FlowLayout: coloca los componentes en fila de izquierda a derecha.
         * Es el layout por defecto de los JPanel.
         */
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));

        btnAñadir   = new JButton("Añadir alumno");
        btnEliminar = new JButton("Eliminar seleccionado");
        btnLimpiar  = new JButton("Limpiar todo");

        lblMedia = new JLabel("Media general: —");
        lblMedia.setFont(lblMedia.getFont().deriveFont(Font.BOLD));

        panelSur.add(btnAñadir);
        panelSur.add(btnEliminar);
        panelSur.add(btnLimpiar);
        panelSur.add(Box.createHorizontalStrut(30)); // espacio vacío
        panelSur.add(lblMedia);

        add(panelSur, BorderLayout.SOUTH);
    }

    // ────────────────────────────────────────────────────────────────────────
    // 5. EVENTOS (qué pasa cuando el usuario interactúa)
    // ────────────────────────────────────────────────────────────────────────
    private void conectarEventos() {
        /*
         * addActionListener recibe una interfaz funcional (ActionListener).
         * En vez de crear una clase anónima, usamos lambda: e -> { ... }
         * donde 'e' es el ActionEvent (contiene info del evento).
         */
        btnAñadir.addActionListener(e -> añadirAlumno());
        btnEliminar.addActionListener(e -> eliminarAlumno());
        btnLimpiar.addActionListener(e -> limpiarTabla());

        /*
         * MouseListener sobre la tabla: al hacer doble clic en una fila,
         * mostramos los datos de ese alumno en un JOptionPane.
         */
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    mostrarDetalleAlumno();
                }
            }
        });

        setVisible(true); // mostramos la ventana al final, cuando todo está listo
    }

    // ────────────────────────────────────────────────────────────────────────
    // 6. LÓGICA DE LOS BOTONES
    // ────────────────────────────────────────────────────────────────────────

    private void añadirAlumno() {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            // JOptionPane.showMessageDialog → ventana emergente de información
            JOptionPane.showMessageDialog(this,
                    "El nombre no puede estar vacío.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double n1 = Double.parseDouble(txtNota1.getText().trim());
            double n2 = Double.parseDouble(txtNota2.getText().trim());
            double n3 = Double.parseDouble(txtNota3.getText().trim());

            if (n1 < 0 || n1 > 10 || n2 < 0 || n2 > 10 || n3 < 0 || n3 > 10) {
                JOptionPane.showMessageDialog(this,
                        "Las notas deben estar entre 0 y 10.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double media = (n1 + n2 + n3) / 3.0;

            // addRow añade una nueva fila al modelo; la tabla se actualiza sola
            modeloTabla.addRow(new Object[]{
                nombre,
                String.format("%.1f", n1),
                String.format("%.1f", n2),
                String.format("%.1f", n3),
                String.format("%.2f", media)
            });

            limpiarCampos();
            actualizarMediaGeneral();
            txtNombre.requestFocus(); // pone el cursor en el campo nombre

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Las notas deben ser números válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarAlumno() {
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un alumno de la tabla primero.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 0);

        /*
         * JOptionPane.showConfirmDialog → ventana de confirmación (Sí / No).
         * Devuelve JOptionPane.YES_OPTION si el usuario pulsa "Sí".
         */
        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Eliminar al alumno \"" + nombre + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
            actualizarMediaGeneral();
        }
    }

    private void limpiarTabla() {
        if (modeloTabla.getRowCount() == 0) return;

        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Eliminar todos los alumnos?",
                "Limpiar tabla",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            // setRowCount(0) borra todas las filas del modelo
            modeloTabla.setRowCount(0);
            lblMedia.setText("Media general: —");
        }
    }

    private void mostrarDetalleAlumno() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) return;

        String nombre = (String) modeloTabla.getValueAt(fila, 0);
        String media  = (String) modeloTabla.getValueAt(fila, 4);
        double mediaNum = Double.parseDouble(media.replace(",", "."));

        String estado = mediaNum >= 5 ? "APROBADO" : "SUSPENSO";

        /*
         * JOptionPane.showMessageDialog con HTML: Swing acepta HTML básico
         * en las etiquetas para dar formato al texto.
         */
        JOptionPane.showMessageDialog(this,
                "<html><b>" + nombre + "</b><br>" +
                "Media: " + media + "<br>" +
                "Estado: <b>" + estado + "</b></html>",
                "Detalle del alumno",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // ────────────────────────────────────────────────────────────────────────
    // 7. MÉTODOS AUXILIARES
    // ────────────────────────────────────────────────────────────────────────

    private void limpiarCampos() {
        txtNombre.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
    }

    private void actualizarMediaGeneral() {
        int filas = modeloTabla.getRowCount();
        if (filas == 0) {
            lblMedia.setText("Media general: —");
            return;
        }

        double suma = 0;
        for (int i = 0; i < filas; i++) {
            String mediaStr = (String) modeloTabla.getValueAt(i, 4);
            suma += Double.parseDouble(mediaStr.replace(",", "."));
        }

        lblMedia.setText(String.format("Media general: %.2f", suma / filas));
    }
}
