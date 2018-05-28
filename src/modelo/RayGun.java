package modelo;

public class RayGun extends Arma{
	
	public final static int DAMAGE_RAYGUN = 15;
	public final static int VELOCIDAD_BALA = 10;
	
	private Bala bala;
	
	public RayGun(String nombre, int ammo, String imagenArma) {
		super(nombre, DAMAGE_RAYGUN, ammo, imagenArma);
	}

	public Bala getBala() {
		return bala;
	}

	public void setBala(Bala bala) {
		this.bala = bala;
	}
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoRayGun.png", posX, getDamage());
	}
	
	
}
