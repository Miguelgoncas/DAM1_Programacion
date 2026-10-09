package ejerciciosExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
    static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        try {
            int num1 = rd.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un número");
        } finally {
            rd.close();
        }
    }
}
