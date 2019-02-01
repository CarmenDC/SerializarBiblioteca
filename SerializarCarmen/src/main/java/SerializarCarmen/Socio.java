package SerializarCarmen;

public class Socio {
	
	String nombre;
	String apellido;
	String dni;
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public Socio(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public Socio() {
	}
	@Override
	public String toString() {
		return "Socio: " + nombre + ", apellido: " + apellido + ", dni: " + dni;
	}

	
}
