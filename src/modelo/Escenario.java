package modelo;

import java.util.ArrayList;

public class Escenario implements Generar{
	
	private String imagen;
	private Escenario siguiente;
	private ArrayList<Personaje> enemigos;
	private PersonajePrincipal pPrincipal;
	
	public Escenario(String imagen, PersonajePrincipal p){
		super();
		this.imagen = imagen;
		enemigos = new ArrayList<Personaje>();
		this.pPrincipal = p;
	}
	
	public PersonajePrincipal getPersonajePrincipal() {
		return pPrincipal;
	}
	
	public void setPersonajePrincipal(PersonajePrincipal p) {
		pPrincipal = p;
	}

	public ArrayList<Personaje> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Personaje> enemigos) {
		this.enemigos = enemigos;
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

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
