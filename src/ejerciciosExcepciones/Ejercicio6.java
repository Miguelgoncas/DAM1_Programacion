package ejerciciosExcepciones;

import java.io.FileNotFoundException;

public class Ejercicio6 {
    public static void main(String[] args) {

        try{
            System.out.println("Abriendo archivo...");
        //} catch (FileNotFoundException e){

            System.out.println("");
        } finally {
            System.out.println("Recurso cerrado correctamente");
        }
    }
}
