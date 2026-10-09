public class Formateo {
    public static void main(String[] args) {
        String nombre = "Elena";
        int edad = 31;
        double salario = 1600.90;

        // String.format
        String mensaje = String.format("Nombre: %s, Edad: %d, Salario: %.2f", nombre, edad, salario);

        // %.2f para imprimir solo dos decimales
        System.out.println(mensaje);

        System.out.printf("Nombre: %s, Edad: %d, Salario: %.2f \n", nombre, edad, salario);


        mensaje = """
                \n Detalle Persona:\s
                --------------
                \tNombre: %s
                \tEdad: %d
                \tSalario: %.2f
                """.formatted(nombre,edad,salario);

        System.out.println(mensaje);

        // Formateo con text block y printf directamente

        System.out.printf("""
                \n Detalle Persona:\s
                --------------
                \tNombre: %s
                \tEdad: %d
                \tSalario: %.2f
                """,nombre, edad, salario);

        for(int i = 0; i < nombre.length() ; i ++){

        }

        int[] array = new int[5];
        array[0] = 1;

        for(int i : array) {
            if (array[i] == 1) {
                System.out.println(array[i]);

            }
        }
    }
}
