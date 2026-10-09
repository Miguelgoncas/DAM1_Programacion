package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";
        // Creo el fichero, le paso la ruta y pongo el nombre del archivo
        File fichero = new File(ruta, "fichero.txt");

        FileReader fr ;
        BufferedReader br ;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            br.readLine(); // leyendo y no metiendo en ninguna variable descartamos la primera linea

            String segundaLinea = br.readLine();

            if (segundaLinea != null) {
                System.out.println("La segunda línea es: " + segundaLinea);
            } else {
                System.out.println("El fichero no tiene segunda línea");
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
