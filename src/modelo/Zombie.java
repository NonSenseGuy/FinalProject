package modelo;

public class Zombie extends Personaje{
	
	public final static int VIDA = 50;
	private int damage;
	
	public Zombie(int posX, String imagen, int damage) {
		super(VIDA, posX, imagen);
		this.damage= damage;
		setHitBox();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}	
}
