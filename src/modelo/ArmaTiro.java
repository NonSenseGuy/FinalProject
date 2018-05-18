package modelo;

public class ArmaTiro extends Arma {
	private int cadencia;

	public ArmaTiro(String nombre,int damage, int ammo, String imagen, int cadencia) {
		super(nombre,damage, ammo, imagen);
		this.cadencia = cadencia;
	}

	public int getCadencia() {
		return cadencia;
	}

	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}	
}
