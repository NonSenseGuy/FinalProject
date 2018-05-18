package modelo;

public class Rocket extends Explosivo {
	
	private int tiempoRecarga;

	public Rocket(String nombre,int damage, int ammo, String imagen, int radioExplosion, int tiempoRecarga) {
		super(nombre,damage, ammo, imagen, radioExplosion);
		this.tiempoRecarga = tiempoRecarga;
	}

	public int getTiempoRecarga() {
		return tiempoRecarga;
	}

	public void setTiempoRecarga(int tiempoRecarga) {
		this.tiempoRecarga = tiempoRecarga;
	}
	
	
}
