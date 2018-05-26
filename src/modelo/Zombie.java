package modelo;

public class Zombie extends Personaje{
	
	public final static String IMAGEN_ZOMBIE = "./img/zombieE.png";
	public final static int VIDA = 50;
	public final static int SCORE = 20;
	public final static int DANO = 15;
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
		if(getPosX() < 1000 ) {
			setVelocidad(5);
		}else if(getPosX() > 1000) {
			setVelocidad(-5);
		}
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
	
	public void setZombieIzq(Zombie e) {
		zombieIzq = e;
	}
	
	public Zombie getZombieDer() {
		return zombieDer;
	}
	
	public void setZombieDer(Zombie e) {
		zombieDer = e;
	}

	public void agregarZombie(Zombie z) {
		if(getPosX() < z.getPosX()) {
			if(zombieDer == null ) {
				zombieDer = z;
			}else {
				zombieDer.agregarZombie(z);
			}
		}else {
			if(zombieIzq == null) {
				zombieIzq = z;
			}else {
				zombieIzq.agregarZombie(z);
			}
		}
		
	}

	public void eliminarZombie(Zombie eliminar) {
		
		if(true) {
			
		}
		
	}
	
	
	
	
}
