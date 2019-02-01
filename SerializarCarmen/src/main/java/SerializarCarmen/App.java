package SerializarCarmen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;

public class App {

	public static void main(String[] args) throws IOException, Throwable {

		Collection<FichaBiblioteca> archivoFichas;

		Json jason = new Json(OutputType.json);
		String rutaCSVString ="datos/DatosBiblioteca.CSV";
		String rutaJson = "datos/datosB.json";
		String rutaJsonFilas ="datos/datosBFilas.json";

		//leer desde CSV a una coleccion de fichas	(objetos)
		archivoFichas = SerializaFichas.getFichasAlquilables(rutaCSVString);
		
		for (FichaBiblioteca fichaBiblioteca : archivoFichas) {
			System.out.println(fichaBiblioteca);	
		}
		
		//convierto los objetos fichas en json e imprimo formato bonito
		String archivosFichasJson=jason.prettyPrint(archivoFichas);
		
		System.out.println(archivosFichasJson);
		
		//guardo el string de json a un archivo json en filas
		guardarFichasaJsonPorFilas(archivoFichas,rutaJsonFilas);
		
		//convierto el archivo de json en filas a una coleccion de Fichas
		archivoFichas = getFichasBibliotecaFromJson(rutaJsonFilas);
		
		for (FichaBiblioteca fichaBiblioteca : archivoFichas) {
			System.out.println(fichaBiblioteca);
			
		}
		
		guardarStringFichaenFichero(archivosFichasJson,rutaJson);
		

		

	}

	private static Collection<FichaBiblioteca> getFichasBibliotecaFromJson(String rutaJsonFilas) {
		Collection<FichaBiblioteca> fichaLeida= new ArrayList<>();
		Json json = new Json();
		try(BufferedReader reader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream(rutaJsonFilas),
							"UTF-8"))){
			String linea;
			while ((linea = reader.readLine())!=null) {
				fichaLeida.add(json.fromJson(FichaBiblioteca.class, linea));
				
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fichaLeida;
	}

	private static void guardarStringFichaenFichero(String cadena, String rutaJson) throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaJson),"UTF-8"))) {
			writer.write(cadena);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}


	private static void guardarFichasaJsonPorFilas(Collection<FichaBiblioteca> archivoFichas, String rutaJson) throws Exception {
		Json json= new Json();
		
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaJson),"UTF-8"))) {
			for (FichaBiblioteca fichaBiblioteca : archivoFichas) {
				writer.write(json.toJson(fichaBiblioteca));
				writer.newLine();			
			}	
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
