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
		primero = new Escenario(Escenario.ESCENARIOS[0],p, 1);

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
	//VOLVER ESCENARIOS UNA LISTA CICLICA
	public Escenario getEscenario() {
		if(nivel <= 2) {
			return primero;
		}else{
			primero = primero.getSiguiente();
			return primero;
		}
	}
	public Escenario getPrimero() {
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
	
	
}
