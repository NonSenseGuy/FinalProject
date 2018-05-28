package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 * Interfaz para los metodos mover presentes en la clase Bala y clase Personaje
 */
public interface Mover {
	/**
	 * Permite mover un objeto a cierta distancia pasada por parametro
	 * @param distancia: Distancia que tiene que recorrer el objeto
	 */
	void mover(int distancia);
}
