package modelo;

public class Botiquin extends Objeto{
	
	public final int VIDA = 25;
	private int vida;
	
	public Botiquin(int posX, int posY) {
		super(posX, posY);
		this.vida = VIDA; 
	}

	public int getVida() {
		return vida;
	}
}
