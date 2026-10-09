package SegundoDAM.AccesoDatos.ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del archivo que quieras visualizar");
        String nombreFichero = teclado.nextLine();

        File fichero = null;
        fichero = new File(nombreFichero);

        if (!fichero.exists()){
            System.err.println("Error, el fichero no existe");
        } else {
            try{
                FileReader fr=new FileReader(fichero);
                BufferedReader br=new BufferedReader(fr);
                String s="";
                s = br.readLine();
                while(s!=null){
                    System.out.println(s);
                    s=br.readLine();
                }
                br.close();
                fr.close();
            }
            catch (IOException e) {
                throw new RuntimeException();
            }
        }



    }
}
