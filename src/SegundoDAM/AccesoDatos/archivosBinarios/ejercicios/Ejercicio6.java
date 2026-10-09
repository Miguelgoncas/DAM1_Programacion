package SegundoDAM.AccesoDatos.archivosBinarios.ejercicios;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio6 {
    static void main(String[] args) {

        String nombre1 = JOptionPane.showInputDialog("Introduce el nombre del primer fichero");

        String nombre2 = JOptionPane.showInputDialog("Introduce el nombre del segundo fichero");

        File f1 = new File(nombre1);
        File f2 = new File(nombre2);

        FileInputStream fis = null;
        FileInputStream fis2 = null;

        try {
            fis = new FileInputStream(f1);
            fis2 = new FileInputStream(f2);

            boolean iguales = true;

            int b1 = 0;
            int b2 = 0;

            do {
                b1 = fis.read();
                b2 = fis2.read();

                if (b1 != b2) {
                    iguales = false;
                }

            } while (b1 != -1 && b2 != -1 && iguales);

            if (iguales) {
                JOptionPane.showMessageDialog(null,
                        "Los ficheros son iguales.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Los ficheros no son iguales");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                fis2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
