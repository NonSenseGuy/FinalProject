package modelo;

import java.awt.geom.Rectangle2D;

public abstract class Personaje {
	
	public final static int ANCHO = 60;
	public final static int ALTO = 60;
	public final static int POS_Y = 500;
	private int vida;
	private int posX;
	private String imagen;
	private Rectangle2D hitBox;
	private int velocidad;
	private boolean enMovimiento;

	public Personaje(int vida, int posX, String imagen) {
		this.vida = vida;
		this.posX = posX;
		this.imagen = imagen;
		setHitBox();
		velocidad = 0;
		enMovimiento = false;
	}
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public boolean isEnMovimiento() {
		return enMovimiento;
	}
	
	public void setEnMovimiento(boolean enMovimiento) {
		this.enMovimiento = enMovimiento;
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
		setHitBox();
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void setHitBox() {
		hitBox = new Rectangle2D.Double(posX, POS_Y, ANCHO, ALTO);
		
	}
	
	public Rectangle2D getHitBox() {
		return hitBox;
	}
	
	public void moverPersonaje(int distancia) {
		int xFuturo = posX+distancia;
		setPosX(xFuturo);
		setHitBox();
	}


	
}
