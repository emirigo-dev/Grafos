package Grafos.Test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import Grafos.Logica.BFS;
import Grafos.Logica.Grafo;
import Grafos.Logica.Persona;

public class TestBFS {

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}

	@Test
	public void testAlcanzable() {
		Grafo g = setUp();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		int[] esperados = { 0, 1, 2, 3, 4 };

		Assert.iguales(esperados, alcanzables);
	}

	@Test
	public void conextoTest() {
		Grafo g = setUp();
		
		int peso = g.getGrupoPersona().get(3).similaridad(g.getGrupoPersona().get(4));
		g.agregarArista(3, 4, peso);
		assertTrue(BFS.esConexo(g));

	}

	@Test
	public void vacioTest() {
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	

	private Grafo setUp() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 2, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Persona p4 = new Persona("Fulano", 3, 4, 1, 4);
		Persona p5 = new Persona("Fulano", 4, 4, 2, 4);
		Grafo g = new Grafo(5);
		g.agregarPersonas(p1);
		g.agregarPersonas(p2);
		g.agregarPersonas(p3);
		g.agregarPersonas(p4);
		g.agregarPersonas(p5);
		g.grafoCompleto();
		return g;
	}
	

}
