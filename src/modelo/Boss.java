package modelo;

public class Boss extends Personaje implements Disparar{
	
	public final static int VIDA = 100;
	public final static int SCORE = 60;
	private int damage;
	private int radioDistanciaAtaque;
	private boolean atacar;
	private int score;
	
	public Boss(int posX, String imagen, int damage, int radioDistanciaAtaque) {
		super(VIDA, posX, imagen);
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
	
	@Override
	public void disparar(int direccion) {
		// TODO Auto-generated method stub
		
	}
}
