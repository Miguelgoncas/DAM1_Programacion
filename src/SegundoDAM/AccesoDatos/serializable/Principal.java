package SegundoDAM.AccesoDatos.serializable;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        // Escritura de objetos en ficheros

        // Iniciamos el serializador de objetos para meterlo en archivo
         ObjectOutputStream serializador = null;

        // Creamos una lista de productos
        List<Producto> listaProductos = new ArrayList<Producto>();


        // Añadimos productos
        listaProductos.add(new Producto("Platano", 0.50F));
        listaProductos.add(new Producto("Manzana", 0.25F));
        listaProductos.add(new Producto("Helado", 2.20F));

        // Creo fichero binario
        File pro = new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\serializable\\productos.dat");

        try {
            // Inicializo serialiador con FileInputStream
            serializador = new ObjectOutputStream(new FileOutputStream(pro));
            // Uso el metodo de writeObject
            serializador.writeObject(listaProductos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serializador.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        // Ahora leemos el archivo y sus objetos, Deserializar.
        List<Producto> listaProductos2 = new ArrayList<Producto>();

        ObjectInputStream deserializador = null;

        try {
            // Creamos el deserializador y lo iniciamos con un FileInputStream
            deserializador = new ObjectInputStream(new FileInputStream(pro));
            // Hacemos casting y lo metemos en la nueva lista
            listaProductos2 = (List<Producto>) deserializador.readObject();

            for ( int i = 0 ; i < listaProductos2.size(); i++){
                JOptionPane.showMessageDialog(null, listaProductos2.get(i).toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                deserializador.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
