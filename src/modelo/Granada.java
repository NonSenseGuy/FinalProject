package modelo;

public class Granada extends Explosivo {
	
	private int tiempoExplosion;

	public Granada(String nombre,int damage, int ammo, String imagen, int radioExplosion, int tiempoExplosion) {
		super(nombre,damage, ammo, imagen, radioExplosion);
		this.tiempoExplosion = tiempoExplosion;
	}

	public int getTiempoExplosion() {
		return tiempoExplosion;
	}

	public void setTiempoExplosion(int tiempoExplosion) {
		this.tiempoExplosion = tiempoExplosion;
	}
	
	
	
}
