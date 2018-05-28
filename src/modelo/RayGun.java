package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite tener una instancia de un arma tipo RayGun
 */
public class RayGun extends Arma{
	
	private static final long serialVersionUID = 1L;
	public final static int DAMAGE_RAYGUN = 5;
	public final static int VELOCIDAD_BALA = 10;
	public final static String IMAGEN_RAYGUN = "./img/RayGun.png";
	
	private Bala bala;
	/**
	 * Permite crear una instancia del arma tipo RayGun
	 * @param nombre: Nombre de la RayGun
	 * @param imagenArma: direccion de la imagen que tendra la RayGun en la interfaz grafica
	 */
	public RayGun(String nombre, String imagenArma) {
		super(nombre, DAMAGE_RAYGUN, imagenArma);
	}
	/**
	 * Permite retornar la bala del arma que contiene el daño que hace el arma
	 * @return: bala: Objeto tipo bala que contiene el daño que hace el arma, la imagen de la bala y una posicion en X
	 */
	public Bala getBala() {
		return bala;
	}
	/**
	 * Permite modificar la variable bala que es tipo Bala
	 * @param bala: bala nueva del Rocket
	 */
	public void setBala(Bala bala) {
		this.bala = bala;
	}
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoRayGun.png", posX, getDamage());
	}
	
	
}
