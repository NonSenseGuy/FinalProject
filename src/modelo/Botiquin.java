package modelo;

import java.io.Serializable;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase que permite inicializar un botiquin que cura al personaje principal
 */
public class Botiquin extends Objeto implements Serializable{

	private static final long serialVersionUID = 1L;
	public final String IMAGEN_BOTIQUIN = "./img/botiquin.png";
	public final int VIDA = 20;

	private int vida;
	private String img;
	/**
	 * Contructor que permite crear una instancia de botiquin	
	 * @param posX: la posicion en el eje X del botiquin
	 * @param posY: la posicion en el eje Y del botiquin
	 */
	public Botiquin(int posX, int posY) {
		super(posX, posY);
		this.vida = VIDA; 
		img = IMAGEN_BOTIQUIN;
	}
	/**
	 * Permite retornar la ruta de la imagen del botiquin para la interfaz Grafica
	 * @return img: La ruta de la imagen del botiquin
	 */
	public String getImg() {
		return img;
	}
	/**
	 * Permite modificar la ruta de la imagen del botiquin
	 * @param img: nueva ruta de imagen del botiquin img != null
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * Permite retornar la vida que de vuelve el botiquin si el personaje principal la coge
	 * @return vida: vida a recuperar al personaje principal
	 */
	public int getVida() {
		return vida;
	}
}
