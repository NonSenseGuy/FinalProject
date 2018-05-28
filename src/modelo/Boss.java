package modelo;

public class Boss extends Personaje implements Generar{

	
	public final static String IMAGEN_BOSS = "./img/Boss.png";
	public final static int DANO = 10;
	public final static int VIDA = 100;
	public final static int SCORE = 60;
	private int damage;
	private int score;
	private Zombie zombie;
	
<<<<<<< HEAD
	/**
	 * <b>pre:</b>; La clase JuegoModelo y Escenario ya deben estar inicializadas
	 * Constructor que inicializa la clase Boss
	 * @param vida
	 * @param posX
	 * @param imagen
	 * @param damage
	 * @param radioDistanciaAtaque
	 */
	public Boss(int vida, int posX, String imagen, int damage, int radioDistanciaAtaque) {
=======
	
	public Boss(int vida, int posX, String imagen, int damage) {
>>>>>>> 6c661b357cdc3dc760748df5aa65ec9d28b9cde3
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
	 * @return damage
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Retorna el score que da el Boss cuando el jugador lo mata
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Modifica el daño del boss
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
<<<<<<< HEAD
	/**
	 * Zombie que acompaña al boss y raiz de un arbol binario de zombies
	 * @return zombies
	 */
	public Zombie getZombie() {
		return zombie;
	}
	/**
	 * Genera zombies segun una cantidad y los agrega a un arbol binario
	 * @param cant
	 */
=======
	
	public Zombie getZombie() {
		return zombie;
	}
	
>>>>>>> 6c661b357cdc3dc760748df5aa65ec9d28b9cde3
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
	 * @return zombie generado
	 */
	public Zombie generarZombie() {
		boolean positivo = Math.random() > 0.5;
		int rango = positivo ? 1 : -1;
		Zombie z = new Zombie(getPosX() + (int) (Math.random()*300 *rango),Zombie.IMAGEN_ZOMBIE,Zombie.DANO );
		return z;
	}
	
	/**
	 * Agrega un zombie en estructura de arbol binario
	 * Si la raiz es nula 
	 * @param z
	 */
	public void agregarZombie(Zombie z) {
		if(zombie == null) {
			zombie = z;
		}else {
			zombie.agregarZombie(z);
		}
	}
	
	public boolean quitarVidaBoss(int pos, int damageBala) {
		
		boolean golpeado = false;
		
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			golpeado = true;
			setVida(getVida() - damageBala);
		}
		
		return golpeado;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public boolean eliminarZombie(int pos) {
		boolean elimino = false;
		
		Zombie a = buscarZombie(pos);
		if (a != null) {
			elimino = true;
			zombie = zombie.eliminarZombie(a.getPosX());
		}
		return elimino;
	}
	
	public Zombie buscarZombie(int pos) {
		if(zombie == null) {
			return null;
		}else {
			return zombie.buscarZombie(pos);
		}
	}
	
	public Zombie localizarZombieMuerto() {
		if(zombie != null) 	return zombie.localizarZombieMuerto();		
		return null;
	}
}
