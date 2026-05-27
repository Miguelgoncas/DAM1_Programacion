package ficheros.ficheroClaseSerializable;

import ficheros.Persona;

import java.io.*;

public class EscrituraFicheroSerial {
    static void main(String[] args) {
        //Creamos nuevo archivo con file y ruta
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\ficheroClaseSerializable";
        File f = new File(ruta, "ficheroClaseClaseSerializable.dat");

        // Escritura binario
        // Declaramos clase
        FileOutputStream fout = null; // Iniciador

        // Declaramos filtro
        ObjectOutputStream oos = null; // Filtro

        Persona p1 = new Persona("775456", "Miguel",
                "Gonzalez",26,1400);
        Persona p2 = new Persona("2345", "Elena",
                "Gonzalez",26,1400);
        Persona p3 = new Persona("2543", "Luis",
                "Gonzalez",26,1400);
        Persona p4 = new Persona("8678", "Miriam",
                "Gonzalez",26,1400);

        try {
            fout = new FileOutputStream(f);
            oos = new ObjectOutputStream(fout);

            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.writeObject(p4);

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
