package modelo;

public class Zombie extends Personaje{
	
	public final static String IMAGEN_ZOMBIE = "./img/zombieE.png";
	public final static int VIDA = 50;
	public final static int SCORE = 20;
	public final static int DANO = 2;
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

	public boolean quitarVidaZombie(int pos, int damageBala) {
		boolean leDio = false;
		
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			leDio = true;
			setVida(getVida() - damageBala);			
			return leDio;
		}else if(zombieIzq != null && zombieDer == null) {
			return zombieIzq.quitarVidaZombie(pos, damageBala);
		}else if(zombieIzq == null && zombieDer != null) {
			return zombieDer.quitarVidaZombie(pos, damageBala);
		}else if(zombieIzq != null && zombieDer != null){
			return !zombieIzq.quitarVidaZombie(pos, damageBala) ? zombieDer.quitarVidaZombie(pos, damageBala): true;
		}		
		return leDio;
	}

	public boolean eliminarZombie() {
		boolean zombieEliminado = false;
		
		if(getVida() <= 0) {
			
			zombieEliminado = true;
			Zombie anterior = localizarAnterior(getPosX());
			
			if(getZombieIzq() == null && getZombieDer() == null) {
				if(anterior.getZombieIzq() != null && anterior.getZombieIzq().getPosX() == getPosX()) {
					anterior.setZombieIzq(null);
				}else {
					anterior.setZombieDer(null);
				}
			}else if(getZombieIzq() != null && getZombieDer() == null) {
				Zombie izq = getZombieIzq();
				
				if(anterior.getZombieIzq() != null && anterior.getZombieIzq().getPosX() == getPosX()) {
					anterior.setZombieIzq(izq);
				}else {
					anterior.setZombieDer(izq);
				}
				
				setZombieIzq(null);
			}else if(getZombieIzq() == null && getZombieDer() != null) {
				Zombie der = getZombieIzq();
				
				if(anterior.getZombieIzq() != null && anterior.getZombieIzq().getPosX() == getPosX()) {
					anterior.setZombieIzq(der);
				}else {
					anterior.setZombieDer(der);
				}
				
				setZombieDer(null);
			}else if (getZombieIzq() != null && getZombieDer() != null){
				
			}			
						
		}else if(zombieIzq != null && zombieDer == null) {
			return zombieIzq.eliminarZombie();
		}else if(zombieIzq == null && zombieDer != null) {
			return zombieDer.eliminarZombie();
		}else if(zombieIzq != null && zombieDer != null){
			return !zombieIzq.eliminarZombie() ? zombieDer.eliminarZombie(): true;
		}		
		return zombieEliminado;
	}
	
	public Zombie localizarAnterior(int pos) {
		
		Zombie der = getZombieDer() == null ? null: getZombieDer();
		Zombie izq = getZombieIzq() == null ? null: getZombieIzq();
		
		if(izq != null) {
			if(izq.getPosX() == pos) return this;
			return izq.localizarAnterior(pos);
		}
		
		if(der != null) {
			if(der.getPosX() == pos) return this;
			der.localizarAnterior(pos);
		}
		
		return null;
	}
	
}
