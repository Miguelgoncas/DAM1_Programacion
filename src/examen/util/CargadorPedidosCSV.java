package examen.util;

import examen.model.PedidoOnline;
import examen.model.PedidoOnlineDAO;

import java.io.*;
import java.util.ArrayList;

public class CargadorPedidosCSV {
    static final String RUTA = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\examen\\";
    static final File FICHEROCSV = new File(RUTA + "pedidos.csv");
    static final String SEPARATOR = ";";
    static final PedidoOnlineDAO pedDao = new PedidoOnlineDAO();

    public CargadorPedidosCSV() {

    }
    public void leerFicheroCSV() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(FICHEROCSV);
            br = new BufferedReader(fr);
            String linea;

            int id = 0;
            ArrayList<PedidoOnline> pedidos = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(SEPARATOR);

                String cliente = datos[0];
                String producto = datos[1];
                double precio_unitario = Double.parseDouble(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                double total_pedido = Double.parseDouble(datos[4]);

                PedidoOnline pedido = new PedidoOnline(id,cliente, producto, precio_unitario, cantidad, total_pedido);
                id++;

                pedidos.add(pedido);

                insertarPedido(pedido);
            }
            pedidos.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void insertarPedido(PedidoOnline pedido) {
        pedDao.insertarPedido(pedido);
    }

}
