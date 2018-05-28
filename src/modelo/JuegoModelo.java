package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
	public final static String PUNTAJES = "data/puntajes.txt";
	private String nickname;
	private int score;
	private int nivel;
	private Escenario primero;
	private Escenario elegido;
	private Puntaje raiz;
	private ArrayList<Puntaje> puntajes;
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
		p.agregarArma(new ArmaTiro("9mm", 20, "./img/gun.png", 1));
		p.setArmaElegida(p.getArmaPrimera());
		//p.setArmaElegida(new RayGun("RayGun", 30, RayGun.IMAGEN_RAYGUN));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[0]));
		primero.setPersonajePrincipal(p);
		primero.generar(1);
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
			bw.append(nickname + " " + nivel + " " + score);
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
			p.agregarArma(new Rocket("Rocket", Rocket.IMAGEN_ROCKET, 200));
		}else if(getNivel() == 4) {
			p.agregarArma(new RayGun("RayGun",RayGun.IMAGEN_RAYGUN));
		}else if(getNivel() == 9) {
			p.getArmaElegida().setDamage(p.getArmaElegida().getDamage() + 5);
		}
		
		elegido = elegido.getSiguiente();
		elegido.generar(nivel);
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
	public Puntaje getRaiz() {
		return raiz;
	}
	public void setRaiz(Puntaje raiz) {
		this.raiz = raiz;
	}
	public ArrayList<Puntaje> getPuntajes() {
		return puntajes;
	}
	public void setPuntajes(ArrayList<Puntaje> puntajes) {
		this.puntajes = puntajes;
	}
	
	public static ArrayList<Puntaje> leerPuntajes(){
		File file = new File(PUNTAJES);
		FileReader fr = null;
		BufferedReader br  = null;
		ArrayList<Puntaje> puntajes = new ArrayList<Puntaje>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String text = "";
			//br.readLine();
			while((text = br.readLine()) != null) {
				String[] datos = text.split(" ");
				String nickname = datos[0];
				int nivel = Integer.valueOf(datos[1]);
				int score = Integer.valueOf(datos[2]);
				Puntaje puntaje = new Puntaje(nickname, nivel, score);
				puntajes.add(puntaje);
			}
			
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return puntajes;
	}
	
	public static Puntaje[] organizarPorNickname(ArrayList<Puntaje> puntajes) {
		Puntaje[] puntajesOrganizados = new Puntaje[puntajes.size()];
		puntajesOrganizados = puntajes.toArray(puntajesOrganizados);
		for(int i = puntajesOrganizados.length; i > 0; i--) {
			for(int j = 0; j < i - 1; j++) {
				if(puntajesOrganizados[j].getNickname().compareTo(puntajesOrganizados[j+1].getNickname()) > 0) {
					Puntaje temp = puntajesOrganizados[j];
					puntajesOrganizados[j] = puntajesOrganizados[j+1];
					puntajesOrganizados[j+1] = temp;
				}
			}
		}
		
		return puntajesOrganizados;
	}
	
	public static Puntaje[] organizarPorPuntaje(ArrayList<Puntaje> puntajes) {
		Puntaje[] puntajesOrganizados = new Puntaje[puntajes.size()];
		puntajesOrganizados = puntajes.toArray(puntajesOrganizados);
		int j;
		Puntaje temp;
		
		for(int i = 1; i < puntajesOrganizados.length; i++) {
			temp = puntajesOrganizados[i];
			j = i - 1;
			while(j >= 0 && temp.getPuntaje() > puntajesOrganizados[j].getPuntaje()) {
				puntajesOrganizados[j+1] = puntajesOrganizados[j];
				j--;
			}
			puntajesOrganizados[j+1] = temp;
		}
		
		return puntajesOrganizados;
	}
	
	public static Puntaje[] organizarPorNivel(ArrayList<Puntaje> puntajes) {
		Puntaje[] puntajesOrganizados = new Puntaje[puntajes.size()];
		puntajesOrganizados = puntajes.toArray(puntajesOrganizados);
		int i,j,pos;
		Puntaje tmp , menor;
		for(i = 0; i < puntajesOrganizados.length -1 ; i++) {
			menor = puntajesOrganizados[i];
			pos = i;
			for(j = i+1; j < puntajesOrganizados.length; j++) {
				if(puntajesOrganizados[j].getNivel() > menor.getNivel()) {
					menor = puntajesOrganizados[j];
					pos = j;					
				}
			}
			if(pos != i) {
				tmp = puntajesOrganizados[i];
				puntajesOrganizados[i] = puntajesOrganizados[pos];
				puntajesOrganizados[pos] = tmp;
				
			}
		}
		
		return puntajesOrganizados;
	}
	
	public static void guardarPuntajeOrganizado(Puntaje[] puntajes) {
		File file = new File(PUNTAJES);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for(int i = 0; i < puntajes.length; i++) {
				bw.append(puntajes[i].getNickname() + " " + puntajes[i].getNivel() + " " + puntajes[i].getPuntaje());
				bw.newLine();
			}
			
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
	
	public static Puntaje busquedaBinariaPuntaje(int puntaje, ArrayList<Puntaje> puntajes) {
		Puntaje[] arrayPuntaje = new Puntaje[puntajes.size()];
		arrayPuntaje = puntajes.toArray(arrayPuntaje);
		
		int n = arrayPuntaje.length;
		int centro, inf = 0, sup = n-1;
		while(inf <= sup) {
			centro = (sup+inf)/2;
			if(arrayPuntaje[centro].getPuntaje() == puntaje) {
				return arrayPuntaje[centro];
			}else if(puntaje > arrayPuntaje[centro].getPuntaje()) {
				sup = centro -1;
			}else{
				inf = centro + 1;
			}
		}
		return null;
	}
	
	public static Puntaje busquedaBinariaPorNivel(int nivel, ArrayList<Puntaje> puntajes) {
		Puntaje[] arrayPuntaje = new Puntaje[puntajes.size()];
		arrayPuntaje = puntajes.toArray(arrayPuntaje);
		
		int n = arrayPuntaje.length;
		int centro, inf = 0, sup = n-1;
		while(inf <= sup) {
			centro = (sup+inf)/2;
			if(arrayPuntaje[centro].getNivel() == nivel) {
				return arrayPuntaje[centro];
			}else if(nivel > arrayPuntaje[centro].getNivel()) {
				sup = centro -1;
			}else{
				inf = centro + 1;
			}
		}
		return null;
	}
}
