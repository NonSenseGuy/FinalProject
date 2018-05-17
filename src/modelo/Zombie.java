package modelo;

public class Zombie extends Personaje{
	
	public final static int VIDA = 50;
	private int damage;
	private boolean atacar;
	
	public Zombie(int posX, String imagen, int damage) {
		super(VIDA, posX, imagen);
		this.damage= damage;
		setHitBox();
		atacar = false;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public boolean getAtacar() {
		return atacar;
	}
	
	public void setAtacar(boolean atacar) {
		this.atacar = atacar;
	}
}
