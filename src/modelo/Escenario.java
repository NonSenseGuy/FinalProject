package modelo;

import java.io.Serializable;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite crear una instancia de Escenario para la interfaz grafica
 */
public class Escenario implements Serializable, Generar {
	
	private static final long serialVersionUID = 1L;
	public final int FINAL_ESCENARIO = 1300;
	public final int INICIO_ESCENARIO = -100;
	public final static String[] ESCENARIOS = { "./img/background2.png", "./img/background3.png", "./img/background4.png"};
	
	private String imagen;
	private Escenario anterior;
	private Escenario siguiente;
	private Boss[] boss;
	private PersonajePrincipal pPrincipal;
	private Botiquin botiquin;
	/**
	 * Constructor que permite crear una instancia se una escenario la cual tiene una ruta de imagen
	 * @param imagen: Ruta de imagen la cual se enseña en la interfaz grafica
	 */
	public Escenario(String imagen){
		this.imagen = imagen;		
	}
	
	/**
	 * Permite retornar el botiquin de vida presente en el escenario actual.
	 * @return
	 */
	public Botiquin getBotiquin() {
		return botiquin;
	}
	/**
	 * Permite modificar el botiquin por uno nuevo
	 * @param botiquin: Nuevo botiquin, botiquin != null
	 */
	public void setBotiquin(Botiquin botiquin) {
		this.botiquin = botiquin;
	}
	
	@Override
	public void generar(int nivel) {
		boss = new Boss[nivel];
		boolean pos = true;
		for(int i = 0; i < boss.length; i++) {
			pos = pos ? false:true;
			boss[i] = new Boss(Boss.VIDA+(50*nivel), getPosicionBoss(pos),Boss.IMAGEN_BOSS, Boss.DANO);
		}
	}
	/**
	 * Permite retornar el personaje principal presente en el escenario
	 * @return pPrincipal: Personaje principal que esta en el escenario
	 */
	public PersonajePrincipal getPersonajePrincipal() {
		return pPrincipal;
	}
	/**
	 * Permite modificar el personaje principal ubicado en el escenario
	 * @param p: nuevo peronaje principal le cual p != null
	 */
	public void setPersonajePrincipal(PersonajePrincipal p) {
		pPrincipal = p;
	}
	/**
	 * Permite retornar el escenario siguiente de la lista enlazada de escenarios
	 * @return siguiente: Escenario siguiente al escenario actual en la lista enlazada
	 */
	public Escenario getSiguiente() {
		return siguiente;
	}
	/**
	 * Permite modificar el siguiente escenario del escnario actual en la lista enlazada
	 * @param siguiente: nuevo escenario siguiene el cual siguiente != null
	 */
	public void setSiguiente(Escenario siguiente) {
		this.siguiente = siguiente;
	}
	/**
	 * Permite retornar la ruta en la cual se encuentra la imagen para la interfaz grafica
	 * @return iamgen: ruta de la imagen a mostrar en la interfaz grafica
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Permite modificar la ruta de la imagen que se muestra en la interfaz grafica
	 * @param imagen: nueva ruta de imagen que se muestra en la interfaz grafica imagen != "" y imagen != null
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * Permite retornar una posicion random entre un rango dado dependiendo de las de un booleano, hace que la posicion sea a mano izquierda, del comienzo del
	 * escenario, o a mano derecha, del final del escenario para los bosses
	 * 
	 * <b>pre: </b> El arreglo de bosses ya debe estar inicializado
	 * 
	 * @param pos: booleano que decide que valor toma lo retornado, si es true, sale al comienzo del escenario, si es false, al final
	 * @return posicion:  posicion que va a tomar uno de los bosses respecto al booleano que se pasa por parametro
	 */
	public int getPosicionBoss(boolean pos) {
		if(pos) {
			return FINAL_ESCENARIO + 200 + (int) (Math.random()*400);
		}else {
			return INICIO_ESCENARIO - 200 - (int) (Math.random()*400);
		}
	}
	/**
	 * Permite retonar el arreglo de bosses presentes en el escenario
	 * @return boss: Arreglo de bosses en el escenario
	 */
	
	public Boss[] getBoss() {
		return boss;
	}
	/**
	 * Permite modificar el arreglo de bosses en el escenario
	 * @param b: Nuevo arreglo de bosses que se deasea implementar en el escenario b != null
	 */
	public void setBoss(Boss[] b) {
		boss = b;
	}
	/**
	 * Permite retornar el escenario anterior del escenario actual en la lista enlazada de escenarios	
	 * @return anterior: Escenario anterior del actual en la lista enlazada
	 */
	public Escenario getAnterior() {
		return anterior;
	}
	/**
	 * Permite modificar el escenario anterior del escenario actual de la lista enlazada
	 * @param anterior: Nuevo escenario que se quiere poner como anterior, anterior != null
	 */
	public void setAnterior(Escenario anterior) {
		this.anterior = anterior;
	}
	/**
	 * Permite saber si un Zombie o un Boss intersecta con el personaje principal, si es asi, el metodo retorna true, en el caso contrario retorna false
	 * 
	 * <b>pre: </b> Arreglo de bosses inicializado y perosnaje Princiapal incializado
	 * 
	 * @param p: Zombie o boss el cual se quiere saber si intersecta con el personaje principal, p != null
	 * @return leDio: retorna true si intersecta con el personaje principal, en caso contrario retorna false
	 */
	public boolean intersecta(Personaje p) {
		if(p instanceof Boss) {
			Boss b = (Boss) p;
			if(b.getHitBox().contains(pPrincipal.getPosX(), PersonajePrincipal.POS_Y)) {
				return true;
			}
		}else if(p instanceof Zombie) {
			Zombie z = (Zombie) p;
			if(z.getHitBox().contains(pPrincipal.getPosX(), PersonajePrincipal.POS_Y)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Permite eliminar un boss de el arreglo de bosses si su vida es <= 0, si su zombie no se ha eliminado, entonces se cambia su posicion en x, el daño = 0, se borra la ruta de imagen
	 * para que no aparezca en la ingerfaz grafica, si el zombie es == null entonces elimina al boss del arreglo de bosses
	 * <b>pre: </b> Arreglo de bosses inicializado
	 * <b>post: </b> Se elimina un boss del arreglo de bosses o se modifica el boss si su intancia de zombie != null
	 */
	public void eliminarBoss() {
		for(int i = 0; i < boss.length; i++) {
			if(boss[i] != null) {
				if(boss[i].getVida() <= 0) {
					if(boss[i].getZombie() != null) {
						boss[i].setImagen("");
						boss[i].setDamage(0);
						boss[i].setPosX(5000);
						boss[i].setScore(0);
					}else {
						boss[i] = null;
					}				
				}
			}
			
		}
	}
	
	
}
