package modelo;

public class Boss extends Personaje implements Disparar{
	
	private int damage;
	private int radioDistanciaAtaque;
	public Boss(int vida, int posX, int posY, String imagen, int damage, int radioDistanciaAtaque) {
		super(vida, posX, posY, imagen);
		this.damage = damage;
		this.radioDistanciaAtaque = radioDistanciaAtaque;
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
