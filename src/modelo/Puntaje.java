package modelo;

public class Puntaje {
	private String nickname;
	private int nivel;
	private int puntaje;
	private Puntaje izq;
	private Puntaje der;
	
	public Puntaje(String nickname, int nivel, int puntaje) {
		this.nickname = nickname;
		this.nivel = nivel;
		this.puntaje = puntaje;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Puntaje getIzq() {
		return izq;
	}

	public void setIzq(Puntaje izq) {
		this.izq = izq;
	}

	public Puntaje getDer() {
		return der;
	}

	public void setDer(Puntaje der) {
		this.der = der;
	}
	
	
}
