package Grafos.DAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import Grafos.Logica.*;


public class PersonaDao {

	public static ArrayList <Persona> personsFromCsv (String PATH) {
		ArrayList <Persona> persons = new ArrayList <Persona>();
		BufferedReader br = null;
		
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
