package modelo;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Interfaz para los metodos generar presentes en Boss, y Escenario y Objeto
 */
public interface Generar {
	/**
	 * Metodo que permite generar objetos respecto a una cantidad deseada
	 * @param cant: Numero de objetos que se quiere crear
	 */
	void generar(int cant);
}
