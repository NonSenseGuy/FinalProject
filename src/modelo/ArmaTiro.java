package modelo;

public class ArmaTiro extends Arma {
	
	public final int VELOCIDAD_BALA = 5;
	private int cadencia;
	
	
	private Bala bala;

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
	
	public Bala dispararBala(int posX) {
		bala = new Bala("./img/disparoHorizontal.png", posX, getDamage());
		
		return bala;
	}
	
	public Bala getBala() {
		return bala;
	}
}
