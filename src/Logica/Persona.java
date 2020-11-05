package Logica;

public class Persona {
	private String nombre;
	private int interesMusica;
	private int interesMatematica;
	private int interesDeporte;
	private int interesCiencia;

	public Persona(String nombre, int musica, int matematica, int deporte, int ciencia) {
		if (nombre.length() < 3) {
			throw new IllegalArgumentException("Tiene que ingresar un nombre de longitud minima de 3");
		} else {
			this.setNombre(nombre);
		}
		if (musica < 0 || musica > 5) {
			throw new IllegalArgumentException("El interes de la musica tiene que estar entre 0 y 5");
		} else {

			this.interesMusica = musica;
		}
		if (matematica < 0 || matematica > 5) {
			throw new IllegalArgumentException("El interes por las matematicas tiene que estar entre 0 y 5");
		} else {
			this.interesMatematica = matematica;
		}
		if (deporte < 0 || deporte > 5) {
			throw new IllegalArgumentException("El interes del deporte tiene que estar entre 0 y 5");
		} else {
			this.interesDeporte = deporte;
		}
		if (ciencia < 0 || ciencia > 5) {
			throw new IllegalArgumentException("El interes de la ciencia tiene que estar entre 0 y 5");
		} else {
			this.interesCiencia = ciencia;
		}

	}

	public int similaridad(Persona persona) {
		int musicaSimilaridad = this.interesMusica - persona.interesMusica;
		int cienciaSimilaridad = this.interesCiencia - persona.interesCiencia;
		int matematicaSimilaridad = this.interesMatematica - persona.interesMatematica;
		int deporteSimilaridad = this.interesDeporte - persona.interesDeporte;
		return Math.abs(deporteSimilaridad) + Math.abs(musicaSimilaridad) + Math.abs(cienciaSimilaridad)
				+ Math.abs(matematicaSimilaridad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString () {
		return nombre + "       Musica: " + interesMusica + "  Matemática: " + interesMatematica + "  Deporte: " + 
				interesDeporte + "  Ciencia: " + interesCiencia;
	}
	
}
