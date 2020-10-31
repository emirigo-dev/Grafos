package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import Logica.Grafo;
import Logica.Persona;
import Logica.Prim;

public class TestPrim {

	private Grafo setUp() {
		Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
		Persona p2 = new Persona("Pedro", 4, 3, 1, 4);
		Persona p3 = new Persona("Pedro", 1, 1, 1, 1);
		Grafo g = new Grafo(3);
		g.agregarPersonas(p1);
		g.agregarPersonas(p2);
		g.agregarPersonas(p3);
		g.empezarGrafo();
		return g;
	}
	
	@Test
	public void eligeCaminoMinimotest() {	
		Grafo g = setUp();
		Grafo agm = Prim.generadorArbolMinimo(g, 0);
		assertEquals(12, agm.damePesoTotal());
	}
	
	
}