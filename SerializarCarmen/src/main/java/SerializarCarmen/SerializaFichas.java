package SerializarCarmen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;


public class SerializaFichas {

	
	public static Collection<FichaBiblioteca> getFichasAlquilables (String rutasArchivo) throws IOException, ParseException{
		Collection<FichaBiblioteca> librosAlquilados = new ArrayList<>();
	
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(rutasArchivo),"UTF-8"));
			String linea = reader.readLine();
			while ((linea = reader.readLine())!= null){
				librosAlquilados.add(deserializarFicha(linea));	
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return librosAlquilados;
	
	}
	


	private static FichaBiblioteca deserializarFicha(String linea) throws ParseException {
		String [] campos = linea.split(",");
		
		String nombre = campos[0];
		String apellido = campos[1];
		String dni = campos[2];
		String titulo = campos[3];
		int numEjemplar = Integer.parseInt(campos[4]);
		String autor =campos[5];
		String fecha = campos[6];
		
		
		
		Socio socio = new Socio(nombre, apellido, dni);
		Ejemplar ejemplar = new Ejemplar(titulo, autor, numEjemplar);
		
		ejemplar.setFechaAlquiler( fecha);
		
		
		FichaBiblioteca fichaBiblioteca= new FichaBiblioteca(ejemplar,socio);
				

		return fichaBiblioteca;
	}
	
	public SerializaFichas() {
		
	}
	
	

}
