package ejerciciosExcepciones;


import java.util.InputMismatchException;

public class Ejercicio4 {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        try {
             num1 = 5;
        } catch (InputMismatchException e) {
            e = new InputMismatchException("Debes introducir un número");
            System.out.println(e.getMessage());
        }

        try {
             num2 = 0;
        } catch (InputMismatchException e) {
            e = new InputMismatchException("Debes introducir un numero");
            System.out.println(e.getMessage());
        }

        double suma = num1 + num2;
        double resta = num1 - num2;

        double division = 0;
        if(num2 == 0){
            try{
                division = num1/num2;
            } catch (ArithmeticException e){
                System.out.println("No puedes dividir entre 0");
            }
        }
    }
}
