package modelo;

import java.util.ArrayList;

public class Escenario {
	
	public final int FINAL_ESCENARIO = 1300;
	public final int INICIO_ESCENARIO = -100;
	public final static String[] ESCENARIOS = { "./img/background2.png", "./img/background3.png", "./img/background4.png"};
	private String imagen;
	private Escenario siguiente;
	private Boss[] boss;
	private PersonajePrincipal pPrincipal;

	
	public Escenario(String imagen, PersonajePrincipal p, int nivel){
		this.imagen = imagen;
		boss = new Boss[nivel];
		for(int i = 0; i < boss.length; i++) {
			boss[0] = new Boss(Boss.VIDA+(50*nivel), getPosicionBoss(),Boss.IMAGEN_BOSS, Boss.DANO, Boss.RADIO_ATAQUE );
		}
		this.pPrincipal = p;
		
	}
	
	public PersonajePrincipal getPersonajePrincipal() {
		return pPrincipal;
	}
	
	public void setPersonajePrincipal(PersonajePrincipal p) {
		pPrincipal = p;
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
	
	public int getPosicionBoss() {
		double pos; 
		pos = Math.random();
		if(pos > 0.5) {
			return FINAL_ESCENARIO + (int) (Math.random()*300);
		}else {
			return INICIO_ESCENARIO - (int) (Math.random()*300);
		}
	}
	
	public Boss[] getBoss() {
		return boss;
	}
	
	public void setBoss(Boss[] b) {
		boss = b;
	}

	
	
}
