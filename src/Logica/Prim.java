package Logica;

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

//	public static Grafo generadorArbolMinimo(Grafo g, int origen) {
//		System.out.println("Soy un origen " + origen);
//		Set<Integer> pendientes = new HashSet<Integer>();
//		Set<Integer> marcados = new HashSet<Integer>();
//
//		for (int i = 0; i < g.tamanio(); i++) {
//			pendientes.add(i);
//		}
//
//		pendientes.remove(origen);
//		marcados.add(origen);
//		iniciarArbol(g);
//
//		while (pendientes.size() > 0) {
//			int vertice = aristaMenorPeso(origen, g, marcados);
//			agm.agregarArista(origen, vertice);
//			System.out.println("[" + origen + " " + vertice + " ] ------- " + g.pesoArista(origen, vertice));
//			origen = vertice;
//			pendientes.remove(origen);
//			marcados.add(origen);
//		}
//
//		return agm;
//	}
//
//	public static int aristaMenorPeso(int origen, Grafo g, Set marcados) {
//		Set<Integer> vecinos = g.vecinos(origen);
//		ArrayList<Integer> noMarcados = (ArrayList<Integer>) vecinos.stream().filter(v -> !marcados.contains(v))
//				.collect(Collectors.toList());
//
//		if (noMarcados.size() == 0)
//			return -1;
//
//		int puntero = noMarcados.get(0);
//		for (int i = 1; i < noMarcados.size(); i++) {
//			if (g.pesoArista(origen, puntero) > g.pesoArista(origen, noMarcados.get(i)))
//				puntero = noMarcados.get(i);
//		}
//
//		return puntero;
//
//	}

//	public static Grafo generadorArbolMinimo(Grafo g, int origen) {
//		iniciarArbol(g, origen);
//		int i = 0;
//		while (i < g.tamanio() - 1) {
//			ArrayList<Integer> aristasLlegan = dameAristaMinima(g);
//			if (aristasLlegan.get(0) != aristasLlegan.get(1)) {
//				agm.agregarArista(aristasLlegan.get(0), aristasLlegan.get(1));
//				System.out.print(aristasLlegan + " --- ");
//				System.out.println(g.pesoArista(aristasLlegan.get(0), aristasLlegan.get(1)));
//				vertices.add(aristasLlegan.get(1));
//			}
//			i++;
//		}
//		return agm;
//	}
//
//	public static ArrayList<Integer> dameAristaMinima(Grafo g) {
//		ArrayList<Integer> arista = new ArrayList<>();
//		int peso = -1;
//		for (int i = 0; i < vertices.size(); i++) {
//			for (int j = 0; j < g.tamanio(); j++) {
//				if (vertices.get(i) != j && g.existeArista(vertices.get(i), j) && !vertices.contains(j)) {
//					if (g.dameSimilaridad(vertices.get(i), j) < peso || peso == -1) {
//						peso = g.dameSimilaridad(vertices.get(i), j);
//						if (arista.size() >= 1) {
//							arista.clear();
//						}
//						arista.add(i);
//						arista.add(j);
//					}
//				}
//			}
//		}
//		
//		return arista;
//
//	}
	public static Grafo generadorArbolMinimo(Grafo g, int origen) {
		iniciarArbol(g, origen);
		int i = 0;
		while (i < g.tamanio() - 1) {
			int []aristasLlegan = dameAristaMinima(g);
			if (aristasLlegan[0] != aristasLlegan[1]) {
				int peso = g.getGrupoPersona().get(aristasLlegan[0]).similaridad(g.getGrupoPersona().get(aristasLlegan[0]));
				agm.agregarArista(aristasLlegan[0], aristasLlegan[1], peso);
				System.out.print(aristasLlegan[0]+","+aristasLlegan[1] + " --- ");
				System.out.println(g.pesoArista(aristasLlegan[0], aristasLlegan[1]));
				vertices.add(aristasLlegan[1]);
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
