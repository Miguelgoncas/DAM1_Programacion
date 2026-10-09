package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";
        // Creo el fichero, le paso la ruta y pongo el nombre del archivo
        File fichero = new File(ruta, "fichero.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String s = "";
            s = br.readLine();
            int mitadLinea = s.length() / 2;

            System.out.println(s.substring(0,mitadLinea));
            System.out.println(s.substring(mitadLinea));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
