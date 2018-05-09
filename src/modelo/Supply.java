package modelo;

public class Supply extends Objeto{
	
	private Arma armaNueva;
	
	public Supply(int posX, int posY) {
		super(posX, posY);
	}
	
	public Arma getArmaNueva() {
		return armaNueva;
	}	
	
}
