package Logica;

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
}
