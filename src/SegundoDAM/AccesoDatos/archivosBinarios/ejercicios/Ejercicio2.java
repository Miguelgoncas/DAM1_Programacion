package SegundoDAM.AccesoDatos.archivosBinarios.ejercicios;

import javax.swing.*;
import java.io.*;

public class Ejercicio2 {
    static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Introduce el nombre del fichero");
        File f = new File(nombre);
        File f1 = new File(nombre + ".txt");

        FileInputStream fis = null;
        BufferedWriter bw = null;
        try {
            fis = new FileInputStream(f);
            bw = new BufferedWriter(new FileWriter(f1));
            int c = 0;

            while ((c = fis.read()) != -1 ){
                if ((c >= 'A' && c <= 'Z') || c == ' ' || (c >= 'a' && c <= 'z')) {
                    bw.write(c);
                }

            }
            JOptionPane.showMessageDialog(null, "fichero creado: " + f1.getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
