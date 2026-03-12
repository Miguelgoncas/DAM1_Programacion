package ejerciciosExcepciones;

import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] array = new int[5];

        try {
            System.out.println(array[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No puedes acceder a un indice que no existe");
        }
    }
}
