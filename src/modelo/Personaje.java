package modelo;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase padre de personaje principal, zombie y boss
 */
public abstract class Personaje implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public final static int ANCHO = 60;
	public final static int ALTO = 60;
	public final static int POS_Y = 500;
	
	private int vida;
	private int posX;
	private String imagen;
	private Rectangle2D hitBox;
	private int velocidad;
	/**
	 * Constructor padre de las clases personaje principal, zombie y boss
	 * 
	 * @param vida: Vida del personaje
	 * @param posX: posicion en la que va el personaje
	 * @param imagen: direccion de la imagen que tendra el personaje en la interfaz grafica
	 */
	public Personaje(int vida, int posX, String imagen) {
		this.vida = vida;
		this.posX = posX;
		this.imagen = imagen;
		setHitBox();
		velocidad = 0;
	}
	/**
	 * Permite retornar la velocidad con la que se mueven los personajes.
	 * @return velocidad: velocidad actual del personaje
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * Permite modificar la velocidad con la cual se mueven los personajes
	 * @param velocidad: Nueva velocidad del personaje y velocidad != null
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * Permite retornar la vida actual del personaje
	 * @return vida: vida actual del personaje
	 */
	public int getVida() {
		return vida;
	}
	/**
	 * Permite modificar la vida actual del personaje
	 * @param vida: Nueva vida actual del personaje y vida != null
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}
	/**
	 * Permite retornar la posicion en X actual del personaje
	 * @return posX: Posicion actual del personaje
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * Permite modificar la posicion actual del personaje y acomodar el hitBox deacuerdo a la nueva posicion
	 * @param posX: nueva posicion del personaje y posX != null
	 */
	public void setPosX(int posX) {
		this.posX = posX;
		setHitBox();
	}
	/**
	 * Permite retornar la ruta de la imagen del personaje
	 * @return image: imagen actual del personaje que se muestra en la interfaz grafica
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Permite modificar la ruta de la imagend el personaje
	 * @param imagen: Nueva ruta de la imagen que se muestra en la interfaz grafica, imagen != null y imagen != ""
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * Permite modificar el hitBox del personaje que va deacuerdo a su posicion en X y sus constantes de Y, ancho y alto
	 */
	public void setHitBox() {
		hitBox = new Rectangle2D.Double(posX, POS_Y, ANCHO, ALTO);
	}
	/**
	 * Permite retornar el hitBox del personaje
	 * @return hitBox: Es el hitBox del personaje que va de acuerdo a su posicion en X
	 */
	public Rectangle2D getHitBox() {
		return hitBox;
	}
	/**
	 * Permite mover le personaje por el eje X y reacomodar su hitBox deacuerdo a su nueva posicion
	 * @param distancia: Distancia deseada que se quiere que recorra el personaje, distancia != null
	 */
	public void moverPersonaje(int distancia) {
		setPosX(getPosX() + distancia);
		setHitBox();
	}


	
}
