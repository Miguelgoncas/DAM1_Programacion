package ejerciciosExcepciones;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);

        int num1 = rd.nextInt();
        int num2 = rd.nextInt();

        double resultado = 0;
        System.out.println(resultado);

        if(num2 == 0){
            try {
                resultado = num1/num2;
            } catch (ArithmeticException e) {
                System.out.println("No puedes dividir entre 0");
            }
        }
    }
}
