package modelo;

public class Rocket extends Arma {
	
	public final static int DAMAGE_ROCKET = 100;
	
	private int radioExplocion;
	private Bala bala;

	public Rocket(String nombre, int ammo, String imagen, int radioExplosion) {
		super(nombre,DAMAGE_ROCKET, ammo, imagen);
		this.radioExplocion = radioExplosion;
	}

	public int getRadioExplocion() {
		return radioExplocion;
	}

	public void setRadioExplocion(int radioExplocion) {
		this.radioExplocion = radioExplocion;
	}
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoRocket.png", posX, getDamage());
	}	
}
