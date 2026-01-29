package biblio;

import java.util.Scanner;

public class MainLibro {
	// Defino Scanner y Biblioteca como Static
	static public Scanner leer = new Scanner(System.in);
	static Biblioteca biblioteca;

	// Creo menu para poder interactuar
	static void menu() {
		System.out.println("*************");
		System.out.println("Perfecto, biblioteca creada!!");
		System.out.println("*************");

		int op = 0;
		do {
			System.out.println("Ahora que acción deseas realizar?");
			System.out.println("1. Dar de alta un libro.");
			System.out.println("2. Dar de alta a un usuario.");
			System.out.println("3. Listar todos los libros.");
			System.out.println("4. Prestar un libro a un usuario.");
			System.out.println("5. Devolver libro de un usuario.");
			System.out.println("6. Ver todos los prestamos en curso");
			System.out.println("7. Ver los prestamos de un usuario.");
			op = leer.nextInt();

			switch (op) {
			case 1:
				if (altaLibroo()) {
					System.out.println("Perfecto, libro dado de alta");
					System.out.println("------------");
					break;
				}
				System.out.println("No se ha podido crear el libro");
				System.out.println("------------");
				break;
			case 2:
				if (altaUsuario()) {
					System.out.println("Usuario creado perfectamente");
					System.out.println("------------");
				}
				break;
			case 3:
				listarLibros();
				System.out.println("------------");
				break;
			case 4:
				if (prestarLibro()) {
					System.out.println("Perfecto, disfruta tu libro!");
					System.out.println("------------");
				} else {
					System.out.println("No se ha podido completar el prestamo");
					System.out.println("------------");
				}
				break;
			case 5:
				if (devolverLibro()) {
					System.out.println("Perfecto, libro devuelto!");
					System.out.println("------------");
				} else {
					System.out.println("No se ha podido completar la devolución");
					System.out.println("------------");
				}
				break;
			case 6:
				listarPrestamos();
				System.out.println("------------");
				break;
			case 7:
				if (listarPrestamosUsuario()) {

					break;
				}
				break;
			default:
				System.out.println("Número incorrecto.");
				System.out.println("------------");

			} // Fin switch

		} while (op != 8);
	} // Fin menu

	static boolean listarPrestamosUsuario() {
		if(biblioteca.hayUsuarios()) {
			System.out.println("No hay usuarios registrados");
			System.out.println("------------");
			return false;
		}
		
		listarUsuarios();
		System.out.println("Quién eres?");
		String dni = leer.next();
		Prestamo[] prestamos = biblioteca.listarPrestamosUsuario(dni);
		if (!comprobarArr()) {
			System.out.println("No hay libros o usuarios registrados");
			System.out.println("------------");
			return false;
		} else {
			if (prestamos == null) {
				System.out.println("Usuario no encontrado");
				System.out.println("------------");
				return false;
			} else {
				boolean tienePrestamos = false;

				for (int i = 0; i < prestamos.length; i++) {
					if (prestamos[i] != null) {
						System.out.println(prestamos[i].toString());
						tienePrestamos = true;
					}
				}
				if (!tienePrestamos) {
					System.out.println("El usuario no tiene prestamos");
					System.out.println("------------");
				}
				return true;
			}
		}

	} // Fin listarPrestamosUsuario

	static boolean devolverLibro() {
		if (!comprobarArr()) {
			return false;
		}
		listarUsuarios();
		System.out.println("Quién eres? DNI");
		String dni = leer.next();
		if (biblioteca.comprobarDNI(dni)) {
			System.out.println("Buenas, que libro quieres devolver. ISBN");
			listarPrestamos();
			String isbn = leer.next();
			if (biblioteca.comprobarISBN(isbn)) {
				System.out.println("Introduce la fecha de devolución");
				String fecha = leer.next();
				if (biblioteca.devolverLibro(isbn, dni, fecha)) {
					return true; // Si todo sale bien devolvemos true y el libro se presta
				}
				return false;
			}
			System.out.println("Libro no encontrado"); // Si ponemos mañ ISBN
			return false;
		}
		System.out.println("Usuario no encontrado"); // Si ponemos mal dni
		return false;

	}

	static boolean comprobarArr() {
		// Creamos booleano, si no hay usuarios dados de alta, no se puede prestar
		// libros
		boolean encontrado = false;
		for (int i = 0; i < biblioteca.listarUsuario().length; i++) {
			if (biblioteca.listarUsuario()[i] == null && !encontrado) {
				return false;
			} else {
				encontrado = true;
			}
		}
		encontrado = false;
		for (int i = 0; i < biblioteca.listarLibros().length; i++) {
			if (biblioteca.listarLibros()[i] == null && !encontrado) {
				return false;
			} else {
				encontrado = true;
			}
		}
		return encontrado;
	}

