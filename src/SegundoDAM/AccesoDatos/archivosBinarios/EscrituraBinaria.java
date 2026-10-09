package SegundoDAM.AccesoDatos.archivosBinarios;

import java.io.*;
import java.util.Random;

public class EscrituraBinaria {
    static void main(String[] args) {
        File f=new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\archivosBinarios\\prueba.out"); Random r=new Random();

        try{
            FileOutputStream fis=new FileOutputStream(f);
            DataOutputStream dos=new DataOutputStream(fis);
            for (int i=0;i<5;i++){ //Se repite 233 veces
                dos.writeDouble(r.nextDouble());//Nº aleatorio
            }
            dos.writeChars("Ejercicio2");
            dos.close();
        }
        catch(FileNotFoundException e){
            System.out.println("No se encontro el archivo");
        }
        catch(IOException e){
            System.out.println("Error al escribir");
        }
    }
}
