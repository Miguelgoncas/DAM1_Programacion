package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";

        File f = new File(ruta, "fichero.txt");

        Scanner sc = new Scanner(System.in);
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linea ;
            int cont = 0;

            while ( (linea = br.readLine()) != null){
                System.out.println(linea);
                cont++;

                if(cont == 3){
                    System.out.println("Pulsa enter para continuar.");
                    sc.nextLine();
                    cont = 0;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero");
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
