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
	 * 
	 * <b>Pre:</b> La clase Personaje Principal, Juego Modelo y Escenario deben estar inicializadads
	 * 
	 * @param nombre: Nombre del arma
	 * @param imagen: direccion de la imagen que tendra el rocket en la interfaz grafica
	 * @param radioExplosion: el radio de explosion que las balas van a tener en el rocket en cuestion de pixeles
	 */
	public Rocket(String nombre, String imagen, int radioExplosion) {
		super(nombre,DAMAGE_ROCKET, imagen);
		this.radioExplocion = radioExplosion;
	}
	/**
	 * Permite retornar el radio de explosion que las balas van a tener en el rocket en cuestion de pixeles
	 * @return radioExplosion : Retorna un entero con el radio de explosion que tendran las balas de esta arma
	 */
	public int getRadioExplocion() {
		return radioExplocion;
	}
	/**
	 * Permite modificar el radio de explosionque las balas tendran al impactar
	 * @param radioExplocion: Entero, que sera el nuevo radio de explosion
	 */
	public void setRadioExplocion(int radioExplocion) {
		this.radioExplocion = radioExplocion;
	}
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoRocket.png", posX, getDamage());
	}
	/**
	 * Permite retornar la bala del arma que contiene el daño que hace el arma
	 * @return: bala: Objeto tipo bala que contiene el daño que hace el arma, la imagen de la bala y una posicion en X
	 */	
	public Bala getBala() {
		return bala;
	}
	/**
	 * Permite modificar la variable bala que es tipo Bala
	 * @param bala: bala nueva del Rocket
	 */
	public void setBala(Bala bala) {
		this.bala = bala;
	}
}
