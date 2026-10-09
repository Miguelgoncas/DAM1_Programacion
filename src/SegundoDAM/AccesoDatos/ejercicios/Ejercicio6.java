package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\Ejercicios1\\";

        System.out.println("En que fichero quieres buscar?");
        String file = sc.nextLine();
        File f = new File(ruta, file);


        FileReader fr = null;
        BufferedReader br = null;

        System.out.println("Que palabra quieres buscar?");
        String buscar = sc.nextLine();

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linea ;

            while((linea = br.readLine()) != null){
                if ( linea.contains(buscar))
                    System.out.println(linea);
            }

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
