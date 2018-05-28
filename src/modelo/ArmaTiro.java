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
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoHorizontal.png", posX, getDamage());
	}
	
	public Bala getBala() {
		return bala;
	}
	public void setBala(Bala bala) {
		this.bala = bala;
	}
}
