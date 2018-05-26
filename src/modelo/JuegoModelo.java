package modelo;

public class JuegoModelo{
	
	private String nickname;
	private int score;
	private int nivel;
	private Escenario primero;
	private Escenario elegido;
	
	public JuegoModelo(String nickname, int score, int nivel) {
		this.nickname = nickname;
		this.score = score;
		this.nivel = nivel;
		PersonajePrincipal p = new PersonajePrincipal(640, PersonajePrincipal.IMAGEN);
		p.agregarArma(new ArmaTiro("9mm", 20, 50, " ", 1));
		p.setArmaElegida(p.getArmaPrimera());
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[0],p, 1));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[1],p, 2));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[2],p, 3));
		elegido = primero;

	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public Escenario getEscenario() {
		return primero;
	}
	public void setPrimero(Escenario primero) {
		this.primero = primero;
	}
	public Escenario getElegido() {
		return elegido;
	}
	public void setElegido(Escenario elegido) {
		this.elegido = elegido;
	}
	
	public void agregarEscenario(Escenario escenario) {
		if(primero == null) {
			primero = escenario;
		}else if(primero.getSiguiente() == null) {
			escenario.setSiguiente(primero);
			escenario.setAnterior(primero);
			primero.setSiguiente(escenario);
			primero.setAnterior(escenario);
		}else {
			Escenario anterior = primero.getAnterior();
			primero.setAnterior(escenario);
			escenario.setSiguiente(primero);
			escenario.setAnterior(anterior);
			anterior.setSiguiente(escenario);
		}
	}
	
	
}
