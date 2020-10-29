package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {
	private ArrayList<Persona> P;
	private Integer[][] A;
	private int vertices;

	// private Persona p = new Persona("Emiliano", 2, 1, 3, 2);
//	private Persona p1 = new Persona("Rigobello", 3, 1, 3, 2);
//	private Persona p2 = new Persona("Pedro", 4, 3, 1, 1);
//	private Persona p3 = new Persona("Gonzalo", 1, 1, 3, 1);

	Grafo(int cantidadPersona) {
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
		int lugarVacio = -1;
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
		if(A[persona1][persona2] == null) {
			return false;
		}
		if (A[persona1][persona2] >= 0 && A[persona1][persona2] != null) {
			return true;
		}
		return false;
	}
	public void eliminarArista(int persona1, int persona2) {
		validarVertices(persona1,persona2);
		A[persona1][persona2] = null;
		A[persona2][persona1] = null;
	}

	private void validarVertices(int persona1, int persona2) {
		if (persona1 < 0 || persona1 >= P.size()) {
			throw new IllegalArgumentException(
					"El vertice de la persona, tiene que ser mayor a 0 y menor a la cantidad de vertices");
		}
		if (persona2 < 0 || persona2 >= P.size()) {
			throw new IllegalArgumentException(
					"El vertice de la persona, tiene que ser mayor a 0 y menor a la cantidad de vertices");
		}

	}
	public int tamanio() {
		return A.length;
	}
	public int cantidadVertices() {
		return vertices;
	}

}
