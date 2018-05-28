package modelo;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.ImageIcon;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite inicializar una bala que cambia su aspecto,d a�o y velocidad dependiendo del arma
 */
public class Bala implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String imagenBala;
	private int damage;
	private Rectangle2D hitBox;
	private int posX;
	private int velocidad;

	/**
	 * Constructor que permite inicializar una bala
	 * @param imagenBala: Ruta de la imagen de la bala dependiendo dela rma
	 * @param posX: Posicion de la bala en el eje X
	 * @param damage: Da�o de la bala respecto al arma
	 */
	public Bala(String imagenBala, int posX, int damage) {
		this.imagenBala = imagenBala;
		this.damage = damage;
		this.posX = posX;
		setHitBox();
		velocidad = 0;
	}
	/**
	 * Permite retornar la velocidad dela bala
	 * @return velocidad : Velocidad de la bala != null
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * Permite modificar la velocidad de la bala
	 * @param velocidad: nueva velocidad de la bala donde velocidad != null
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * Permite retornar la ruta en donde esta la imagen de la bala que esta depende del arma
	 * @return imagenBala: Ruta de la imagen de la bala
	 */
	public String getImagenBala() {
		return imagenBala;
	}
	/**
	 * Permite modificar la ruta en donde esta la imagen de la bala
	 * 
	 * <b>post: <b> Se cambio la ruta de la imagen de la bala
	 * 
	 * @param imagen: nueva ruta de la imagen de la bala, donde imagen != null y imagen != ""
	 */
	public void setImagen(String imagen) {
		this.imagenBala = imagen;
	}
	/**
	 * Permite modificar el da�o de la bala
	 * @param damage: Nuevo da�io que hace la bala
	 */
	public void setDamage(int damage) {
		this.damage =  damage;
	}
	
	/**
	 * Permite modificar el hitBox respecto a la posicion de la bala y al tama�o de la imagen de la bala
	 * <b>post: </b> el HitBox se acomoda respecto a la posicion de la bala 
	 * 
	 */
	public void setHitBox() {
		ImageIcon ii = new ImageIcon(imagenBala);
		Rectangle2D hitBox = new Rectangle2D.Double(posX, Personaje.POS_Y, ii.getIconWidth(), ii.getIconHeight());
		this.hitBox = hitBox;
	}
	/**
	 * Retorna el hitBox de la bala
	 * @return hitBox: hitBox de la posicion actual de la bala
	 */
	public Rectangle2D getHitBox() {
		return hitBox;
	}
	/**
	 * Permite retornar el da�o que hace la bala
	 * @return damage:  Da�o total que hace la bala
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Permite retornar la posicion actual de la bala en el eje X
	 * @return posX: posicion actual de la bala
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * Permite modificar la posicion actual de la bala en el eje X
	 * @param posX: posicion Nueva de la bala donde posX != null
	 */
	public void setPosX(int posX) {
		this.posX = posX;
		setHitBox();
	}
	/**
	 * Permite mover la bala respecto a una distancia pasada por parametro
	 * 
	 * <b>post: </b> La bala se desplaza en el eje X una cierta distancia
	 * 
	 * @param distancia:  distancia que va a recorrer la bala
	 */
	public void moverBala(int distancia) {
		setPosX(getPosX() + distancia);
		setHitBox();
	}
}
