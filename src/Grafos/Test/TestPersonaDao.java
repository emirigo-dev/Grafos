package Grafos.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import Grafos.DAO.*;
import Grafos.Logica.Persona;

public class TestPersonaDao {

	@Test
	public void test() {
		ArrayList <Persona> people;
		people = PersonaDao.personsFromCsv(120);
		
		assertTrue(people.size() == 120);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void TestMenor3 () {
		PersonaDao.personsFromCsv(2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void TestMayor150 () {
		PersonaDao.personsFromCsv(151);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void TestNegativo () {
		PersonaDao.personsFromCsv(-2);
	}
			

}
