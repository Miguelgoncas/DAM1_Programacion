package ficheros.ficheroClaseSerializable;

import ficheros.Persona;

import java.io.*;
import java.util.ArrayList;

public class LecturaFicheroSerial {
    static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\ficheroClaseSerializable";
        File f = new File(ruta, "ficheroClaseClaseSerializable.dat");

        // iniciamos iniciador
        FileInputStream fis = null;


        // iniciamos filtro
        ObjectInputStream ois = null;

        ArrayList<Persona> arrPersona = new ArrayList<Persona>();


        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0 ) {
                Persona p;
                p = (Persona) ois.readObject();
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
