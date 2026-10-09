package colecciones.ejercicio16;

import java.util.Scanner;

public class MainBiblio {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        boolean salir = false;

        while (!salir) {
            System.out.println("BIBLIOTECA ");
            System.out.println("1. Añadir libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Procesar préstamo");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (opcion) {
                case 1 :
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();

                    Libro libro = new Libro(titulo, autor, categoria);
                    biblioteca.anadirLibro(libro);
                    break;

                case 2 :
                    biblioteca.mostrarLibros();
                    break;

                case 3 :
                    biblioteca.mostrarLibros();
                    System.out.print("Número de libro a prestar: ");
                    int numLibro;
                    try {
                        numLibro = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Número no válido.");
                        break;
                    }
                    System.out.print("Nombre del usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Prioridad (1=alta, 2=media, 3=baja): ");
                    int prioridad;
                    try {
                        prioridad = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Prioridad no válida.");
                        break;
                    }

                    biblioteca.registrarPrestamo(numLibro, usuario, prioridad);
                break;

                case 4 :
                    biblioteca.procesarPrestamo();
                    break;

                case 5 :
                    biblioteca.mostrarHistorial();
                    break;

                case 6 :
                    salir = true;
                    break;

                default :
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
