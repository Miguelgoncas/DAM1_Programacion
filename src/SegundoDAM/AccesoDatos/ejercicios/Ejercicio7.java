package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";

        File f = new File(ruta, "fichero3.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linea ;
            int height = 0;
            int width = 0;
            while((linea = br.readLine()) != null){

                if(linea.contains("*")){
                    height++;
                }
                width = linea.length();
            }

            System.out.println("Altura: " + height);
            System.out.println("Anchura: " + width);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
