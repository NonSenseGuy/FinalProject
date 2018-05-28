package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que crea los zombies con una imagen, vida, damage y una posicion en el juego
 */
public class Zombie extends Personaje{
	
	private static final long serialVersionUID = 1L;
	public final static String IMAGEN_ZOMBIE = "./img/zombieE.png";
	public final static int VIDA = 50;
	public final static int SCORE = 20;
	public final static int DANO = 2;
	
	private int damage;
	private int score;
	private Zombie zombieIzq;
	private Zombie zombieDer;
	
	public Zombie(int posX, String imagen, int damage) {
		super(VIDA, posX, imagen);
		this.damage= damage;
		setHitBox();
		score = 20;
		if(getPosX() < 1000 ) {
			setVelocidad(5);
		}else if(getPosX() > 1000) {
			setVelocidad(-5);
		}
	}
	/**
	 * Permite retornar el daño que ejecuta el zombie.
	 * @return damage: Retorna un entero que es el daño que ejecuta el zombie.
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Permite retornar los puntos que otorga el zombie cuando muere.
	 * @return score: Puntos que da el zombie por su muerte.
	 */
	public int getScore() {
		return score;
	}
	/*
	 * Permite cambier el daño que ejecuta el zombie
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * Permite retornar el zombie de la posicion izquierda del zombie seleccionado en el arbol binario
	 * @return zombieIzq: Zombie que esta en la posicion izquierda del zombie instanciado.
	 */
	public Zombie getZombieIzq() {
		return zombieIzq;
	}
	/**
	 * Permite modificar el zombie de la posicion izquierda del zombie seleccionado en el arbol binario
	 * @param e: Zombie que se desea colocar en el lado izquierda del arbol binario al zombie seleccionado
	 */
	public void setZombieIzq(Zombie e) {
		zombieIzq = e;
	}
	/**
	 * Permite retornar el zombie de la posicion derecha del zombie seleccionado en el arbol binario
	 * @return zombieDer: Zombie que esta en la posicion derecha del zombie instanciado.
	 */
	public Zombie getZombieDer() {
		return zombieDer;
	}
	/**
	 * Permite modificar el zombie de la posicion izquierda del zombie seleccionado
	 * @param e: Zombie que se desea colocar en el lado derecho del arbol binario al zombie seleccionado
	 */
	public void setZombieDer(Zombie e) {
		zombieDer = e;
	}
	/**
	 * Permite agregar un zombie al arbol binario de zombies
	 * @param z: Zombie que se desea agregar al arbol binario de los zombies, donde  z != null
	 */
	public void agregarZombie(Zombie z) {
		if(getPosX() < z.getPosX()) {
			if(zombieDer == null ) {
				zombieDer = z;
			}else {
				zombieDer.agregarZombie(z);
			}
		}else {
			if(zombieIzq == null) {
				zombieIzq = z;
			}else {
				zombieIzq.agregarZombie(z);
			}
		}
		
	}
	/**
	 * Este metodo permite quitarle vida a un zombie que este en una posicion determinada, si le dieron, se le quita a la vida del zombie el daño que recibio
	 * y retorna un boleano =  true, si no le dio a ningun zombie en todo el arbol binario, retorna false
	 * 
	 * @param pos:  La posicion a evaluar si hay un zombie en ese lugar
	 * @param damageBala: El daño de la bala, lo que hace que la vida se le quite al zombie
	 * @return leDio: booleano que retornar verdadero si le ha dado a un zombie y falso si no le ha dado a ningun zombie
	 */
	public boolean quitarVidaZombie(int pos, int damageBala) {
		boolean leDio = false;
		
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			leDio = true;
			setVida(getVida() - damageBala);			
			return leDio;
		}else if(zombieIzq != null && zombieDer == null) {
			return zombieIzq.quitarVidaZombie(pos, damageBala);
		}else if(zombieIzq == null && zombieDer != null) {
			return zombieDer.quitarVidaZombie(pos, damageBala);
		}else if(zombieIzq != null && zombieDer != null){
			return !zombieIzq.quitarVidaZombie(pos, damageBala) ? zombieDer.quitarVidaZombie(pos, damageBala): true;
		}		
		return leDio;
	}
	/**
	 * Este metodo permite localizar el zombie que tiene  una vida <= 0, si lo encuentra en el árbol binario,lo retorna
	 * @return zombie: Zommbie el cual tiene una vida <= 0
	 */
	public Zombie localizarZombieMuerto() {
		
		if(getVida() <= 0) {
			return this;
		}else if(zombieIzq != null && zombieDer == null) {
			return zombieIzq.localizarZombieMuerto();
		}else if(zombieIzq == null && zombieDer != null) {
			return zombieDer.localizarZombieMuerto();
		}else if(zombieIzq != null && zombieDer != null){
			return zombieIzq.localizarZombieMuerto() == null ? zombieDer.localizarZombieMuerto(): zombieIzq.localizarZombieMuerto();
		}
		
		return null;
	}	
	/**
	 * Permite buscar un zombie respecto a su posicion en X
	 * @param pos: La poscion en X que se deasea saber y hay un zombie
	 * @return zombie: Retorna el zombie en esa posicion en X, sino hay, retorna null
	 */
	public Zombie buscarZombie(int pos) {
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			return this;			
		}else{
			if (zombieIzq != null && zombieIzq.buscarZombie(pos) != null) {
				return zombieIzq.buscarZombie(pos);
			}
			if (zombieDer != null && zombieDer.buscarZombie(pos) != null) {
				return zombieDer.buscarZombie(pos);
			}
			return null;
		}
	}
	/**
	 * Este metodo permite retornar el zombie menor de todo el arbol bianario
	 * @return zombie: Zombie que esta ubicado en el lado izquierdo del arbol binario
	 */
	public Zombie darMenor() {
		if (zombieIzq == null) {
			return this;
		} else {
			return zombieIzq.darMenor();
		}
	}
	/**
	 * Este metodo permite eliminar un zombie que este en una posicion determinada, lo busca en el arbol binario respecto a su posicion y lo elimina.
	 * @param pos: posicion en x del zombie que se deasea eliminar 
	 * @return zombie
	 */
	public Zombie eliminarZombie(int pos) {
		
		if (getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			if (zombieIzq == null) {
				return zombieDer == null ? null : zombieDer;
			} else if (zombieDer == null) {
				return zombieIzq;
			}

			Zombie succesor = zombieDer.darMenor();
			zombieDer = zombieDer.eliminarZombie(succesor.getPosX());
			succesor.zombieIzq = zombieIzq;
			succesor.zombieDer = zombieDer;
			return succesor;

		} else if (getPosX() > pos) {
			zombieIzq = zombieIzq.eliminarZombie(pos);
		} else {
			zombieDer = zombieDer.eliminarZombie(pos);
		}

		return this;
	}
	
}
