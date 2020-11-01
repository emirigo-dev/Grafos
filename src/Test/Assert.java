package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Assert {
	public static void iguales(int[] esperado, int[] obtenido) {
		assertEquals(esperado.length, obtenido.length);
		for (int i = 0; i < esperado.length; i++) {
			assertTrue(obtenido[i] == esperado[i]);
		}
	}
	
	public static void igualesMatriz (Integer[][] esperado, Integer[][] obtenido, int vertices) {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				assertTrue(obtenido[i][j].equals(esperado[i][j]));
			}
		}
	}
}
