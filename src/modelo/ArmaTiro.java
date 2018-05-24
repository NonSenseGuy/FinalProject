package modelo;

public class ArmaTiro extends Arma {
	
	public final int VELOCIDAD_BALA = 5;
	private int cadencia;
	
	
	private Bala[] balas;

	public ArmaTiro(String nombre,int damage, int ammo, String imagen, int cadencia) {
		super(nombre,damage, ammo, imagen);
		this.cadencia = cadencia;
		balas = new Bala[3];
	}

	public int getCadencia() {
		return cadencia;
	}

	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
	
	public Bala dispararBala(int posX) {
		bala = new Bala("./img/disparoHorizontal.png", posX, getDamage());
		boolean sePuedeDisparar = false ;
		int i;
		for(i = 0; i < balas.length && !sePuedeDisparar; i++) {
			if(balas[i] == null);
				sePuedeDisparar = true;
		}
		
		if(sePuedeDisparar) {
			balas[i] = bala;
		}
		
		return bala;
	}
	
	public Bala[] getBala() {
		return balas;
	}
}
