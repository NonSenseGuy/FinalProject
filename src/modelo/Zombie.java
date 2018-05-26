package modelo;

public class Zombie extends Personaje{
	
	public final static int VIDA = 50;
	public final static int SCORE = 20;
	private int damage;
	private boolean atacar;
	private int score;
	private Zombie zombieIzq;
	private Zombie zombieDer;
	
	public Zombie(int posX, String imagen, int damage) {
		super(VIDA, posX, imagen);
		this.damage= damage;
		setHitBox();
		atacar = false;
		score = 20;
	}

	public int getDamage() {
		return damage;
	}
	
	public int getScore() {
		return score;
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
	
	public Zombie getZombieIzq() {
		return zombieIzq;
	}
	
	public Zombie getZombieDer() {
		return zombieDer;
	}
	
	
	
	
}
