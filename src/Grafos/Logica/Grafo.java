package Grafos.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Grafo {
	protected ArrayList<Persona> grupoPersona;
	private Integer[][] A;
	private int vertices;

	public Grafo(int cantidadPersona) {
		this.vertices = cantidadPersona;
		grupoPersona = new ArrayList<Persona>();
		A = new Integer[vertices][vertices];
	}

	public void agregarPersonas(Persona persona) {
		grupoPersona.add(persona);
	}

	public void empezarGrafo() {
		if (grupoPersona.size() < 2) {
			throw new IllegalArgumentException("Por lo menos tiene que haber 3 personas");
		}
		if (grupoPersona.size() > vertices) {
			throw new IllegalArgumentException("Puede ingresar las cantidad de personas que eligio antes ");
		}
		for (int i = 0; i < grupoPersona.size(); i++) {
			for (int j = 0; j < grupoPersona.size(); j++) {
				if (grupoPersona.get(i) != grupoPersona.get(j)) {
					int peso = grupoPersona.get(i).similaridad(grupoPersona.get(j));
					agregarArista(i,j,peso);
				}
			}
		}
	}

	public int dameSimilaridad(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		return grupoPersona.get(persona1).similaridad(grupoPersona.get(persona2));
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

	public void agregarArista(int persona1, int persona2, int peso) {
		validarVertices(persona1, persona2);
		A[persona1][persona2] = peso;
		A[persona2][persona1] = peso;
	}

	private void validarVertices(int persona1, int persona2) {
		verificarVertice(persona1);
		verificarVertice(persona2);
	}

	private void verificarVertice(int i) {
		if (i < 0 || i > grupoPersona.size())
			throw new IllegalArgumentException(
					"El vertice de la persona, tiene que ser mayor a 0 y menor a la cantidad de vertices");
	}

	public int damePesoTotal() {
		int acumPeso = 0;
		for (int i = 0; i < grupoPersona.size(); i++) {
			for (int j = 0; j < grupoPersona.size(); j++) {
				if (A[i][j] != null) {
					acumPeso += A[i][j];
				}
			}
		}
		return acumPeso / 2;
	}

	public int pesoArista(int i, int j) {
		return this.A[i][j];
	}

	public int tamanio() {
		return A.length;
	}

	public Set<Integer> vecinos(int i) {
		verificarVertice(i);

		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < this.tamanio(); ++j)
			if (i != j) {
				if (this.existeArista(i, j))
					ret.add(j);
			}

		return ret;
	}

	public Integer[][] getA() {
		return A;
	}

	public void eliminarAristaMasPesada() {
		int pesoMaximo = -1;
		int[] vertice = new int[2];
		for (int i = 0; i < grupoPersona.size(); i++) {
			for (int j = 0; j < grupoPersona.size(); j++) {
				if (A[i][j] != null && i!=j && pesoMaximo < A[i][j]) {
					pesoMaximo = A[i][j];
					vertice[0] = i;
					vertice[1] = j;
				}
			}
		}
		System.out.println("M�s pesada ( " + vertice [0] + " -- " + vertice [1] + " )");
		eliminarArista(vertice[0], vertice[1]);
	}
	
	public ArrayList<Persona> getGrupoPersona (){
		return grupoPersona;
	}
	
	public int getVertices () {
		return this.vertices;
	}

}