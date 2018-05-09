package modelo;

import java.awt.event.ActionEvent;

public class PersonajePrincipal extends Personaje implements Disparar{
	
	public final int VIDA = 100;
	private Arma arma;

	public PersonajePrincipal(int vida, int posX, int posY, String imagen) {
		super(vida, posX, posY, imagen);
		// TODO Auto-generated constructor stub
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public void moverPersonaje(ActionEvent e) {
		
	}
	
	public void disparar(ActionEvent e) {
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
}
