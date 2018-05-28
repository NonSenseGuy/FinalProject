package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * Clase que controla todo el juego
 */
public class JuegoModelo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String GUARDAR_PARTIDA = "data/cargarPartida.dat";
	public final String PUNTAJES = "data/puntajes.txt";
	private String nickname;
	private int score;
	private int nivel;
	private Escenario primero;
	private Escenario elegido;
	/**
	 * 
	 * @param nickname - Nombre del usuario que va a jugar
	 * @param score - puntaje del usuario que aumentara por cada zombie que mata
	 * @param nivel - nivel en el que esta jugando
	 */
	public JuegoModelo(String nickname, int score, int nivel) {
		this.nickname = nickname;
		this.score = score;
		this.nivel = nivel;
		PersonajePrincipal p = new PersonajePrincipal(640, PersonajePrincipal.IMAGEN);
		p.agregarArma(new ArmaTiro("9mm", 20, 50, "./img/gun.png", 1));
		p.setArmaElegida(p.getArmaPrimera());
		//p.setArmaElegida(new RayGun("RayGun", 30, RayGun.IMAGEN_RAYGUN));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[0]));
		primero.setPersonajePrincipal(p);
		primero.generarBosses(1);
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[1]));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[2]));
		elegido = primero;

	}
	/**
	 * Cambia el nombre del usuario
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Cambia el nombre del usuario
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * Retorna el score que lleva el usuario hasta el momento
	 * @return score: El score actual del juego.
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Modifica el score del juego
	 * @param score 
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Retorna el nivel del juego 
	 * @return nivel 
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Modifica el nivel del juego
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
		subirNivel();
	}
	 /**
	  * Retorna el primer escenario del juego
	  * @return primero
	  */
	public Escenario getEscenario() {
		return primero;
	}
	/**
	 * modifica el primero escenario del juego
	 * @param primero
	 */
	public void setPrimero(Escenario primero) {
		this.primero = primero;
	}
	/**
	 * Retorna el escenario que esta elegido actualmente en el juego
	 * @return elegido
	 */
	public Escenario getElegido() {
		return elegido;
	}
	/**
	 * Cambia el escenario elegido en el juego
	 * @param elegido
	 */
	public void setElegido(Escenario elegido) {
		this.elegido = elegido;
	}
	/**
	 * Agrega un escenario a la lista doblemente enlazada ciclica de escenarios
	 * @param escenario
	 */
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
	
	/**
	 * Guarda el nickname, nivel y puntaje alcanzados en un archivo de texto
	 */
	public void guardarPuntaje() {
		File file = new File(PUNTAJES);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			/*if(!file.exists()) {
				file.createNewFile();
			}*/
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.append(nickname + "  " + nivel + "  " + score);
			bw.newLine();
			
			try {
				if(bw != null) {
					bw.close();
				}if(fw != null) {
					fw.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *Cambia el escenario y pasa el personaje principal al nuevo escenario
	 *Este metodo se llama unicamente al subir de nivel;
	 */
	public void subirNivel() {
		PersonajePrincipal p = elegido.getPersonajePrincipal();
		
		if(getNivel() == 2) {
			p.agregarArma(new Rocket("Rocket", 15, Rocket.IMAGEN_ROCKET, 200));
		}else if(getNivel() == 4) {
			p.agregarArma(new RayGun("RayGun", 30, RayGun.IMAGEN_RAYGUN));
		}
		
		elegido = elegido.getSiguiente();
		elegido.generarBosses(nivel);
		elegido.setPersonajePrincipal(p);
		guardarPartida();
		
	}
	
	public void guardarPartida() {
		File file = new File(GUARDAR_PARTIDA);
		if(file.exists()) {
			file.delete();
		}
		FileOutputStream fs = null;
		ObjectOutputStream  os = null;
		try {
			fs = new FileOutputStream(file);
			os = new ObjectOutputStream(fs);
			elegido.setBotiquin(null);
			os.writeObject(this);
			
			try {
				if(os != null) {
					os.close();
				}
				if(fs != null) {
					fs.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JuegoModelo cargarPartida() {
		File file = new File(GUARDAR_PARTIDA);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		JuegoModelo jm = null;
		
		try {
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				jm = (JuegoModelo) ois.readObject();
				try {
					if(ois != null) {
						ois.close();
					}
					if(fis != null) {
						fis.close();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jm;
	}
	
	
	
}
