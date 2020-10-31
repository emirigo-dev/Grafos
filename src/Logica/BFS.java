package Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	public static Set<Integer> alcanzables (Grafo grafo, int origen){
		
		Set <Integer> marcados = new HashSet <Integer>();
		ArrayList <Integer> pendientes = new ArrayList <Integer>();
		pendientes.add(origen);
		
		while (pendientes.size() != 0) {
			int actual = pendientes.get(0);
			marcados.add(actual);
			pendientes.remove(0);
			
			for (Integer v : grafo.vecinos(actual)) {
				if (marcados.contains(v) == false)
						pendientes.add(v);
			}
		}
		
		return marcados;
	}

	public static boolean esArbol(Grafo grafo) {
		// TODO Auto-generated method stub
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
