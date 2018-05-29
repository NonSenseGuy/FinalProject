package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite inicializar un Boss que aparece en el juego y sus respectivos zombies
 */
public class Boss extends Personaje implements Generar{

	private static final long serialVersionUID = 1L;
	public final static String IMAGEN_BOSS = "./img/Boss.png";
	public final static int DANO = 10;
	public final static int VIDA = 100;
	
	public final static int SCORE = 60;
	private int damage;
	private int score;
	private Zombie zombie;
	/**
	 * Constructor que inicializa la clase Boss
	 * 
	 * <b>pre:</b>; La clase JuegoModelo y Escenario ya deben estar inicializadas
	 *
	 * @param vida: Vida total del boss
	 * @param posX:  posicion actuald el Boss
	 * @param imagen: ruta de imagen del boss
	 * @param damage: Daño que infllinge el boss
	 */	
	public Boss(int vida, int posX, String imagen, int damage) {
		super(vida, posX, imagen);
		this.damage = damage;
		setHitBox();
		score = SCORE;
		generar(4);
		
		if(getPosX() < 1000 ) {
			setVelocidad(5);
		}else if(getPosX() > 1000) {
			setVelocidad(-5);
		}
	}
	
	/**
	 * Retorna el daño que hace el boss por tick de contacto con el personaje principal
	 * @return damage: Daño que hace el Boss
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Retorna el score que da el Boss cuando el jugador lo mata
	 * @return score: Score que se le da al jugador por matar al boss
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Modifica el daño del boss
	 * @param damage: Nuevo dañod el boss, damage != null
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * Zombie que acompaña al boss y raiz de un arbol binario de zombies
	 * @return zombies: Raiz del arbol bianrio de zombies
	 */
	public Zombie getZombie() {
		return zombie;
	}

	@Override
	public void generar(int cant) {
		if(cant != 0) {
			Zombie z = generarZombie();
			agregarZombie(z);
			generar(cant-1);
		}
	}
	/**
	 * Genera un zombie en una posicion aleatoria dentro de un rango dado
	 * @return z: Zombie generado en una posicion aleatoria respecto a un rango
	 */
	public Zombie generarZombie() {
		boolean positivo = Math.random() > 0.5;
		int rango = positivo ? 1 : -1;
		Zombie z = new Zombie(getPosX() + (int) (Math.random()*400 *rango),Zombie.IMAGEN_ZOMBIE,Zombie.DANO );
		return z;
	}
	
	/**
	 * Agrega un zombie en la estructura de arbol binario
	 * Si la raiz es nula, agrega el zombie en la raiz,
	 * Si no lo agrega en orden segun su posicion en X
	 * 
	 * <b>pos: </b> Se ha agregado un zombie al arbol binario
	 * 
	 * @param z: Zombie a agregar en el arbol binario z diferente de null
	 */
	public void agregarZombie(Zombie z) {
		if(zombie == null) {
			zombie = z;
		}else {
			zombie.agregarZombie(z);
		}
	}
	
	/**
	 * Verifica si el disparo del jugador principal le pego al boss 
	 * En caso de que le haya pegado le quita vida segun el daño de la bala
	 * @param pos: Poscision la cual la bala se encuentra
	 * @param damageBala: daño del arma de la bala
	 * @return golpeado: Si golpeo a un boss,  golepado =  true, sino golpeado = false
	 */
	public boolean quitarVidaBoss(int pos, int damageBala) {		
		boolean golpeado = false;		
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			golpeado = true;
			setVida(getVida() - damageBala);
		}		
		return golpeado;
	}
	/**
	 * Modifica el score que puede dar el boss
	 * @param score: Nuevo Score que el boss al ser eliminado
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Elimina un zombie del arbol binario que este en la posicion pasada por parametro
	 * @param pos: Posicion del boss el cual se quiere eliminar
	 * @return eliminado: eliminado = true si el zombie fue eliminado o eliminado = false si no se ha eliminado el zombie que se buscaba
	 */
	public boolean eliminarZombie(int pos) {
		boolean elimino = false;
		
		Zombie a = buscarZombie(pos);
		if (a != null) {
			elimino = true;
			zombie = zombie.eliminarZombie(a.getPosX());
		}
		return elimino;
	}
	
	/**
	 * Busca un zombie que esta en la posicion pasada por parametro y si no encuentra al zombie retorna null
	 * retorna el zombie buscado y si no lo encuentra, retorna null
	 * @param pos: Posicion que se desea saber si hay un zombie
	 * @return zombie
	 */
	public Zombie buscarZombie(int pos) {
		if(zombie == null) {
			return null;
		}else {
			return zombie.buscarZombie(pos);
		}
	}
	/**
	 * Localiza zombies que tengan vida menor o igual a 0 y si no no hay un zombie con esas condiciones, retorna null
	 * @return Zombie
	 */
	public Zombie localizarZombieMuerto() {
		if(zombie != null) 	return zombie.localizarZombieMuerto();		
		return null;
	}
	
	/**
	 * Modifica el zombie raiz que tiene boss
	 * @param z: Zombie nuevo
	 */
	public void setZombie(Zombie z) {
		zombie = z;
	}
}
