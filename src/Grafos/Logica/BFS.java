package Grafos.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	private static ArrayList<Integer> L;
	private static boolean marcados[];

	public static boolean esConexo(Grafo g) {
		if (g == null) {
			throw new IllegalArgumentException();
		}
		if (g.getVertices() == 0) {
			return true;
		}
		return alcanzables(g, 0).size() == g.getVertices();
	}


	
	public static Set<Integer> recorrerGrafoCompleto(Grafo g, int origen) {
		Set<Integer> ret = new HashSet<Integer>();
		while (origen < g.getVertices()) {
			inicializar(g, origen);
			while (L.size() > 0) {
				int i = L.get(0);
				marcados[i] = true;
				agregarVecinosPendientes(g, i);
				ret.add(i);
				L.remove(0);
				origen++;
			}

		}
		return ret;
	}

	
	public static Set<Integer> alcanzables(Grafo g, int origen) {

		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);
		while (L.size() > 0) {
			int i = L.get(0);
			marcados[i] = true;
			ret.add(i);
			agregarVecinosPendientes(g, i);
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
	
	public static ArrayList<Set <Integer>> dividirGrafo (Grafo grafo) {
        ArrayList <Set <Integer>> grafos = new ArrayList <Set <Integer>>();
        
        if (BFS.esConexo(grafo)){
            grafos.add(BFS.alcanzables(grafo, 0));
        }
        else {
            ArrayList <Integer> pendientes = new ArrayList<Integer>();
            
            for (int i = 0; i < grafo.getVertices(); i++){
                pendientes.add(i);
            }
            while (pendientes.size() > 0) {
                grafos.add(BFS.alcanzables(grafo, pendientes.get(0)));
                pendientes.removeAll(BFS.alcanzables(grafo, pendientes.get(0)));
                
            }
        }
        return grafos;
    }
}
