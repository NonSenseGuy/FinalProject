package modelo;

public class JuegoModelo implements Generar{
	
	private String nickname;
	private int score;
	private int nivel;
	private Escenario escenario;
	
	public JuegoModelo(String nickname, int score, int nivel) {
		this.nickname = nickname;
		this.score = score;
		this.nivel = nivel;
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
	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}	
	
}
