package modelo;

public class Arma {
	
	private int damage;
	private int ammo;
	private String imagen;
	private Arma siguiente;
	private Arma anterior;
	
	public Arma(int damage, int ammo, String imagen) {
		super();
		this.damage = damage;
		this.ammo = ammo;
		this.imagen = imagen;
	}
	public Arma getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Arma siguiente) {
		this.siguiente = siguiente;
	}
	public Arma getAnterior() {
		return anterior;
	}
	public void setAnterior(Arma anterior) {
		this.anterior = anterior;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getAmmo() {
		return ammo;
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
}
