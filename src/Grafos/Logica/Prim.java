package Grafos.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>Prim</h1>
 * Prim es una clase que representa al algoritmo de Prim, que crea un árbol generador mínimo a partir de un grafo.
 * 
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */

public class Prim {
	private static Grafo agm;
	private static ArrayList<Integer> vertices;

	/**
	 * Método que ejecuta el algorimo de Prim con el fin de crear un árbol generador minimo
	 * 
	 * @param g es un objeto de tipo {@code Grafo} con el grafo a utilizar para la creación del árbol generador mínimo
	 * @param origen es una variable de tipo {@code Integer} el cual será el origen del arbol
	 * @return El método retorna un {@code Grafo} en forma de árbol generador mínimo
	 * */
	public static Grafo generadorArbolMinimo(Grafo g, int origen) {
		iniciarArbol(g, origen);
		int i = 0;
		while (i < g.tamanio()) {
			int [] aristaMinima = dameAristaMinima(g);
			if (aristaMinima[0] != aristaMinima[1]) {
				int x = aristaMinima[0];
				int y = aristaMinima[1];
				int peso = g.getA()[x][y];
				System.out.println("( " + x + " - " + y + " ) ----------- " + peso);
				agm.agregarArista(x, y, peso);
				vertices.add(y);
			}
			i++;
		}
		return agm;
	}

	
	/**
	 * Inicialización del árbol generador mínimo
	 * @param g es un objeto de tipo {@code Grafo} con el grafo a utilizar para la creación del árbol generador mínimo
	 * @param origen es una variable de tipo {@code Integer} el cual será el origen del arbol
	 * */
	private static void iniciarArbol(Grafo g, int origen) {
		agm = new Grafo(g.tamanio());
		vertices = new ArrayList<Integer>();
		vertices.add(origen);
		agm.grupoPersona = g.grupoPersona;
	}
	
	
	/**
	 * Método que busca la arista con menor peso para agregar al árbol generador mínimo
	 * @param g es un {@code Grafo} en el cual se buscará la arista menos pesada
	 * @return Devuelve un objeto {@code Tupla} con la arista más liviana
	 * */
	public static int [] dameAristaMinima(Grafo g) {
		int [] arista = new int [2];
		int peso = -1;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < g.tamanio(); j++) {
				if (vertices.get(i) != j && g.existeArista(vertices.get(i), j) && !vertices.contains(j)) {
					if (g.dameSimilaridad(vertices.get(i), j) < peso || peso == -1) {
						peso = g.dameSimilaridad(vertices.get(i), j);
						arista [0] = vertices.get(i);
						arista [1] = j;
					}
				}
			}

		}
		return arista;
	}
}
