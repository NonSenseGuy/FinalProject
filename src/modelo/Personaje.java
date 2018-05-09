package modelo;

public abstract class Personaje {
	
	private int vida;
	private int posX;
	private int posY;
	private String imagen;
	
	public Personaje(int vida, int posX, int posY, String imagen) {
		super();
		this.vida = vida;
		this.posX = posX;
		this.posY = posY;
		this.imagen = imagen;
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

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
}
