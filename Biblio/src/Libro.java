package biblio;

public class Libro {
	// Definimos los atributos de libro
	private String titulo;
	private String autor;
	private int paginas;
	private String ISBN;
	private boolean prestado;
	private int anio;
	
	// Creo constructor para poder crear objetos
	public Libro(String titulo, String autor, int anio, int paginas,String ISBN) {
		this.titulo = titulo;
		this.autor = autor; 
		this.paginas = paginas;
		this.ISBN = ISBN; 
		this.anio = anio;
	}
	
	public boolean esLargo() {
		boolean longi = false;
		
		if (this.paginas > 300) {
			System.out.println("Tu libro tiene más de 300 páginas, es largo");
			longi = true;
			return longi;
		} else {
			System.out.println("Tu libro es corto");
			return longi;
		}
		
	} // Fin esLargo
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Get y Set
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getISBN() {
		return ISBN; 
	}

	@Override
	public String toString() {
		return "Libro titulo: " +   titulo    + ", autor: " + autor + ", paginas: " + paginas + ", ISBN: " + ISBN
				+ ", prestado: " + prestado + ", anio: " + anio ; 
	}  
	
	
} // Fin class
