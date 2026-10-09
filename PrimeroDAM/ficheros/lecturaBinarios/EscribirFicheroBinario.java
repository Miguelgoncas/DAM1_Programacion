package ficheros.lecturaBinarios;

import java.io.*;

public class EscribirFicheroBinario {
    static void main(String[] args) {
        //Creamos nuevo archivo con file y ruta
        String ruta = "C:\\Users\\Usuario\\Desktop\\repos\\1Prog\\src\\ficheros\\lecturaBinarios";
        File f = new File(ruta, "ficheroBinarioPersona.dat");

        // Declaramos clase
        FileOutputStream fout = null; // Iniciador

        // Declaramos filtro
        ObjectOutputStream oos = null; // Filtro


        try { // Se inicia dentro de un try porque puede dar error
            fout = new FileOutputStream(f);

            oos = new ObjectOutputStream(fout);


            // Escribimos dentro del fichero según los campos del objeto que estemos usando

            oos.writeUTF("88888888A");
            oos.writeUTF("Miguel");
            oos.writeUTF("González");
            oos.writeInt(26);
            oos.writeDouble(2568.98);

            oos.writeUTF("88888888A");
            oos.writeUTF("Miguel");
            oos.writeUTF("González");
            oos.writeInt(26);
            oos.writeDouble(2568.98);

            oos.writeUTF("88888888A");
            oos.writeUTF("Miguel");
            oos.writeUTF("González");
            oos.writeInt(26);
            oos.writeDouble(2568.98);

            oos.writeUTF("88888888A");
            oos.writeUTF("Miguel");
            oos.writeUTF("González");
            oos.writeInt(26);
            oos.writeDouble(2568.98);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fichero no encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                oos.close();
                fout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
