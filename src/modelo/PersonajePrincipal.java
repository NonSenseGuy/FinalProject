package modelo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PersonajePrincipal extends Personaje implements Disparar{
	
	public final static String IMAGEN= "./img/personajePrincipal.png";
	public final  int ANCHO_IMAGEN = new ImageIcon(IMAGEN).getIconWidth();
	public final static int VIDA = 100;
	public final static int VELOCIDAD = 2;
	private Arma primera;
	private Arma elegida;
	

	public PersonajePrincipal(int posX, String imagen) {
		super(VIDA, posX, imagen);
		setHitBox();
	}

	public Arma getArmaPrimera() {
		return primera;
	}

	public void setArmaPrimera(Arma arma) {
		this.primera = arma;
	}
	
	public Arma getArmaElegida() {
		return elegida;
	}
	
	public void setArmaElegida(Arma arma) {
		elegida = arma;
	}
	
	public void agregarArma(Arma arma) {
		if(primera == null) {
			primera = arma;
		}else if(primera.getSiguiente() == null) {
			primera.setSiguiente(arma);
			arma.setSiguiente(primera);
			primera.setAnterior(arma);
			arma.setAnterior(primera);
		}else {
			Arma anterior = primera.getAnterior();
			primera.setAnterior(arma);
			arma.setAnterior(anterior);
			arma.setSiguiente(primera);
		}
	}
	
	

	@Override
	public void disparar(int direccion) {
		if(elegida instanceof ArmaTiro) {
			if(direccion == KeyEvent.VK_RIGHT) {
				Bala balaDisparada = ((ArmaTiro)elegida).dispararBala(getPosX());
				balaDisparada.setVelocidad(balaDisparada.VELOCIDAD_BALA);
			}else if(direccion == KeyEvent.VK_LEFT){
				Bala balaDisparada = ((ArmaTiro)elegida).dispararBala(getPosX()-5);
					balaDisparada.setVelocidad(-balaDisparada.VELOCIDAD_BALA);
			}
		}	
	}

	
	
	
	
}
