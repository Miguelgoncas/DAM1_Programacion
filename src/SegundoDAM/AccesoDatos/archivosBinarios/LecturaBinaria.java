package SegundoDAM.AccesoDatos.archivosBinarios;

import java.io.*;
import java.util.Random;

public class LecturaBinaria {
    static void main(String[] args) {
        boolean finArchivo=false;//Para provocar bucle infinito
        File f=new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\archivosBinarios\\prueba.out");
        try{
            FileInputStream fis=new FileInputStream(f);
            DataInputStream dis=new DataInputStream(fis);
            double d;
            while (fis.available() != 0){
                d=dis.readDouble();
                System.out.println(d);
            }
            dis.close();
        }
        catch(EOFException e){
            finArchivo=true;
        }
        catch(FileNotFoundException e){
            System.out.println("No se encontr el archivo");
        }
        catch(IOException e){
            System.out.println("Error al leer");
        }
    }
}
