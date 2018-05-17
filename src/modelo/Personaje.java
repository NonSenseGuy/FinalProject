package modelo;

import java.awt.geom.Rectangle2D;

public abstract class Personaje {
	
	private final static int ANCHO = 60;
	private final static int ALTO = 60;
	private final static int POS_Y = 80;
	private int vida;
	private int posX;
	private String imagen;
	private Rectangle2D hitBox;
	
	public Personaje(int vida, int posX, String imagen) {
		this.vida = vida;
		this.posX = posX;
		this.imagen = imagen;
		setHitBox();
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void setHitBox() {
		Rectangle2D hitBox = new Rectangle2D.Double(posX, POS_Y, ANCHO, ALTO);
		this.hitBox = hitBox;
	}
	
	public Rectangle2D getHitBox() {
		return hitBox;
	}
	
	public void moverPersonaje(int distancia) {
		setPosX(getPosX() + distancia);
		setHitBox();
	}
	
}
