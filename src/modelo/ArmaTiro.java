package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite inicializar una arma tipo ArmaTiro
 */
public class ArmaTiro extends Arma {
	
	private static final long serialVersionUID = 1L;
	public final static int VELOCIDAD_BALA = 8;
	
	private int cadencia;	
	private Bala bala;
	/**
	 * Constructor que permite inicializar un arma Tipo tiro	
	 * @param nombre: Nombre del arma
	 * @param damage: El daño que hace el arma
	 * @param imagen: ruta de la imagen del arma para la interfaz grafica
	 * @param cadencia: la cadencia de tiro del arma
	 */
	public ArmaTiro(String nombre,int damage, String imagen, int cadencia) {
		super(nombre,damage, imagen);
		this.cadencia = cadencia;		
	}
	/**
	 * Permite retornar la cadencia dela rma
	 * @return cadencia
	 */
	public int getCadencia() {
		return cadencia;
	}
	/** 
	 * Permite modificar la cadencia del arma
	 * @param cadencia: nueva  cadencia del arma donde cadencia != 0 y cadencia != null
	 */
	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
	
	@Override
	public void dispararBala(int posX) {
		if(bala == null)
		bala = new Bala("./img/disparoHorizontal.png", posX, getDamage());
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
}
