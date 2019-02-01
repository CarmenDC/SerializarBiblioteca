package SerializarCarmen;

public class FichaBiblioteca {
	
	private Ejemplar ejemplar;
	private Socio socio;
	
	public FichaBiblioteca() {
		
	}
	
	public FichaBiblioteca(Ejemplar ejemplar, Socio socio) {
		super();
		this.ejemplar = ejemplar;
		this.socio = socio;
	}

	@Override
	public String toString() {
		return ejemplar.toString() + " "+ socio.toString();
	}
	
	
	
	

}
