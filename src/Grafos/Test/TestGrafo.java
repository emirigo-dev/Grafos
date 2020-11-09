package Grafos.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Grafos.Logica.Grafo;
import Grafos.Logica.Persona;
import Grafos.Logica.Prim;

public class TestGrafo {

	@Test(expected = IllegalArgumentException.class)
	public void empezarGrafoVacioTest() {
		Grafo g = new Grafo(3);
		g.grafoCompleto();

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
		g.grafoCompleto();

	}

	private Grafo setUp() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 1, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Grafo g = new Grafo(3);
		g.agregarPersonas(p1);
		g.agregarPersonas(p2);
		g.agregarPersonas(p3);
		g.grafoCompleto();
		return g;
	}

	@Test(expected = IllegalArgumentException.class)
	public void indiceSimilaridadVerticesInvalidosTest() {
		Grafo g = setUp();
		assertEquals(2, g.dameSimilaridad(-1, 5));
	}

	@Test
	public void indiceSimilaridadValidaTest() {
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
		
		int peso = g.getGrupoPersona().get(0).similaridad(g.getGrupoPersona().get(2));
		g.agregarArista(0, 2, peso);
		g.eliminarArista(1, 2);
		g.eliminarArista(0, 2);
		peso = g.getGrupoPersona().get(1).similaridad(g.getGrupoPersona().get(2));
		g.agregarArista(1, 2, peso);
		assertTrue(g.existeArista(1, 2));
	}

	@Test
	public void sumarPesoTest() {
		Grafo g = setUp();
		assertEquals(20, g.damePesoTotal());
	}

	@Test
	public void eliminoAristaTest() {
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
		Grafo agm = Prim.generadorArbolMinimo(g, 0);
		agm.eliminarAristaMasPesada();
		assertFalse(agm.existeArista(0, 1));
		assertFalse(agm.existeArista(1, 0));
	}
	
	@Test
	public void pesoAristaTest() {
		Grafo g = setUp();
		assertEquals(8, g.pesoArista(1, 2));
	}
	
	@Test
	public void cantidadDeVecinoisTest() {
		Grafo g = setUp();
		assertEquals(2, g.cantidadDeVecinos(1));
		}
}
