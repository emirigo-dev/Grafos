package Logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGrafo {

	@Test(expected = IllegalArgumentException.class)
	public void empezarGrafoVacioTest() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 1, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Persona p4 = new Persona("Pedro", 2, 3, 1, 3);
		Grafo g = new Grafo(3);
		g.empezarGrafo();

	}

	@Test(expected = IllegalArgumentException.class)
	public void empezarGrafoRevalsadoTest() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 1, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Persona p4 = new Persona("Pedro", 2, 3, 1, 3);
		Grafo g = new Grafo(3);
		g.agregarPersonas(p1);
		g.agregarPersonas(p2);
		g.agregarPersonas(p3);
		g.agregarPersonas(p4);
		g.empezarGrafo();

	}
	private Grafo setUp() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 1, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Persona p4 = new Persona("Pedro", 2, 3, 1, 3);
		Grafo g = new Grafo(3);
		g.agregarPersonas(p1);
		g.agregarPersonas(p2);
		g.agregarPersonas(p3);
		g.empezarGrafo();
		return g;
	}

	@Test(expected = IllegalArgumentException.class)
	public void IndiceSimilaridadVerticesInvalidosTest() {
		Grafo g = setUp();
		assertEquals(2, g.dameSimilaridad(-1, 5));
	}

	@Test
	public void IndiceSimilaridadValidaTest() {
		Grafo g = setUp();
		assertEquals(8, g.dameSimilaridad(1, 2));
	}

	@Test
	public void existeAristaTest() {
		Grafo g = setUp();
		assertTrue(g.existeArista(1, 2));
	}
	
	@Test
	public void eliminarArista() {
		Grafo g = setUp();
		g.eliminarArista(1, 2);
		assertFalse(g.existeArista(1, 2));
	}
	
	@Test
	public void noExisteAristaTest() {
		Grafo g = setUp();
		assertFalse(g.existeArista(1, 1));
	}
	@Test
	public void tamanioTest() {
		Grafo g = setUp();
		assertEquals(3, g.tamanio());
	}
	@Test
	public void agregarAristaTest() {
		Grafo g = setUp();
		g.agregarArista(0, 2);
		g.eliminarArista(1, 2);
		g.eliminarArista(0, 2);
		g.agregarArista(1, 2);
		assertTrue(g.existeArista(1, 2));
	}
	
	@Test
	public void sumarPeso() {
		Grafo g = setUp();
		assertEquals(20, g.damePesoTotal());
	}
	
}
