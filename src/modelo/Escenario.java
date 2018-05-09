package modelo;

import java.util.ArrayList;

public class Escenario {
	
	private String imagen;
	private Escenario siguiente;
	private ArrayList<Personaje> personaje;
	
	public Escenario(String imagen) {
		super();
		this.imagen = imagen;
	}

	public ArrayList<Personaje> getPersonaje() {
		return personaje;
	}

	public void setPersonaje(ArrayList<Personaje> personaje) {
		this.personaje = personaje;
	}

	public Escenario getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Escenario siguiente) {
		this.siguiente = siguiente;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
