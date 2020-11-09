package Grafos.Logica;

/**
 * <h1>Tupla</h1>
 * Tupla es una colección de datos en la cual permite guardar una cordenada de cualquier tipo de Objeto
 * 
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */

public class Tupla <E, G> {

	private E x;
	private G y;
	
	public Tupla () {
	
	}
	
	public Tupla (E x, G y) {
		this.x = x;
		this.y = y;
	}
	
	public E getX () {
		return this.x;
	}
	
	public G getY () {
		return this.y;
	}

	public void setX(E x) {
		this.x = x;
	}

	public void setY(G y) {
		this.y = y;
	}
	
	
}
