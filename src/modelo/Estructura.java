package modelo;

public class Estructura extends Objeto implements Explosion{
	
	private boolean explosivo;
	private int radioExplosion;
	public Estructura(int posX, int posY, boolean explosivo, int radioExplosion) {
		super(posX, posY);
		this.explosivo = explosivo;
		this.radioExplosion = radioExplosion;
	}
	public boolean isExplosivo() {
		return explosivo;
	}
	public void setExplosivo(boolean explosivo) {
		this.explosivo = explosivo;
	}
	public int getRadioExplosion() {
		return radioExplosion;
	}
	public void setRadioExplosion(int radioExplosion) {
		this.radioExplosion = radioExplosion;
	}
	@Override
	public void explosion() {
		// TODO Auto-generated method stub
		
	}	
	
}
