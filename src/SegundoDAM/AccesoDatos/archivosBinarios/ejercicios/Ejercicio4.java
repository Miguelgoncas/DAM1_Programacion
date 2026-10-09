package SegundoDAM.AccesoDatos.archivosBinarios.ejercicios;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio4 {
    static void main(String[] args) throws IOException {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre de la imagen GIF:");

        File f = new File(nombre);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);


            int b1 = fis.read();
            int b2 = fis.read();
            int b3 = fis.read();

            // b1 = 71, b2 = 73, br = 70
            if (b1 == 'G' && b2 == 'I' && b3 == 'F') {
                JOptionPane.showMessageDialog(null, "El fichero es una imagen GIF.");
            } else {
                JOptionPane.showMessageDialog(null, "El fichero no es un gif.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fis.close();
        }
    }
}
