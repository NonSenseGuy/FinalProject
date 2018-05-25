package modelo;

public class Arma {
	
	private String nombre;
	private int damage;
	private int ammo;
	private String imagenArma;
	private Arma siguiente;
	private Arma anterior;
	protected Bala bala;
	
	public Arma(String nombre,int damage, int ammo, String imagenArma) {
		this.nombre = nombre;
		this.damage = damage;
		this.ammo = ammo;
		this.imagenArma = imagenArma;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setArma(String nombre) {
		this.nombre = nombre;
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
	public String getImagenArma() {
		return imagenArma;
	}
	public void setImagenArma(String imagen) {
		this.imagenArma = imagen;
	}

	

	
	
	
}
