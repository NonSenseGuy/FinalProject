package modelo;

public class Boss extends Personaje implements Disparar{
	
	public final static String IMAGEN_BOSS = "./img/boss.png";
	public final static int RADIO_ATAQUE = 400; 
	public final static int DANO = 20;
	public final static int VIDA = 100;
	public final static int SCORE = 60;
	private int damage;
	private int radioDistanciaAtaque;
	private boolean atacar;
	private int score;
	private Zombie zombieIzq; 
	private Zombie zombieDer;
	
	
	public Boss(int vida, int posX, String imagen, int damage, int radioDistanciaAtaque) {
		super(vida, posX, imagen);
		this.damage = damage;
		this.radioDistanciaAtaque = radioDistanciaAtaque;
		setHitBox();
		atacar = false;
		score = SCORE;
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
	public int getRadioDistanciaAtaque() {
		return radioDistanciaAtaque;
	}
	public void setRadioDistanciaAtaque(int radioDistanciaAtaque) {
		this.radioDistanciaAtaque = radioDistanciaAtaque;
	}
	
	public boolean getAtacar() {
		return atacar;
	}
	
	public void setAtacar(boolean atacar) {
		this.atacar = atacar;
	}
	
	public void setZombieIzq(Zombie izq) {
		zombieIzq = izq;
	}
	
	public void setZombieDer(Zombie der) {
		zombieDer = der;
	}
	
	@Override
	public void disparar(int direccion) {
		// TODO Auto-generated method stub
		
	}
}
