package modelo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite tener una instancia de un Personaje tipo Personaje Principal
 */
public class PersonajePrincipal extends Personaje implements Disparar{
	
	private static final long serialVersionUID = 1L;
	public final static String IMAGEN= "./img/personajePrincipal.png";
	public final  int ANCHO_IMAGEN = new ImageIcon(IMAGEN).getIconWidth();
	public final static int VIDA = 100;
	public final static int VELOCIDAD = 2;
	
	private Arma primera;
	private Arma elegida;
	/**
	 * Permite crear una instancia del personaje principal
	 * @param posX: La posicion en X la cual se encuentra el personaje principal
	 * @param imagen: direccion de la imagen que tendra el personaje principal en la interfaz grafica
	 */
	public PersonajePrincipal(int posX, String imagen) {
		super(VIDA, posX, imagen);
		setHitBox();
	}
	/**
	 * Permite retornar la raiz de una lista ciclica de armas
	 * @return arma: retorna la raiz de una lista ciclica de objetos tipo Arma.
	 */
	public Arma getArmaPrimera() {
		return primera;
	}
	/**
	 * Permite modificar la raiz de la lista ciclica de objetos tipo Arma
	 * 
	 * <b>post: </b> se ha cambiado la raiz de la lista ciclica
	 * 
	 * @param arma: Nueva raiz de arma de una lista ciclica y  arma != null
	 */
	public void setArmaPrimera(Arma arma) {
		this.primera = arma;
	}
	/**
	 * Retorna el arma elegida, el arma el cual esta usando el personaje principal
	 * @return elegida: Objeto tipo arma la cual esta utilizando el personaje principal
	 */
	public Arma getArmaElegida() {
		return elegida;
	}
	/**
	 * Modifica el arma elegida, osea el arma usada por el personaje principal
	 * @param arma: Nueva arma que va a utilizar el jugador principal y arma != null
	 */
	public void setArmaElegida(Arma arma) {
		elegida = arma;
	}
	
	/**
	 * Permite agregar una nueva arma a la lisa enlazada de armas, si el incio de la lista enlazada es nula, pasa a ser la nueva arma, sino se agrega en
	 * el siguiente del ultimo
	 * 
	 * @param arma: Nueva arma que se va a agregar a la lista enlazada de armas y arma != null
	 */
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
	
	@Override
	public void disparar(int direccion) {
			if(direccion == KeyEvent.VK_RIGHT) {
				if(elegida instanceof ArmaTiro) {
					if(((ArmaTiro)elegida).getBala() == null) {
						((ArmaTiro)elegida).dispararBala(getPosX());
						Bala balaDisparada = ((ArmaTiro) elegida).getBala();
						balaDisparada.setVelocidad(ArmaTiro.VELOCIDAD_BALA);
					}
				}else if(elegida instanceof RayGun) {
					if(((RayGun)elegida).getBala() == null) {
						((RayGun)elegida).dispararBala(getPosX()+5);
						Bala balaDisparada = ((RayGun)elegida).getBala();
						balaDisparada.setVelocidad(RayGun.VELOCIDAD_BALA);
					}
				}else if(elegida instanceof Rocket) {
					if(((Rocket)elegida).getBala() == null) {
						((Rocket)elegida).dispararBala(getPosX()+5);
						Bala balaDisparada = ((Rocket)elegida).getBala();
						balaDisparada.setVelocidad(Rocket.VELOCIDAD_BALA);
					}
				}
				 
				
			}else if(direccion == KeyEvent.VK_LEFT){
				if(elegida instanceof ArmaTiro) {
					if(((ArmaTiro)elegida).getBala() == null) {
						((ArmaTiro)elegida).dispararBala(getPosX()-5);
						Bala balaDisparada = ((ArmaTiro)elegida).getBala();
						balaDisparada.setVelocidad(-ArmaTiro.VELOCIDAD_BALA);
					}
				}else if(elegida instanceof RayGun) {
					if(((RayGun)elegida).getBala() == null) {
						((RayGun)elegida).dispararBala(getPosX()-5);
						Bala balaDisparada = ((RayGun)elegida).getBala();
						balaDisparada.setVelocidad(-RayGun.VELOCIDAD_BALA);
					}
				}else if(elegida instanceof Rocket) {
					if(((Rocket)elegida).getBala() == null) {
						((Rocket)elegida).dispararBala(getPosX()-5);
						Bala balaDisparada = ((Rocket)elegida).getBala();
						balaDisparada.setVelocidad(-Rocket.VELOCIDAD_BALA);
					}
				}
			}
		}

	@Override
	public void dispararBala(int posX) {		
	}	
}
