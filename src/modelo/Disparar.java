package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Interfaz para los metodos disparar y dispararBala presentes en Personaje principal y Arma
 */
public interface Disparar {
	/**
	 * Permite disparar un objeto respecto a la direccion que se de como parametro que va en relacion con las constanes de las teclas del teclado
	 * @param direccion:  Codigo de la tecla que se ha oprimido
	 */
	void disparar(int direccion);
	/**
	 * Permite disparar una bala que incia en una posicion dada por el parametro
	 * @param posX: poscion inicial y actual de la bala
	 */
	void dispararBala(int posX);
}
