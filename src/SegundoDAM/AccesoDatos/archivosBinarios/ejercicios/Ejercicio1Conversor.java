package SegundoDAM.AccesoDatos.archivosBinarios.ejercicios;

import java.io.*;

public class Ejercicio1Conversor {
    static void main(String[] args) {
        String archivoEntrada = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\archivosBinarios\\ejercicios\\Ejercicio1Java.java";
        String archivoSalida = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\archivosBinarios\\ejercicios\\programa.cs";
        File fJ = new File(archivoEntrada);
        File fC = new File(archivoSalida);

        BufferedReader br = null ;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(archivoEntrada));
            bw = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;

            while((linea = br.readLine()) != null){

                if (linea.startsWith("package"))
                    linea ="";

                if(linea.startsWith("import "))
                    linea = linea.replace("import ", "using ");




                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Archivo generado!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
