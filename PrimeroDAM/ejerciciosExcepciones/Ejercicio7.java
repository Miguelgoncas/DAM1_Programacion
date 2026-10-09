package ejerciciosExcepciones;

public class Ejercicio7 {
    public static void main(String[] args) {

        int edad = 15;

        try {
            if (edad < 18){
                throw new IllegalArgumentException("Error, debe ser mayor de edad");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
