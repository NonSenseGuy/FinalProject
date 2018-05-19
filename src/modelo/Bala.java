package modelo;

import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Bala {
	
	private String imagenBala;
	private int damage;
	private Rectangle2D hitBox;
	private int posX;
	
	
	public Bala(String imagenBala, int posX, int damage) {
		this.imagenBala = imagenBala;
		this.damage = damage;
		this.posX = posX;
		setHitBox();
	}
	
	public String getImagenBala() {
		return imagenBala;
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
