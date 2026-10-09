package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";

        File f = new File(ruta, "fichero.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line ;

            while((line = br.readLine()) != null){
                for (int i = 0 ; i < line.length() ; i++){
                    char caracter = line.charAt(i);

                    if (caracter != ' ')
                        System.out.print(caracter);
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
