package Grafos.Logica;

public class Tupla <E, G> {

	private E x;
	private G y;
	
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
}
