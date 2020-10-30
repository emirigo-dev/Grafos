package Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Grafo {
	private ArrayList<Persona> P;
	private Integer[][] A;
	private int vertices;

	public Grafo(int cantidadPersona) {
		this.vertices = cantidadPersona;
		P = new ArrayList<Persona>();
		A = new Integer[vertices][vertices];
	}

	public void agregarPersonas(Persona persona) {
		P.add(persona);
	}

	public void empezarGrafo() {
		if (P.size() < 2) {
			throw new IllegalArgumentException("Por lo menos tiene que haber 3 personas");
		}
		if (P.size() > vertices) {
			throw new IllegalArgumentException("Puede ingresar las cantidad de personas que eligio antes ");
		}
		for (int i = 0; i < P.size(); i++) {
			for (int j = 0; j < P.size(); j++) {
				if (P.get(i) != P.get(j)) {
					A[i][j] = P.get(i).similaridad(P.get(j));
				}
			}
		}
	}

	public int dameSimilaridad(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		return P.get(persona1).similaridad(P.get(persona2));
	}

	public boolean existeArista(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		if (A[persona1][persona2] == null) {
			return false;
		}
		if (A[persona1][persona2] >= 0 && A[persona1][persona2] != null) {
			return true;
		}
		return false;
	}

	public void eliminarArista(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		A[persona1][persona2] = null;
		A[persona2][persona1] = null;
	}

	public void agregarArista(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		int peso = dameSimilaridad(persona1, persona2);
		A[persona1][persona2] = peso;
		A[persona2][persona1] = peso;
	}

	private void validarVertices(int persona1, int persona2) {
		verificarVertice (persona1);
		verificarVertice (persona2);
	}

	private void verificarVertice (int i) {
		if (i < 0 || i > P.size())
			throw new IllegalArgumentException(
					"El vertice de la persona, tiene que ser mayor a 0 y menor a la cantidad de vertices");
	}
	
	public int damePesoTotal() {
		int acumPeso = 0;
		for (int i = 0; i < P.size(); i++) {
			for (int j = 0; j < P.size(); j++) {
				if (A[i][j] != null) {
					acumPeso += A[i][j];
				}
			}
		}
		return acumPeso / 2;
	}
	

	public int tamanio() {
		return A.length;
	}

	public int cantidadVertices() {
		return vertices;
	}

	
	public void copiaDePersonas (Grafo grafo) {
		
		//Aseguro que se limpie la lista de personas
		P.clear();
		
		for (Persona person : grafo.P) {
			this.P.add(person);
		}
		
	}

	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamanio(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}
		
		return ret;		
	}

	
}
