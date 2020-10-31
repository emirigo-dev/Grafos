package Test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;

import Logica.BFS;
import Logica.Grafo;
import Logica.Persona;
import Logica.Prim;

public class TestPrim {

	private Grafo setUp() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 1, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Persona p4 = new Persona("Fulano", 2, 1, 2, 4);
		Persona p5 = new Persona("Fulano", 1, 1, 2, 4);
		Grafo g = new Grafo(5);
		g.agregarPersonas(p1);
		g.agregarPersonas(p2);
		g.agregarPersonas(p3);
		g.agregarPersonas(p4);
		g.agregarPersonas(p5);
		g.empezarGrafo();
		return g;
	}
	
	@Test
	public void eligeCaminoMinimoTest() {	
		Grafo g = setUp();
		Grafo agm = Prim.generadorArbolMinimo(g, 4);
		for (int i = 0; i < agm.getA().length; i++ ) {
			System.out.println(Arrays.toString(agm.getA()[i]));
			
		}
		assertEquals(18, agm.damePesoTotal());
	}
	
//	@Test
//	public void esArbol () {
//		Grafo g = setUp();
//		Grafo agm = Prim.generadorArbolMinimo(g, 0);
//		assertTrue(BFS.esArbol(agm));
//	}
	
	
}