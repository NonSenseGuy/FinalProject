package modelo;

public class Escenario {
	
	public final int FINAL_ESCENARIO = 1300;
	public final int INICIO_ESCENARIO = -100;
	public final static String[] ESCENARIOS = { "./img/background2.png", "./img/background3.png", "./img/background4.png"};
	private String imagen;
	private Escenario anterior;
	private Escenario siguiente;
	private Boss[] boss;
	private PersonajePrincipal pPrincipal;
	private Botiquin botiquin;
	
	public Botiquin getBotiquin() {
		return botiquin;
	}

	public void setBotiquin(Botiquin botiquin) {
		this.botiquin = botiquin;
	}

	public Escenario(String imagen){
		this.imagen = imagen;
		
		
	}
	
	public void generarBosses(int nivel) {
		boss = new Boss[nivel];
		boolean pos = true;
		for(int i = 0; i < boss.length; i++) {
			pos = pos ? false:true;
			boss[i] = new Boss(Boss.VIDA+(50*nivel), getPosicionBoss(pos),Boss.IMAGEN_BOSS, Boss.DANO, Boss.RADIO_ATAQUE );
		}
	}
	
	
	public PersonajePrincipal getPersonajePrincipal() {
		return pPrincipal;
	}
	
	public void setPersonajePrincipal(PersonajePrincipal p) {
		pPrincipal = p;
	}

	public Escenario getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Escenario siguiente) {
		this.siguiente = siguiente;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public int getPosicionBoss(boolean pos) {
		if(pos) {
			return FINAL_ESCENARIO + (int) (Math.random()*300);
		}else {
			return INICIO_ESCENARIO - (int) (Math.random()*300);
		}
	}
	
	public Boss[] getBoss() {
		return boss;
	}
	
	public void setBoss(Boss[] b) {
		boss = b;
	}
	
	public Escenario getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Escenario anterior) {
		this.anterior = anterior;
	}
	
	public boolean intersecta(Personaje p) {
		if(p instanceof Boss) {
			Boss b = (Boss) p;
			if(b.getHitBox().contains(pPrincipal.getPosX(), PersonajePrincipal.POS_Y)) {
				return true;
			}
			//pPrincipal.setVida(pPrincipal.getVida() + b.getDamage());
		}else if(p instanceof Zombie) {
			Zombie z = (Zombie) p;
			if(z.getHitBox().contains(pPrincipal.getPosX(), PersonajePrincipal.POS_Y)) {
				return true;
			}
		}
		return false;
	}
	
	public void eliminarBoss() {
		for(int i = 0; i < boss.length; i++) {
			if(boss[i].getVida() <= 0) {
				if(boss[i].getZombie() != null) {
					boss[i].setImagen("");
					boss[i].setDamage(0);
					boss[i].setPosX(5000);
				}else {
					boss[i] = null;
				}				
			}
		}
	}
	
	
}
