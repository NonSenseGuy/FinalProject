package modelo;

public class Zombie extends Personaje{
	
	private int damage;
	
	public Zombie(int vida, int posX, int posY, String imagen, int damage) {
		super(vida, posX, posY, imagen);
		// TODO Auto-generated constructor stub
		this.damage= damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
	


	
}
