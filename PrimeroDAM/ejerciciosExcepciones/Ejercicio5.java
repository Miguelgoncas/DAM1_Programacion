package ejerciciosExcepciones;

import java.util.InputMismatchException;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] arrNum = new int[5];

        try{
            System.out.println(arrNum[7]);
        } catch (ArrayIndexOutOfBoundsException e){
            e = new ArrayIndexOutOfBoundsException("Indice incorrecto");
            System.out.println(e.getMessage());
        }

        try{
            String palabra= "Hola";
           // arrNum[3] = palabra;
        } catch (InputMismatchException e){
            e = new InputMismatchException("Valor asignado incorrecto");
            System.out.println(e.getMessage());
        }
    }
}
