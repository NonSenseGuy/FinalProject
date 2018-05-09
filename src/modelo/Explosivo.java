package modelo;

public class Explosivo extends Arma implements Explosion{
	private int radioExplosion;

	public Explosivo(int damage, int ammo, String imagen, int radioExplosion) {
		super(damage, ammo, imagen);
		this.radioExplosion = radioExplosion;
	}

	public int getRadioExplosion() {
		return radioExplosion;
	}

	public void setRadioExplosion(int radioExplosion) {
		this.radioExplosion = radioExplosion;
	}

	@Override
	public void explosion() {
		// TODO Auto-generated method stub
		
	}
	
}
