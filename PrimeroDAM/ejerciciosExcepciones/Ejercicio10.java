package ejerciciosExcepciones;

import java.util.Scanner;

public class Ejercicio10 {
    static void main(String[] args){
        Scanner rd = new Scanner(System.in);
        System.out.println("Introduce una nota");

        double nota = rd.nextDouble();

        try {
            if (nota < 0 || nota > 10){
                throw new NotaInvalidaException();
            } else {
                System.out.println("Nota guardada correctamente");
            }
        } catch (NotaInvalidaException e) {
            System.out.println(e.getMessage());
        } finally {
            rd.close();
        }

    }

}
