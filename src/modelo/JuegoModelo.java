package modelo;

public class JuegoModelo{
	
	private String nickname;
	private int score;
	private int nivel;
	private Escenario escenario;
	
	public JuegoModelo(String nickname, int score, int nivel) {
		this.nickname = nickname;
		this.score = score;
		this.nivel = nivel;
		PersonajePrincipal p = new PersonajePrincipal(640, PersonajePrincipal.IMAGEN);
		escenario = new Escenario(Escenario.ESCENARIOS[0],p);
		escenario.setSiguiente(new Escenario(Escenario.ESCENARIOS[1], p));
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
		if(nivel <= 2) {
			return escenario;
		}else{
			escenario = escenario.getSiguiente();
			return escenario;
		}
	}
	
	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}
	
}
