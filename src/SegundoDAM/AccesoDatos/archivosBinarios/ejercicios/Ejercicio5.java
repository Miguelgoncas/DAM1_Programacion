package SegundoDAM.AccesoDatos.archivosBinarios.ejercicios;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio5 {
    static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Introduce el nombre del archivo");
        File f = new File(nombre);

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(f);

            byte[] datos = new byte[(int) f.length()];
            String resultado = "";

            fis.read(datos);

            for (int i = 0; i < datos.length ; i++){
                if ((datos[i] >= 'A' && datos[i] <= 'Z') ||
                        (datos[i] >= 'a' && datos[i] <= 'z') ||
                        datos[i] == ' ') {

                    resultado += (char) datos[i];
                }
            }

            JOptionPane.showMessageDialog(null, resultado);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
