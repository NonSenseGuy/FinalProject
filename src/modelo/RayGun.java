package modelo;

public class RayGun extends Arma{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int DAMAGE_RAYGUN = 5;
	public final static int VELOCIDAD_BALA = 10;
	public final static String IMAGEN_RAYGUN = "./img/RayGun.png";
	
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
