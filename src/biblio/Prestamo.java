package biblio;

public class Prestamo {
	private  String isbnLibro;
	private String dniUsuario;
	private String fechaPrestamo;
	private String fechaDevolucion;
	
	
	
	public Prestamo(String isbnLibro, String dniUsuario, String fechaPrestamo) {
		this.isbnLibro = isbnLibro;
		this.dniUsuario = dniUsuario;
		this.fechaPrestamo = fechaPrestamo;
	}
	
	
	
	// Get and Set

	public String getIsbnLibro() {
		return isbnLibro;
	}



	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
	}



	public String getDniUsuario() {
		return dniUsuario;
	}



	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}



	public String getFechaPrestamo() {
		return fechaPrestamo;
	}



	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}



	public String getFechaDevolucion() {
		return fechaDevolucion;
	}



	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}



	@Override
	public String toString() {
		return "Prestamo isbnLibro: " + isbnLibro + ", dniUsuario: " + dniUsuario + ", fechaPrestamo: " + fechaPrestamo + " fechaDevolución "+ fechaDevolucion;
	}
	
	
	
	
	

} // Fin class
