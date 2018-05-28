package modelo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PersonajePrincipal extends Personaje implements Disparar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			anterior.setSiguiente(arma);
		}
	}
	
	
	//Para mantener el tiempo entre bala y bala
	//quitar el dano de la bala y la imagen despues de que colisione con el primer zombie
	@Override
	public void disparar(int direccion) {
			if(direccion == KeyEvent.VK_RIGHT) {
				if(elegida instanceof ArmaTiro) {
					if(((ArmaTiro)elegida).getBala() == null) {
						((ArmaTiro)elegida).dispararBala(getPosX());
						Bala balaDisparada = ((ArmaTiro) elegida).getBala();
						balaDisparada.setVelocidad(balaDisparada.VELOCIDAD_BALA);
					}
				}else if(elegida instanceof RayGun) {
					if(((RayGun)elegida).getBala() == null) {
						((RayGun)elegida).dispararBala(getPosX()+5);
						Bala balaDisparada = ((RayGun)elegida).getBala();
						balaDisparada.setVelocidad(RayGun.VELOCIDAD_BALA);
					}
				}
				 
				
			}else if(direccion == KeyEvent.VK_LEFT){
				if(elegida instanceof ArmaTiro) {
					if(((ArmaTiro)elegida).getBala() == null) {
						((ArmaTiro)elegida).dispararBala(getPosX()-5);
						Bala balaDisparada = ((ArmaTiro)elegida).getBala();
						balaDisparada.setVelocidad(-balaDisparada.VELOCIDAD_BALA);
					}
				}else if(elegida instanceof RayGun) {
					if(((RayGun)elegida).getBala() == null) {
						((RayGun)elegida).dispararBala(getPosX()-5);
						Bala balaDisparada = ((RayGun)elegida).getBala();
						balaDisparada.setVelocidad(-RayGun.VELOCIDAD_BALA);
					}
				}
				 
				
			}	
	}

	@Override
	public void dispararBala(int posX) {
		// TODO Auto-generated method stub
		
	}	
}
