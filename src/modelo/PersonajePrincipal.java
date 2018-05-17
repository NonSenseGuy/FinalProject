package modelo;

public class PersonajePrincipal extends Personaje implements Disparar{
	
	public final static int VIDA = 100;
	private Arma arma;

	public PersonajePrincipal(int posX, String imagen) {
		super(VIDA, posX, imagen);
		setHitBox();
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
}
