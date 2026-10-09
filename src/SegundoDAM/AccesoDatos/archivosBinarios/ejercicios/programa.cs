using System

public class Ejercicio1Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Console.Write("Hola mundo");
        Console.Write("Introduce tu nombre: ");

        String nombre = sc.nextLine();

        Console.Write("Hola " + nombre);
    }
}
