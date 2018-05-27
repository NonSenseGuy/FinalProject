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
	
	public Zombie localizarZombieMuerto() {
		
		if(getVida() <= 0) {
			return this;
		}else if(zombieIzq != null && zombieDer == null) {
			return zombieIzq.localizarZombieMuerto();
		}else if(zombieIzq == null && zombieDer != null) {
			return zombieDer.localizarZombieMuerto();
		}else if(zombieIzq != null && zombieDer != null){
			return zombieIzq.localizarZombieMuerto() == null ? zombieDer.localizarZombieMuerto(): zombieIzq.localizarZombieMuerto();
		}
		
		return null;
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

	public Zombie buscarZombie(int pos) {
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			return this;			
		}else{
			if (zombieIzq != null && zombieIzq.buscarZombie(pos) != null) {
				return zombieIzq.buscarZombie(pos);
			}
			if (zombieDer != null && zombieDer.buscarZombie(pos) != null) {
				return zombieDer.buscarZombie(pos);
			}
			return null;
		}
	}
	
	public Zombie darMenor() {
		if (zombieIzq == null) {
			return this;
		} else {
			return zombieIzq.darMenor();
		}
	}

	public Zombie eliminarZombie(int pos) {
		
		if (getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			if (zombieIzq == null) {
				return zombieDer == null ? null : zombieDer;
			} else if (zombieDer == null) {
				return zombieIzq;
			}

			Zombie succesor = zombieDer.darMenor();
			zombieDer = zombieDer.eliminarZombie(succesor.getPosX());
			succesor.zombieIzq = zombieIzq;
			succesor.zombieDer = zombieDer;
			return succesor;

		} else if (getPosX() > pos) {
			zombieIzq = zombieIzq.eliminarZombie(pos);
		} else {
			zombieDer = zombieDer.eliminarZombie(pos);
		}

		return this;
	}
	
}
