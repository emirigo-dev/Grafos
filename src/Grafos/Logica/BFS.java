package Grafos.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>BFS</h1>
 * Algoritmo que permite el recorrido en un {@code Grafo}
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */

public class BFS {
	
	private static ArrayList<Integer> L;
	private static boolean marcados[];

	/**
	 * Método que recorre el {@code Grafo} y determina si el mismo es conexo o no
	 * @param g es el {@code Grafo} a recorrer
	 * @return Booleano el cual indica si el {@code Grafo} es conexo*/
	public static boolean esConexo(Grafo g) {
		if (g == null) {
			throw new IllegalArgumentException();
		}
		if (g.getVertices() == 0) {
			return true;
		}
		return alcanzables(g, 0).size() == g.getVertices();
	}

	/**
	 * Método que devuelve los vecinos de un vertice del {@code Grafo}
	 * @param g es el {@code Grafo} a recorrer
	 * @param i es el vertice al cual buscar los vecinos
	 * @return Una estructura de datos {@code Set<Integer>} con los vecinos de i */
	public static Set<Integer> alcanzables(Grafo g, int i) {

		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, i);
		while (L.size() > 0) {
			int puntero = L.get(0);
			marcados[puntero] = true;
			ret.add(puntero);
			agregarVecinosPendientes(g, puntero);
			L.remove(0);
		}
		return ret;
	}

	private static void agregarVecinosPendientes(Grafo g, int i) {
		for (int vertice : g.vecinos(i)) {
			if (marcados[vertice] == false && L.contains(vertice) == false) {
				L.add(vertice);
			}
		}
	}

	private static void inicializar(Grafo g, int origen) {
		L = new ArrayList<Integer>();
		L.add(origen);
		marcados = new boolean[g.getVertices()];
	}

	/**
	 * Método que busca determinar si un grafo es un árbol
	 * @param grafo es un objeto {@code Grafo} a recorrer
	 * @return Boolean que indica si un {@code Grafo} es un árbol o no*/
	public static boolean esArbol(Grafo grafo) {
		Set <Integer> marcados = new HashSet <Integer>();
		ArrayList <Integer> pendientes = new ArrayList <Integer>();
		pendientes.add(0);
		
		while (pendientes.size() != 0) {
			int actual = pendientes.get(0);
			marcados.add(actual);
			pendientes.remove(0);
			
			for (Integer v : grafo.vecinos(actual)) {
				if (marcados.contains(v) == true)	
					return false;
			}
			
		}
		return true;
	}
	
}