	// Creo método para prestar libro, pedir la información y sacar si se introducen
	// datos erroneos
	static boolean prestarLibro() {
		if (!comprobarArr()) {
			return false;
		}
		listarUsuarios();
		System.out.println("Quién eres? DNI");
		String dni = leer.next();
		if (biblioteca.comprobarDNI(dni)) {
			System.out.println("Buenas, que libro quieres llevarte. ISBN");
			listarLibros();
			String isbn = leer.next();
			if (biblioteca.comprobarISBN(isbn)) {
				System.out.println("Introduce la fecha");
				String fecha = leer.next();
				if (biblioteca.prestarLibroo(dni, isbn, fecha)) {
					return true; // Si todo sale bien devolvemos true y el libro se presta
				}
				return false;
			}
			System.out.println("Libro no encontrado"); // Si ponemos mañ ISBN
			return false;
		}
		System.out.println("Usuario no encontrado"); // Si ponemos mal dni
		return false;

	}

	// Método para listar usuarios
	static void listarUsuarios() {
		for (int i = 0; i < biblioteca.listarUsuario().length; i++) {
			if (biblioteca.listarUsuario()[i] != null)
				System.out.println(biblioteca.listarUsuario()[i].toString());
		}
	}

	// Método para listar libros
	static void listarLibros() {
		if (biblioteca.hayLibros()) {
			System.out.println("No hay libros dados de alta");
		} else {
			for (int i = 0; i < biblioteca.listarLibros().length; i++) {
				if (biblioteca.listarLibros()[i] != null)
					System.out.println(biblioteca.listarLibros()[i].toString());
			}

		}
	} // Fin listarLibros

	static void listarPrestamos() {
		if (biblioteca.hayPrestamos()) {
			System.out.println("No hay ningún prestamo");
		} else {
			for (int i = 0; i < biblioteca.listarPrestamos().length; i++) {
				if (biblioteca.listarPrestamos()[i] != null) 
					System.out.println(biblioteca.listarPrestamos()[i].toString());
			}
		}
	}

	// Método para separar al registrar usuarios, tiene telefono o no
	static boolean altaTelf() {
		System.out.println("Quieres introducir tu número al registrarte? Si. No.");
		String op = leer.next();

		if ("no".equals(op.trim().toLowerCase())) {
			return false;
		}
		if ("si".equals(op.trim().toLowerCase())) {
			return true;
		}
		return false;
	}

	// Método para dar de alta a usuario con telefono
	static boolean altaUsuario() {

		System.out.println("Bienvenido, como te llamas?");
		String nombre = leer.next();

		System.out.println("Cual es tu DNI?");
		String dni = leer.next();

		String telf = null;
		if (altaTelf()) {
			System.out.println("Cual es tu telefono?");
			telf = leer.next();
		}

		if (biblioteca.altaUsuario(nombre, dni, telf)) {
			return true; // Si todo se completa se devuelve true
		}
		System.out.println("DNI repetido");
		return false;

	}

	// Método para dar de alta Libros
	static boolean altaLibroo() {
		// String titulo, String autor, int anio, int paginas,String ISBN)
		System.out.println("Como se llama el libro?");
		String titulo = leer.next();

		System.out.println("Quién es el autor?");
		String autor = leer.next();

		System.out.println("De que año es?");
		int anio = comprobarAnio();

		System.out.println("Cuantas páginas tiene?");
		int pagina = comprobarPaginas();

		System.out.println("ISBN?");
		String ISBN = leer.next();

		// Creamos objeto con método de biblioteca

		if (biblioteca.altaLibro(titulo, autor, pagina, ISBN, anio)) {
			return true;
		} else {
			return false;
		}

	} // Fin altaLibro

	// Método para comprobar el año del libro que sea real
	static boolean comprobarAnio(int anio) {
		if (anio < 1600 || anio > 2026)
			return false;
		return true;
	} // Fin comprobarAnio
		// Método para comprobar que no se introducen números negativos

	static int comprobarPaginas() {
		int paginasComprobacion;

		do {
			paginasComprobacion = leer.nextInt();

			if (paginasComprobacion <= 0)
				System.out.println("Error, las páginas deben de ser mayor a 0");
		} while (paginasComprobacion <= 0);

		return paginasComprobacion;
	} // Fin comprobarPaginas

	// Método para introducir los años
	static int comprobarAnio() {
		int anioComprobacion;

		do {
			anioComprobacion = leer.nextInt();

			if (!comprobarAnio(anioComprobacion))
				System.out.println("Fecha incorrecta, vuelva a introducirla");
		} while (!comprobarAnio(anioComprobacion));

		return anioComprobacion;

	} // Fin leerAnio

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creamos biblioteca, le damos nombre y stock
		System.out.println("Bienvenido, como quieres llamar a tu librería?");
		String nombreB = leer.next();
		System.out.println("Perfecto, que bonito!");
		System.out.println("De cuando stock quieres disponer?");
		int stock = leer.nextInt();

		biblioteca = new Biblioteca(nombreB, stock);
		menu();

	}

}
