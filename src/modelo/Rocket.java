package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite tener una instancia de un arma tipo Rocket
 */
public class Rocket extends Arma {

	private static final long serialVersionUID = 1L;
	public final static int DAMAGE_ROCKET = 100;
	public final static int VELOCIDAD_BALA = 2;
	
	public final static String IMAGEN_ROCKET = "./img/rocket.png";
	private int radioExplocion;
	private Bala bala;
	/**
	 * Constructor de la clase Rocket
	 * @param nombre
	 * @param ammo
	 * @param imagen
	 * @param radioExplosion
	 */
	public Rocket(String nombre, int ammo, String imagen, int radioExplosion) {
		super(nombre,DAMAGE_ROCKET, ammo, imagen);
		this.radioExplocion = radioExplosion;
	}

	public int getRadioExplocion() {
		return radioExplocion;
	}

	public void setRadioExplocion(int radioExplocion) {
		this.radioExplocion = radioExplocion;
	}
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoRocket.png", posX, getDamage());
	}
	
	public Bala getBala() {
		return bala;
	}

	public void setBala(Bala bala) {
		this.bala = bala;
	}
}
