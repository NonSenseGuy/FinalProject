package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 *@author Luis Alfredo Rodriguez
 *Clase que controla todo el juego
 */
public class JuegoModelo{
	
	private String nickname;
	private int score;
	private int nivel;
	private Escenario primero;
	private Escenario elegido;
	/**
	 * 
	 * @param nickname - Nombre del usuario que va a jugar
	 * @param score - puntaje del usuario que aumentara por cada zombie que mata
	 * @param nivel - nivel en el que esta jugando
	 */
	public JuegoModelo(String nickname, int score, int nivel) {
		this.nickname = nickname;
		this.score = score;
		this.nivel = nivel;
		PersonajePrincipal p = new PersonajePrincipal(640, PersonajePrincipal.IMAGEN);
		p.agregarArma(new ArmaTiro("9mm", 20, 50, " ", 1));
		p.setArmaElegida(p.getArmaPrimera());
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[0],p, 1));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[1],p, 2));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[2],p, 3));
		elegido = primero;

	}
	/**
	 * Cambia el nombre del usuario
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Cambia el nombre del usuario
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * Retorna el score que lleva el usuario hasta el momento
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Modifica el score del juego
	 * @param score 
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Retorna el nivel del juego 
	 * @return nivel 
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Modifica el nivel del juego
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	 /**
	  * Retorna el primer escenario del juego
	  * @return primero
	  */
	public Escenario getEscenario() {
		return primero;
	}
	/**
	 * modifica el primero escenario del juego
	 * @param primero
	 */
	public void setPrimero(Escenario primero) {
		this.primero = primero;
	}
	/**
	 * Retorna el escenario que esta elegido actualmente en el juego
	 * @return elegido
	 */
	public Escenario getElegido() {
		return elegido;
	}
	/**
	 * Cambia el escenario elegido en el juego
	 * @param elegido
	 */
	public void setElegido(Escenario elegido) {
		this.elegido = elegido;
	}
	/**
	 * Agrega un escenario a la lista doblemente enlazada ciclica de escenarios
	 * @param escenario
	 */
	public void agregarEscenario(Escenario escenario) {
		if(primero == null) {
			primero = escenario;
		}else if(primero.getSiguiente() == null) {
			escenario.setSiguiente(primero);
			escenario.setAnterior(primero);
			primero.setSiguiente(escenario);
			primero.setAnterior(escenario);
		}else {
			Escenario anterior = primero.getAnterior();
			primero.setAnterior(escenario);
			escenario.setSiguiente(primero);
			escenario.setAnterior(anterior);
			anterior.setSiguiente(escenario);
		}
	}
	
	
}
