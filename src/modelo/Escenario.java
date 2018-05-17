package modelo;

import java.util.ArrayList;

public class Escenario {
	
	private String imagen;
	private Escenario siguiente;
	private ArrayList<Personaje> personajes;
	
	public Escenario(String imagen, PersonajePrincipal p) {
		super();
		this.imagen = imagen;
		personajes = new ArrayList<Personaje>();
		personajes.add(p);
	}

	public ArrayList<Personaje> getPersonaje() {
		return personajes;
	}

	public void setPersonaje(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
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
