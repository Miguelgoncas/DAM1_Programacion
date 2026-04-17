package bbddEjercicio.model;

import java.io.*;
import java.util.HashSet;

public class LecturaFichero {

    // Creo metodo para lectura del archivo
    public HashSet<Producto> leerArchivo() {
        // Creo HashSet y FileInputStream y ObjectInputStream
        HashSet<Producto> hsProducto = new HashSet<>();

        // Creo la ruta para la lectura del .dat
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\bbddEjercicio";
        File f = new File(ruta,"productos_100.dat");

        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0) {
                Producto p;
                p = ((Producto) ois.readObject());
                hsProducto.add(p);
            }
            // Devuelvo HashSet
            return hsProducto;

        } catch (FileNotFoundException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
