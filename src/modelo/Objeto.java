package modelo;

import java.io.Serializable;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase padre de botiquin
 */
public abstract class Objeto implements Generar, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int posX;
	private int posY;
	/**
	 * Constructor padre de la clase botiquin
	 * 
	 * @param posX: Posicion inicial en X del objeto
	 * @param posY: Posicion inicial en Y del objeto
	 */
	public Objeto(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	/**
	 * Permite retornar la posicion actual del objeto en el plano en el eje X
	 * @return posX: Posicion actual del objeto en el plano en el eje X
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * Permite modificar la poscision actual del objeto en el eje X
	 * @param posX: Nueva posicion del objeto en el eje X
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * Permite retornar la posicion actual del objeto en el plano en el eje X
	 * @return posX: Posicion actual del objeto en el plano en el eje Y
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * Permite modificar la poscision actual del objeto en el eje Y
	 * @param posX: Nueva posicion del objeto en el eje Y
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void generar(int cant) {
		// TODO Auto-generated method stub
		
	}
	
	
}
