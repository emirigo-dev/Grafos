package Grafos.Logica;

/**
 * <h1>Persona</h1>
 * Clase que representa a las personas participantes de la aplicación,
 *las cuales están caracterizadas por un nombre y distintos intereses.
 *
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */

public class Persona {
	private String nombre;
	private int interesMusica;
	private int interesEspectaculo;
	private int interesDeporte;
	private int interesCiencia;

	public Persona(String nombre, int musica, int Espectaculo, int deporte, int ciencia) {
		
		if (nombre.length() < 3) {
			throw new IllegalArgumentException("Tiene que ingresar un nombre de longitud minima de 3");
		} else {
			this.setNombre(nombre);
		}
		
		verificarInteres (musica, 1);
		verificarInteres (Espectaculo, 2);
		verificarInteres (deporte, 3);
		verificarInteres (ciencia, 4);

		this.interesMusica = musica;
		this.interesEspectaculo = Espectaculo;
		this.interesDeporte = deporte;
		this.interesCiencia = ciencia;
	}

	/**
	 * Método que determina la similaridad de interesese entre dos personas.
	 * @param Objeto {@code Persona} con el cual comparar y determinar similaridad
	 * @return Valor {@code int} el cual determina la similaridad 
	 * */
	public int similaridad(Persona persona) {
		int musicaSimilaridad = this.interesMusica - persona.interesMusica;
		int cienciaSimilaridad = this.interesCiencia - persona.interesCiencia;
		int matematicaSimilaridad = this.interesEspectaculo - persona.interesEspectaculo;
		int deporteSimilaridad = this.interesDeporte - persona.interesDeporte;
		return Math.abs(deporteSimilaridad) + Math.abs(musicaSimilaridad) + Math.abs(cienciaSimilaridad)
				+ Math.abs(matematicaSimilaridad);
	}

	public void verificarInteres (int interes, int pos) {
		
		String nombre = "";
		if (pos == 1)
			nombre = "musica";
		else if (pos == 2)
			nombre = "matemática";
		else if (pos == 3)
			nombre = "deporte";
		else if (pos == 4)
			nombre = "ciencia";
		
 		if (interes < 0 || interes > 5) 
			throw new IllegalArgumentException("El interes de " + nombre + " tiene que estar entre 0 y 5");
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString () {
		return nombre + "       Musica: " + interesMusica + "  Espectaculo: " + interesEspectaculo + "  Deporte: " + 
				interesDeporte + "  Ciencia: " + interesCiencia;
	}
	
}
