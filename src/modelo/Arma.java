package modelo;

import java.io.Serializable;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * 
 *  Clase padre de los tipos de arma RayGun, ArmaTiro y Rocket
 */
public class Arma implements Disparar, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int damage;
	private String imagenArma;
	private Arma siguiente;
	private Arma anterior;
	
	/**
	 * Constructor padre de las clases RayGun, ArmaTiro y Rocket
	 * @param nombre: Nombre del arma
	 * @param damage: Daño que hace el arma
	 * @param imagenArma: Ruta de la imagen del arma
	 */
	public Arma(String nombre,int damage, String imagenArma) {
		this.nombre = nombre;
		this.damage = damage;
		this.imagenArma = imagenArma;
	}
	/**
	 * Permite retornar el Nombre del arma que se esta instanciando
	 * @return nombre: Nombre del arma que se instancia
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Permite modificar el nombre del arma
	 * 
	 * <b>post: </b> Se le ha cambiado el nombre al arma
	 * 
	 * @param nombre: es el nuevo nombre del arma donde nombre != null y nombre!= ""
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Permite retornar la siguiente arma de el arma actual en la lista enlazada
	 * @return siguiente: Arma siguiente de la actual en la lista enlazada de armas.
	 */
	public Arma getSiguiente() {
		return siguiente;
	}
	/**
	 * Permite modificar el arma siguiente del arma actual de la lista enlazada
	 * @param siguiente: Arma siguiente a la actual en la lista enlazada
	 */
	public void setSiguiente(Arma siguiente) {
		this.siguiente = siguiente;
	}
	/**
	 * Permite retornar la anterior arma de el arma actual en la lista enlazada
	 * @return anterior: Arma anterior de la actual en la lista enlazada de armas.
	 */
	public Arma getAnterior() {
		return anterior;
	}
	/**
	 * Permite modificar el arma anterior del arma actual de la lista enlazada
	 * @param anterior: Arma anterior a la actual en la lista enlazada
	 */
	public void setAnterior(Arma anterior) {
		this.anterior = anterior;
	}
	/**
	 * Permite retornar el daño que hace el arma que se esta instanciando
	 * @return damage:  Daño del arma actual
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Permite modificar el daño del arma
	 * @param damage: Nuevo daño que va a ejercer el arma donde damage != null y damage mayor o igual que 0
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * Permite retornar la ruta de la imagen del Arma
	 * @return image: imagen actual del arma que se muestra en la interfaz grafica
	 */
	public String getImagenArma() {
		return imagenArma;
	}
	/**
	 * Permite modificar la ruta de la imagen del Arma
	 * @param imagen: Nueva ruta de la imagen que se muestra en la interfaz grafica, imagen sea diferente de null e imagen sea diferente de ""
	 */
	public void setImagenArma(String imagen) {
		this.imagenArma = imagen;
	}

	@Override
	public void disparar(int direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispararBala(int posX) {
		// TODO Auto-generated method stub
		
	}
}
