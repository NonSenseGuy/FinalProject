package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite inicializar un puntaje para agregar a la tabla de puntajes
 */
public class Puntaje {
	private String nickname;
	private int nivel;
	private int puntaje;
	private Puntaje izq;
	private Puntaje der;
	/**
	 * Constructor que permite instanciar un puntaje nuevo	
	 * @param nickname:  Nombre del jugador
	 * @param nivel: Nivel al cual llego el jugador
	 * @param puntaje: Puntaje maximo que hizo el jugador
	 */
	public Puntaje(String nickname, int nivel, int puntaje) {
		this.nickname = nickname;
		this.nivel = nivel;
		this.puntaje = puntaje;
	}
	/**
	 * Permite retornar el nombre del jugador
	 * @return nickName:  Nombre del jugador del puntaje 
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Permite modificar el nombre del jugador
	 * @param nickname: Nuevo nombre del jugador donde nickName != null y nickName != ""
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * Permite retornar el nivel el cual llego un jugador
	 * @return nivel:  Nivel del jugador en el juego.
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Permite modificar el nivel del jugador
	 * @param nivel:  Nuevo nivel del jugador donde nivel > 0 y nivel != null 
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * Permite retornar el puntaje maximo que hizo un jugador
	 * @return puntaje: Puntaje que hizo el jugador
	 */
	public int getPuntaje() {
		return puntaje;
	}
	/**
	 * Permite modificar el puntaje maximo que hizo un jugador
	 * @param puntaje:  El nuevo puntaje a cambiarel viejo donde puntaje >= 0 y puntaje != null
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	/**
	 * Permite retornar el puntaje izquierdo del puntaje actual en el arbol binario de puntajes
	 * @return izq: Es el puntaje izquiero al actual en el arbol binario de puntajes.
	 */
	public Puntaje getIzq() {
		return izq;
	}
	/**
	 * Permite modificar la instancia del puntaje izquierdo al puntaje actual en el arbol binario de puntajes
	 * @param izq:  Es el nuevo izquierdo del puntaje actual en el arbol binario
	 */
	public void setIzq(Puntaje izq) {
		this.izq = izq;
	}
	/**
	 * Permite retornar el puntaje derecho del puntaje actual en el arbol binario de puntajes
	 * @return der: Es el puntaje derecho al actual en el arbol binario de puntajes.
	 */
	public Puntaje getDer() {
		return der;
	}
	/**
	 * Permite modificar la instancia del puntaje izquierd derecho al puntaje actual en el arbol binario de puntajes
	 * @param der:  Es el nuevo derecho del puntaje actual en el arbol binario
	 */
	public void setDer(Puntaje der) {
		this.der = der;
	}
	
	
}
