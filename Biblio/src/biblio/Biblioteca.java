package biblio;


public class Biblioteca {
	// Defino atributos y arrays que usaremos en la clase
	private int contadorLibr = 0;
	private int contadorUsur = 0;
	private int contadorPres = 0;
	// Solo los defino, la dimensión la paso por Scanner
	@SuppressWarnings("unused")
	private String nombre;
	private Libro[] arrLibros;
	private Usuario[] arrUsuarios;
	private Prestamo[] arrPrestamo;
	
	// Creo constructor para poder trabajar con un objeto
	public Biblioteca(String nombre, int stock) {
		this.nombre = nombre;
		this.arrLibros = new Libro[stock];
		this.arrPrestamo = new Prestamo[stock];
		this.arrUsuarios = new Usuario[stock];
	}

	// Estos 3 métodos son para comprobar si los arrays están llenos o no
	private boolean estaLlenoLibr() {
		return contadorLibr >= arrLibros.length;
	}

	private boolean estaLlenoUsu() {
		return contadorUsur >= arrUsuarios.length;
	}

	private boolean estaLlenoPres() {
		return contadorPres >= arrPrestamo.length;
	}
	
	//

	// Método para dar de alta un libro, haciendo comprobaciones
	public boolean altaLibro(String titulo, String autor, int paginas, String ISBN, int anio) {

		// Comprobamos si hay sitio en el array para dar de alta un libro, sino
		// devolvemos.
		if (estaLlenoLibr()) { 
			return false;
		}
		// Comprobamos que el ISBN no existe ya
		if (comprobarISBN(ISBN)) { 
			return false;
		}
		// Creamos el libro después de todas las comprobaciones
		Libro l1 = new Libro(titulo, autor, anio, paginas, ISBN);

		// Lo guardamos en el array

		arrLibros[contadorLibr] = l1;
		contadorLibr++; // Sumamos 1 al contador para no sobreescribir luego

		return true;
	} // Fin altaLibro
	
	// Con las comprobaciones del main, traemos a los usuarios que se registren con telefono
	public boolean altaUsuario(String nombre, String dni, String telefono) {
		
		// Comprobamos array Usuarios
		if (estaLlenoUsu())
			return false;
		if (comprobarDNI(dni))
			return false;
		// Creamos usuario y lo metemos en array, sumamos uno al contador 

		Usuario usuario = Usuario.altaUsuario(nombre, dni, telefono); 
		
		arrUsuarios[contadorUsur] = usuario;
		contadorUsur++;

		return true;
	} // Fin altaUsuarioTelf

	// Comprobación de que al crear usuario, no se repita DNI
	public boolean comprobarDNI(String dni) {
		for (int i = 0; i < contadorUsur; i++) {
			if (arrUsuarios[i].getDni().equals(dni)) {
				return true; // Dni encontrado
			}
		}
		return false; // No encontrado
	} // Fin comprobarDNI
	
	// Método para comprobar que el ISBN del libro no este repetido
	public boolean comprobarISBN(String isbn) {
		for (int i = 0; i < contadorLibr; i++) {
			if (arrLibros[i].getISBN().equals(isbn)) {
				return true; // ISBN encontrado
			}
		}
		return false; // No existe

	} // Fin comprobarISBN
	
	// Devolvemos el array de libros para poder verlos en el main, igual con usuarios
	public Libro[] listarLibros() {
		return arrLibros;
	}
	
	public boolean hayLibros() {
		return contadorLibr == 0;
	}
	public Prestamo[] listarPrestamos() {
		return arrPrestamo;
	}
	public boolean hayPrestamos(){
		return contadorPres == 0;
	}

	public Usuario[] listarUsuario() {
		return arrUsuarios;
	}
	
	public boolean hayUsuarios() {
		return contadorUsur == 0;
	}

	// Método para crear prestamos, con comprobaciones de si el array esta lleno, existe el usuario y el libro
	public boolean prestarLibroo(String dni, String isbn, String fecha) {
		if(estaLlenoPres() )
			return false; 
		if(getUsuario(dni) == null) 
			return false;
		if(getLibro(isbn) == null)
			return false;
		if(getLibro(isbn).isPrestado())
			return false;
		// Una vez que todo esta correcto, creamos el prestamo, lo metemos en el array, sumamos uno al contador, y le decimos al atributo del libro que esta prestado
		Prestamo p1 = new Prestamo(isbn,dni, fecha); 
		
		arrPrestamo[contadorPres] = p1;
		contadorPres++;
		getLibro(isbn).setPrestado(true);;

		return true; 
	} 
	
	public boolean devolverLibro(String isbn, String dni, String fecha) {
		// Comprobamos usuario, isbn y si el libro esta prestado o no
		if(getUsuario(dni) == null) 
			return false; 
		if(getLibro(isbn) == null)
			return false;
		if(!getLibro(isbn).isPrestado())
			return false; 
		
		// Buscamos prestamo
		for ( int i = 0 ; i < contadorPres; i++) {
			Prestamo p = arrPrestamo[i];
			
			// Comprobamos que coincida el libro con el usuario del prestamo
			if( p.getIsbnLibro().equals(isbn) 
				&& p.getDniUsuario().equals(dni) ) {
				// Cerramos prestamo
				p.setFechaDevolucion(fecha);
				
				// Marcamos libro como disponible
				getLibro(isbn).setPrestado(false);
				return true;
			}
		}
		
		return false;
		
	} // Fin devolver Libro
 
	public Prestamo getPrestamo(String isbn) {
		for ( int i = 0 ; i < arrPrestamo.length ; i++) {
			if( arrPrestamo[i].getIsbnLibro().equals(isbn))
				return arrPrestamo[i];
		} 
		return null; 
	} 
	
	public Prestamo[] listarPrestamosUsuario(String dni) {
		if (getUsuario(dni) == null)
			return null;

		Prestamo[] resultado = new Prestamo[contadorPres];
		int contador = 0;

		for (int i = 0; i < contadorPres; i++) {
			if (arrPrestamo[i].getDniUsuario().equals(dni)) {
				resultado[contador] = arrPrestamo[i];
				contador++;
			}
		}

		return resultado;
	}
	
	// Método para buscar y devolver un Usuario
	public Usuario getUsuario(String dni) {  
		for( int i = 0 ; i < arrUsuarios.length ; i++) {
			if(arrUsuarios[i].getDni().equals(dni)) {  
				return arrUsuarios[i]; 
			} 
		}
		return null;
	} // Fin getUsuario
	
	public Libro getLibro(String isbn) {
		for ( int i = 0 ; i < arrLibros.length; i++) {
			if ( arrLibros[i].getISBN().equals(isbn)) {
				return arrLibros[i];
			}
		}
		return null;
	} // Fin getLibro
	
}// Fin clase
