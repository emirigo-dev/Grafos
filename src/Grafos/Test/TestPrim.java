package Grafos.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Grafos.Logica.BFS;
import Grafos.Logica.Grafo;
import Grafos.Logica.Persona;
import Grafos.Logica.Prim;

public class TestPrim {

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
	
	@Test
	public void eligeCaminoMinimoOrigenInicioTest() {	
		Grafo g = setUp();
		Grafo agm = Prim.generadorArbolMinimo(g, 0);
		assertEquals(14, agm.damePesoTotal());
	}
	
	@Test
	public void eligeCaminoMinimoOrigenFinalTest() {	
		Grafo g = setUp();
		Grafo agm = Prim.generadorArbolMinimo(g, 4);
		assertEquals(14, agm.damePesoTotal());
	}
	
	@Test
	public void eligeCaminoMinimoOrigenIntermedioTest() {	
		Grafo g = setUp();
		Grafo agm = Prim.generadorArbolMinimo(g, 2);
		assertEquals(14, agm.damePesoTotal());
	}
	
	
	@Test
	public void esArbol () {
		Grafo g = setUp();
		Grafo agm = Prim.generadorArbolMinimo(g, 0);
		assertTrue(BFS.esArbol(agm));
	}
	
	
}