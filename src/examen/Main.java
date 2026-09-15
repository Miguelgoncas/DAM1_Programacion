package examen;

import examen.util.CargadorPedidosCSV;
import examen.vistas.InterfazGrafica;

public class Main {
    public static void main(String[] args) {

        CargadorPedidosCSV cp = new CargadorPedidosCSV();

        // Leo, muestro por pantalla y añado los pedidos a la base de datos
        cp.leerFicheroCSV();

        // Inicio la interfaz gráfica
        new InterfazGrafica();

    }
}
