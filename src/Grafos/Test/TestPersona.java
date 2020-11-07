package Grafos.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import Grafos.Logica.Persona;

public class TestPersona {

	@Test(expected = IllegalArgumentException.class)
	public void personaInteresesNegativosTest() {
		Persona persona = new Persona("Emiliano", -1, -2, -3, -4);
		Persona persona2 = new Persona("Juan", 2, 3, 2, 1);
		assertEquals(6, persona.similaridad(persona2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void personaVaciaTest() {
		Persona persona = new Persona("Emiliano", 1, 2, 3, 4);
		Persona persona2 = new Persona("", 0, 0, 0, 0);
		assertEquals(6, persona.similaridad(persona2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void personaNombreVacioTest() {
		Persona persona = new Persona("", 1, 2, 3, 4);
		Persona persona2 = new Persona("Juan", 2, 3, 2, 1);
		assertEquals(6, persona.similaridad(persona2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void personaValoresNegativos() {
		Persona persona = new Persona("Roberto", 0, -1, -3, 2);
	}

	@Test
	public void personaInteresSimilarTest() {
		Persona persona = new Persona("Emiliano", 1, 2, 3, 4);
		Persona persona2 = new Persona("Juan", 2, 3, 2, 1);
		assertEquals(6, persona.similaridad(persona2));
	}

}
