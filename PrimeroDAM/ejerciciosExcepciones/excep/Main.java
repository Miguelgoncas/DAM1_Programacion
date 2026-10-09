package ejerciciosExcepciones.excep;

public class Main {
    public static void main(String[] args) {

    }

    public static void convertir() throws Exception { // la propagamos main
        int num1 = 1;
        int num2 = 0;
        int num3 = -2;
        double resultado = 0;

        if(num3 < 0){
            throw new RaizNegativaException();
        } else {
            resultado = Math.sqrt(num3);
            System.out.println("El resultado es" + resultado );
        }
        if(num2 == 0) {
            throw new Exception("No puedes dividir entre cero");
            // Usamos el new para llamar al constructor y crear nuestra excepcion
        } else {
            resultado = num1/num2;
            System.out.println("El resultado es " + resultado );
        }
    }
}


