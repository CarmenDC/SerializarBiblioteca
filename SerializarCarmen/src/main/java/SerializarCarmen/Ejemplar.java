package SerializarCarmen;

public class Ejemplar implements Alquilable{
	
	private String titulo;
	private String autor;
	private int numEjemplar;
	String fechaAlquiler;
	

	public int getNumEjemplar() {
		return numEjemplar;
	}

	

	public void setFechaAlquiler(String fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}



	public Ejemplar(String titulo, String autor, int numEjemplar) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.numEjemplar = numEjemplar;
	}

	public Ejemplar() {
	}
	
	@Override
	public String getFechaAlquiler() {
		return fechaAlquiler;
	}

	@Override
	public String toString() {
		return "Titulo: "+ titulo + " Autor: " + autor + " Num.Ejemplar: " + numEjemplar + " Fecha Alquiler: "
				+ fechaAlquiler;
	}
	
	


	

}
