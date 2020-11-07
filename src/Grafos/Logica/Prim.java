package Grafos.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prim {
	private static Grafo agm;
	private static ArrayList<Integer> vertices;

	private static void iniciarArbol(Grafo g, int origen) {
		agm = new Grafo(g.tamanio());
		vertices = new ArrayList<Integer>();
		vertices.add(origen);
		agm.grupoPersona = g.grupoPersona;
	}

	public static ArrayList<Integer> imprimirvertices() {
		return vertices;
	}

	public static Grafo generadorArbolMinimo(Grafo g, int origen) {
		iniciarArbol(g, origen);
		int i = 0;
		while (i < g.tamanio()) {
			int []aristaMinima = dameAristaMinima(g);
			if (aristaMinima[0] != aristaMinima[1]) {
				int peso = g.getA()[aristaMinima[0]][aristaMinima[1]];
				System.out.println("( " + aristaMinima [0] + " - " + aristaMinima [1] + " ) ----------- " + peso);
				agm.agregarArista(aristaMinima[0], aristaMinima[1], peso);
				vertices.add(aristaMinima[1]);
			}
			i++;
		}
		return agm;
	}

	public static int[] dameAristaMinima(Grafo g) {
		int[] arista = new int[2];
		int peso = -1;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < g.tamanio(); j++) {
				if (vertices.get(i) != j && g.existeArista(vertices.get(i), j) && !vertices.contains(j)) {
					if (g.dameSimilaridad(vertices.get(i), j) < peso || peso == -1) {
						peso = g.dameSimilaridad(vertices.get(i), j);
						arista[0] = vertices.get(i);
						arista[1] = j;
					}
				}
			}

		}
		return arista;
	}
}
