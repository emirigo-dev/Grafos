package Grafos.DAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import Grafos.Logica.*;

/**
 * <h1>PersonaDao</h1>
 * PersonaDao es la clase que obener el registro de todas las personas que serán visualizadas
 * 
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */

public class PersonaDao {

	
	/**
	 * Este metodo lee los datos para armar objetos de tipo {@code Persona} desde un CSV y lo devuelve en forma de lista.
	 * 
	 * @return Devuelve un {@code ArrayList} con los objetos {@code Persona}
	 */
	public static ArrayList <Persona> personsFromCsv () {
		ArrayList <Persona> persons = new ArrayList <Persona>();
		BufferedReader br = null;
		String PATH = System.getProperty("user.dir") + "/resourses/personas.csv";
		
		try {
			br = new BufferedReader (new FileReader (PATH));
			String line = br.readLine();
			while (line != null) {
				String [] array = line.split(";");
				Persona persona = new Persona (
						(array[0]),
						Integer.parseInt(array[1]),
						Integer.parseInt(array[2]),
						Integer.parseInt(array[3]),
						Integer.parseInt(array[4]));
				
				persons.add(persona);
				line = br.readLine();
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return persons;
	}
}
