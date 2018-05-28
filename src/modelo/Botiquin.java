package modelo;

import java.io.Serializable;

public class Botiquin extends Objeto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String IMAGEN_BOTIQUIN = "./img/botiquin.png";
	public final int VIDA = 20;
	private int vida;
	private String img;
	
	public Botiquin(int posX, int posY) {
		super(posX, posY);
		this.vida = VIDA; 
		img = IMAGEN_BOTIQUIN;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getVida() {
		return vida;
	}
}
