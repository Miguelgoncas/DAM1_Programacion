package SegundoDAM.AccesoDatos.ejercicios;

import javax.swing.*;
import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) {

        String ruta = JOptionPane.showInputDialog("Introduce la ruta del archivo");

        File f = new File(ruta);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);

            bw.write(JOptionPane.showInputDialog("Que deseas introducir en el archivo?"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
