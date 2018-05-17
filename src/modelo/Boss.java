package modelo;

public class Boss extends Personaje implements Disparar{
	
	public final static int VIDA = 100;
	private int damage;
	private int radioDistanciaAtaque;
	
	public Boss(int posX, String imagen, int damage, int radioDistanciaAtaque) {
		super(VIDA, posX, imagen);
		this.damage = damage;
		this.radioDistanciaAtaque = radioDistanciaAtaque;
		setHitBox();
	}
	public int getDamage() {
		return damage;
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
	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
}
