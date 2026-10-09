package colecciones.ejercicio16;

import java.util.*;

public class Biblioteca {
    private ArrayList<Libro> librosDisponibles = new ArrayList<>();


    // Crear una nueva clase con equals y hashcode
    private HashSet<String> autores = new HashSet<>();
    // Crear una nueva clase con equals y hashcode
    private TreeSet<String> categorias = new TreeSet<>();

    private PriorityQueue<Prestamo> colaPrestamos = new PriorityQueue<>();

    private LinkedList<Prestamo> historialPrestamos = new LinkedList<>();


    public void anadirLibro(Libro libro) {
        librosDisponibles.add(libro);                  // ArrayList
        autores.add(libro.getAutor());                 // HashSet
        categorias.add(libro.getCategoria());          // TreeSet
        System.out.println("Libro añadido: " + libro);
    }

    public void mostrarLibros() {
        if (librosDisponibles.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return;
        }

        System.out.println(" Libros disponibles ");
        for (int i = 0; i < librosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + librosDisponibles.get(i));
        }

    }

    public void registrarPrestamo(int indiceLibro, String nombreUsuario, int prioridad) {
        if (indiceLibro < 0 || indiceLibro >= librosDisponibles.size()) {
            System.out.println("Índice de libro no válido.");
            return;
        }

        Libro libroSeleccionado = librosDisponibles.get(indiceLibro);

        Prestamo prestamo = new Prestamo(libroSeleccionado, nombreUsuario, prioridad);
        colaPrestamos.add(prestamo);

        System.out.println("Préstamo registrado en la cola: " + prestamo);
    }

    public void procesarPrestamo() {
        Prestamo siguiente = colaPrestamos.poll(); // saco el de mayor prioridad

        if (siguiente == null) {
            System.out.println("No hay préstamos pendientes.");
            return;
        }

        librosDisponibles.remove(siguiente.getLibro());

        historialPrestamos.addFirst(siguiente);

        System.out.println("Préstamo procesado: " + siguiente);
    }

    public void mostrarHistorial() {
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay préstamos en el historial.");
            return;
        }

        System.out.println("Historial de préstamos ");
        for (Prestamo p : historialPrestamos) {
            System.out.println(p);
        }
    }
}
