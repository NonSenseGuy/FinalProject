package modelo;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Bala implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int VELOCIDAD_BALA = 8;
	private String imagenBala;
	private int damage;
	private Rectangle2D hitBox;
	private int posX;
	private int velocidad;

	
	public Bala(String imagenBala, int posX, int damage) {
		this.imagenBala = imagenBala;
		this.damage = damage;
		this.posX = posX;
		setHitBox();
		velocidad = 0;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public String getImagenBala() {
		return imagenBala;
	}
	
	public void setImagen(String imagen) {
		this.imagenBala = imagen;
	}
	
	public void setDamage(int damage) {
		this.damage =  damage;
	}
	
	
	public void setHitBox() {
		ImageIcon ii = new ImageIcon(imagenBala);
		Rectangle2D hitBox = new Rectangle2D.Double(posX, Personaje.POS_Y, ii.getIconWidth(), ii.getIconHeight());
		this.hitBox = hitBox;
	}
	
	public Rectangle2D getHitBox() {
		return hitBox;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void moverBala(int distancia) {
		setPosX(getPosX() + distancia);
		setHitBox();
	}
}
