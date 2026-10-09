package ficheros.repasoGeneral.serializable;

import java.io.*;
import java.util.ArrayList;

public class Lectura_Objetos {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\repasoGeneral\\serializable\\";
        File f = new File(ruta, "producto.dat");

        // Lectura binario
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0 ) {
                Producto p;
                p = (Producto) ois.readObject();
                System.out.println(p.toString());

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
