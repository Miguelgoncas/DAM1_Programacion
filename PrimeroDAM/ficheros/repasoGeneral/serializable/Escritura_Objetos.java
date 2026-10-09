package ficheros.repasoGeneral.serializable;

import java.io.*;

public class Escritura_Objetos {
    static void main(String[] args) {

        // Escritura binario
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\repasoGeneral\\serializable\\";
        File f = new File(ruta, "producto.dat");


        FileOutputStream fout = null; // Iniciador

        ObjectOutputStream oos = null; // Filtro

        Producto p1 = new Producto("1","cafe", 1.99);

        try {
            fout = new FileOutputStream(f);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(p1);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                oos.close();
                fout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
