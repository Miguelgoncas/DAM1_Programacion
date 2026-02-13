package biblio;

public class Usuario { 
	private String nombre;
	private String dni;
	private String telefono;
	
	// Constructor con telefono
	public Usuario(String nombre, String dni, String telefono) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}
	// Constructor sin telefono
	public Usuario(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public boolean comprobarDNI(String dni) {
		if (this.dni.equals(dni))
			return false;
		
		return true; 
	}
	
	public static Usuario altaUsuario(String nombre, String dni, String telefono) {
		return new Usuario(nombre, dni, telefono); 
	}
	 
	
	
	 
	
	// Get y Set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Usuario nombre: " + nombre + " DNI:" + dni;
	}

	

	
} // Fin clase
