package modelo;

import java.awt.event.KeyEvent;

public class PersonajePrincipal extends Personaje implements Disparar{
	
	public final static String IMAGEN= "./img/personajePrincipal.png";
	public final static int VIDA = 100;
	public final static int VELOCIDAD = 2;
	private Arma arma;
	

	public PersonajePrincipal(int posX, String imagen) {
		super(VIDA, posX, imagen);
		setHitBox();
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	

	@Override
	public void disparar(int direccion) {
		if(arma instanceof ArmaTiro) {
			if(direccion == KeyEvent.VK_RIGHT) {
				Bala balaDisparada = ((ArmaTiro)arma).dispararBala(getPosX());
					balaDisparada.moverBala(10);
			}else if(direccion == KeyEvent.VK_LEFT){
				Bala balaDisparada = ((ArmaTiro)arma).dispararBala(getPosX()-5);
					balaDisparada.moverBala(-10);
			}
		}	
	}
	
	
}
