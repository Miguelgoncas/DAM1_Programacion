package ficheros.repasoGeneral;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepasoFicheroInputStream {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\Desktop\\";
        File f = new File(ruta, "fichero_personas.txt");

        FileInputStream fit = null;
        ObjectInputStream oit = null;
        Persona p = null;
        List<Persona> arrPer = new ArrayList<>();

        try {
            fit = new FileInputStream(f);
            oit = new ObjectInputStream(fit);

            while( oit.available() != 0) {
                p = new Persona();

                p.setDni(oit.readUTF());
                p.setNombre(oit.readUTF());
                p.setApellidos(oit.readUTF());
                p.setEdad(oit.readInt());

                arrPer.add(p);
            }

            arrPer.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oit.close();
                fit.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
