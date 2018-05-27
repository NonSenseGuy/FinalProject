package modelo;

public class Boss extends Personaje implements Disparar, Generar{

	
	public final static String IMAGEN_BOSS = "./img/Boss.png";
	public final static int RADIO_ATAQUE = 400; 
	public final static int DANO = 10;
	public final static int VIDA = 100;
	public final static int SCORE = 60;
	private int damage;
	private int radioDistanciaAtaque;
	private boolean atacar;
	private int score;
	private Zombie zombie;
	
	
	public Boss(int vida, int posX, String imagen, int damage, int radioDistanciaAtaque) {
		super(vida, posX, imagen);
		this.damage = damage;
		this.radioDistanciaAtaque = radioDistanciaAtaque;
		setHitBox();
		atacar = false;
		score = SCORE;
		generar(4);
		if(getPosX() < 1000 ) {
			setVelocidad(5);
		}else if(getPosX() > 1000) {
			setVelocidad(-5);
		}
	}
	public int getDamage() {
		return damage;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getRadioDistanciaAtaque() {
		return radioDistanciaAtaque;
	}
	public void setRadioDistanciaAtaque(int radioDistanciaAtaque) {
		this.radioDistanciaAtaque = radioDistanciaAtaque;
	}
	
	public boolean getAtacar() {
		return atacar;
	}
	
	public void setAtacar(boolean atacar) {
		this.atacar = atacar;
	}
	
	public Zombie getZombie() {
		return zombie;
	}
	
	@Override
	public void disparar(int direccion) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void generar(int cant) {
		if(cant != 0) {
			Zombie z = generarZombie();
			agregarZombie(z);
			generar(cant-1);
		}
	}
	
	public Zombie generarZombie() {
		boolean positivo = Math.random() > 0.5;
		int rango = positivo ? 1 : -1;
		Zombie z = new Zombie(getPosX() + (int) (Math.random()*300 *rango),Zombie.IMAGEN_ZOMBIE,Zombie.DANO );
		return z;
	}
	
	public void agregarZombie(Zombie z) {
		if(zombie == null) {
			zombie = z;
		}else {
			zombie.agregarZombie(z);
		}
	}
	
	public boolean quitarVidaBoss(int pos, int damageBala) {
		
		boolean golpeado = false;
		
		if(getHitBox().contains(pos, PersonajePrincipal.POS_Y)) {
			golpeado = true;
			setVida(getVida() - damageBala);
		}
		
		return golpeado;
	}
	
	public boolean eliminarZombie(int pos) {
		boolean elimino = false;
		
		Zombie a = buscarZombie(pos);
		if (a != null) {
			elimino = true;
			zombie = zombie.eliminarZombie(a.getPosX());
		}
		return elimino;
	}
	
	public Zombie buscarZombie(int pos) {
		if(zombie == null) {
			return null;
		}else {
			return zombie.buscarZombie(pos);
		}
	}
	
	public Zombie localizarZombieMuerto() {
		if(zombie != null) 	return zombie.localizarZombieMuerto();		
		return null;
	}
}
