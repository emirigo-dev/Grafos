package Logica;

import java.util.ArrayList;

public class Prim {
	private static Grafo agm;
	private static ArrayList<Integer> vertices;

	private static void iniciarArbol(Grafo g, int origen) {
		agm = new Grafo(g.tamanio());
		vertices = new ArrayList<Integer>();
		vertices.add(origen);
		agm.grupoPersona = g.grupoPersona;
	}

	public static Grafo generadorArbolMinimo(Grafo g, int origen) {
		iniciarArbol(g, origen);
		int i = 0;
		while (i < g.tamanio() - 1) {
			ArrayList<Integer> aristasLlegan = dameAristaMinima(g);
			if (aristasLlegan.get(0) != aristasLlegan.get(1)) {
				agm.agregarArista(aristasLlegan.get(0), aristasLlegan.get(1));
				vertices.add(aristasLlegan.get(1));
			}
			i++;
		}
		return agm;
	}

	public static ArrayList<Integer> dameAristaMinima(Grafo g) {
		ArrayList<Integer> arista = new ArrayList<>();
		int peso = -1;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < g.tamanio(); j++) {
				if (vertices.get(i) != j && g.existeArista(vertices.get(i), j) && !vertices.contains(j)) {
					if (g.dameSimilaridad(vertices.get(i), j) < peso || peso == -1) {
						peso = g.dameSimilaridad(vertices.get(i), j);
						if (arista.size() >= 1) {
							arista.clear();
						}
						arista.add(i);
						arista.add(j);
					}
				}
			}
		}
		return arista;

	}

}
