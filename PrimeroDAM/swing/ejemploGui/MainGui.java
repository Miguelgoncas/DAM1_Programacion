package swing.ejemploGui;

import javax.swing.SwingUtilities;

public class MainGui {


    public static void main(String[] args) {
        /*
         * SwingUtilities.invokeLater() garantiza que la ventana se cree
         * en el hilo de eventos de Swing (Event Dispatch Thread).
         * SIEMPRE hay que arrancar ventanas Swing así para evitar bugs.
         */
        SwingUtilities.invokeLater(() -> new VentanaNotas());
    }
}
