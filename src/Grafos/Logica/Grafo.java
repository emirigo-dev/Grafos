package Grafos.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * <h1>Grafo</h1>
 * La clase {@code Grafo} representa a la estructura de datos que llevará a cabo el proyecto
 * 
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */


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

	/**
	 * Dado un objeto {@code Grafo}, los cuales se encuentra seteados los vertices, genera un {@code Grafo} completo.
	 * */
	public void grafoCompleto() {
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

	/**
	 * Método que busca la similaridad de dos Personas que componen el grafo
	 * @param persona1 es una variable int que representa un vertice del {@code Grafo}
	 * @param persona2 es una variable int que representa un vertice del {@code Grafo}
	 * @return Devuelve la similaridad entre dos personas del {@code Grafo}
	 * */
	public int dameSimilaridad(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		return grupoPersona.get(persona1).similaridad(grupoPersona.get(persona2));
	}

	/**
	 * Método que busca la existencia de una arista en el {@code Grafo}
	 * @param persona1 es una variable int que representa un vertice del {@code Grafo}
	 * @param persona2 es una variable int que representa un vertice del {@code Grafo}
	 * @return Devuelve un booleano que confirma o refuta la existencia de una arista
	 * */
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

	/**
	 * Método que elimina una arista del Grafo
	 * @param persona1 es una variable int que representa un vertice del {@code Grafo}
	 * @param persona2 es una variable int que representa un vertice del {@code Grafo}
	 * */
	public void eliminarArista(int persona1, int persona2) {
		validarVertices(persona1, persona2);
		A[persona1][persona2] = null;
		A[persona2][persona1] = null;
	}

	/**
	 * Método que agrega una arista del Grafo
	 * @param persona1 es una variable int que representa un vertice del {@code Grafo}
	 * @param persona2 es una variable int que representa un vertice del {@code Grafo}
	 * */
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

	
	/**
	 * Método que devuelve el peso total del {@code Grafo}. Se llama peso total a la suma de los pesos de todas las aristas que componen el {@code Grafo}
	 * @return Devuelve una variable int con el peso total del {@code Grafo}
	 * */
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

	/**
	 * Método que busca el peso de una arista
	 * @param i es una variable int que representa un vertice del {@code Grafo}
	 * @param j es una variable int que representa un vertice del {@code Grafo}
	 * @return Devuelve el peso de la arista en una variable int
	 * */
	public int pesoArista(int i, int j) {
		validarVertices (i,j);
		return this.A[i][j];
	}

	/**
	 * Método que busca el tamaño total del {@code Grafo}
	 * @return Tamaño del {@code Grafo}
	 * */
	public int tamanio() {
		return A.length;
	}

	/**
	 * Método que busca los vecinos de una {@code Persona} que compone el {@code Grafo}
	 * @param i es una variable int que representa un vertice del {@code Grafo}
	 * @return Una estructura de datos {@code Set<Integer>} con los vertices vecinos a i*/
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
	
	/**
	 * Método que busca la cantidad de vecinos de una {@code Persona}
	 * @param i es una variable int que representa un vertice del {@code Grafo}
	 * @return Cantidad de vecinos de i en una variable int
	 * */
	public int cantidadDeVecinos (int i) {
		return vecinos(i).size();
	}

	/**
	 * Método que elimina la arista con mayor peso del {@code Grafo}
	 * */
	public void eliminarAristaMasPesada() {
		int [] arista = new int [2];
		int pesoMaximo = -1;
		for (int i = 0; i < grupoPersona.size(); i++) {
			for (int j = 0; j < grupoPersona.size(); j++) {
				if (A[i][j] != null && i!=j && pesoMaximo <= A[i][j]) {
					if (A[i][j] > pesoMaximo) {
						arista[0] = i;
						arista[1] = j;
						pesoMaximo = A[i][j];
					}
				}
			}
		}
			eliminarArista(arista[0], arista[1]);
	}
	
	/**
	 * Método que busca dividir el grafos conexos
	 * @param grafo es un objeto {@code Grafo} a divir
	 * @return Una lista de conjuntos {@code ArrayList<Set<Integer>>} el cual contiene
	 *  cada conjunto represente la división de un grafo y contiene los vertices correspondientes*/
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
	
	public ArrayList<Persona> getGrupoPersona (){
		return grupoPersona;
	}
	
	public int getVertices () {
		return this.vertices;
	}
	
	public Integer[][] getA() {
		return A;
	}

}
