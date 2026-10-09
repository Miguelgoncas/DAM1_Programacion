package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";

        File f = new File(ruta, "fichero.txt");

        File f1 = new File(ruta, "fichero2.txt");

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            ArrayList<String> arrayFichero = new ArrayList<>();
            String linea ;
            while((linea = br.readLine()) != null){
                arrayFichero.add(linea.toUpperCase());
            }

            fw = new FileWriter(f1);
            bw = new BufferedWriter(fw);

            for (String texto : arrayFichero) {
                bw.write(texto);
                bw.newLine();
            }
            fr = new FileReader(f1);
            br = new BufferedReader(fr);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
