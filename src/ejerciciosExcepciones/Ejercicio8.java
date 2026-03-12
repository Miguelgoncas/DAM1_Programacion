package ejerciciosExcepciones;

public class Ejercicio8 {
    public static void main(String[] args) throws Exception {
    String password = "12345";
    validarPassword(password);
    }

    public static void validarPassword(String password) throws Exception {
        if(password.length() < 8){
            throw new Exception("La contraseña debe de ser más larga de 8");
        }
    }
}
