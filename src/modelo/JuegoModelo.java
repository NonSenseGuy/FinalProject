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

	private static final long serialVersionUID = 1L;
	public final static String GUARDAR_PARTIDA = "data/cargarPartida.dat";
	public final static String PUNTAJES = "data/puntajes.txt";

	private String nickname;
	private int score;
	private int nivel;
	private Escenario primero;
	private Escenario elegido;
	private ArrayList<Puntaje> puntajes;
	/**
	 * Constructor que permite inizialiar el JuegoModelo
	 * 
	 * @param nickname: Nombre del usuario que va a jugar
	 * @param score: puntaje del usuario que aumentara por cada zombie que mata
	 * @param nivel: nivel en el que esta jugando
	 */
	public JuegoModelo(String nickname, int score, int nivel) {
		this.nickname = nickname;
		this.score = score;
		this.nivel = nivel;
		PersonajePrincipal p = new PersonajePrincipal(640, PersonajePrincipal.IMAGEN);
		p.agregarArma(new ArmaTiro("9mm", 20, "./img/gun.png", 1));
		p.setArmaElegida(p.getArmaPrimera());
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[0]));
		primero.setPersonajePrincipal(p);
		primero.generar(1);
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[1]));
		agregarEscenario(new Escenario(Escenario.ESCENARIOS[2]));
		elegido = primero;
	}
	/**
	 * Permite retonar el nickName del jugador
	 * @return nickname: Nombre del jugador
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Cambia el nombre del usuario
	 * @param nickname: Nuevo Nombre del jugador
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
	 * Modifica el puntaje actuald el juagador
	 * @param score: puntaje nuevo del jugador
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Retorna el nivel actual del juego
	 * @return nive:  El nivel actual del juego
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Permite modificar el nivel actual del juego
	 * @param nivel:  Nuevo nivel del juego
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
		subirNivel();
	}
	 /**
	  * Retorna el primer escenario del juego
	  * @return primero: Raiz de la lista enlazada de escenarios
	  */
	public Escenario getEscenario() {
		return primero;
	}
	/**
	 * modifica el primero escenario del juego
	 * @param primero:  Nueva raiz de la lalista enlazada de escenarios
	 */
	public void setPrimero(Escenario primero) {
		this.primero = primero;
	}
	/**
	 * Retorna el escenario que esta elegido actualmente en el juego
	 * @return elegido:  Escenario actual del juego
	 */
	public Escenario getElegido() {
		return elegido;
	}
	/**
	 * permite modificar el escenario actual elegido en el juego
	 * @param elegido: nuevo escenario elegido para el juego actual donde elegido != null
	 */
	public void setElegido(Escenario elegido) {
		this.elegido = elegido;
	}
	/**
	 * Agrega un escenario a la lista doblemente enlazada ciclica de escenarios
	 * @param escenario: Nuevo escenario a agregar a la lista donde escenario != null
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
	 * Guarda el nickname, nivel y puntaje alcanzados por el jugador en en un archivo de texto plano
	 * <b>post: </b> Se ha guardado los datos del jugador exitosamente y hay caso contrario, el metodo lo hara saber
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
	 * Cambia el escenario y pasa el personaje principal al nuevo escenario ademas se subir el nivel al juego modelo
	 * Este metodo se llama unicamente al subir de nivel
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
	/**
	 * Permite guardar la partida actual del jugador con serializable, la partida se guarda cada vez que el jugador pasa de nivel
	 * <b>post: </b> Se guarda la partida en los archivos del juego, en caso de error, el metodo lo hace saber
	 */
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
	/**
	 * Permite cargar una partida guardada en la aplicacion
	 * @return partida: Parida guardada en la aplicacion para ejecutarla en la interfaz
	 */
	
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
	
	/**
	 * Permite retornar el ArrayList con todos los puntajes guardados
	 * @return puntajes: Puntajes gurdados para mostrarlos en una tabla de puntajes
	 */
	public ArrayList<Puntaje> getPuntajes() {
		return puntajes;
	}
	/**
	 * Permite leer los puntajes guardados en la aplicacion y retornarlos como un ArrayList
	 * @return puntajes: Puntajes guardados enla aplicacion
	 */
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
	/**
	 * Permite organizar los puntajes de manera alfabetica segun el nombre del jugador 
	 * @param puntajes: Arreglo de puntajes guardados en la aplicacion
	 * @return puntaje: arreglo de puntajes quee estan organizados de manera alfabetica
	 */
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
	/**
	 * Permite organizar los puntajes de manera descendente segun el puntaje de cada jugador
	 * @param puntajes: Arreglo de puntajes guardados en la aplicacion
	 * @return puntaje: Arreglo de puntajes que estan organizados de manera descencente de acuerdo al puntaje
	 */
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
	/**
	 * Permite organizar los puntajes de manera descendente segun el nivel de cada jugador
	 * @param puntajes: Arreglo de puntajes guardados en la aplicacion
	 * @return puntaje: Arreglo de puntajes organizados de manera descendente de acuerdo al nivel
	 */
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
	/**
	 * Permite reescribir los puntajes guardados y los orgniza de manera descendente de acuerdo al puntaje
	 * @param puntajes: Arreglo de puntajes ya organizadosde manera descendente de acuerdo al nivel
	 */
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
	/**
	 * Permite buscar un puntaje en una lista de puntajes dadas por parametro y retorna una instancia de clase puntaje que tiene ese puntaje
	 * de lo contrario retorna null
	 * @param puntaje: Puntaje a buscar en un arreglo, puntaje mayor o igual a  0
	 * @param puntajes: Arreglo de puntajes donde se desea encontrar el jugador con ese puntaje, donde puntajes sea diferente de null
	 * @return puntajeBuscado: instancia de la Clase puntaje que tiene todos los datos del jugaodor con ese score
	 */
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
	/**
	 * Permite buscar un nivel en una lista de puntajes dadas por parametro y retorna una instancia de clase puntaje que tiene ese nivel
	 * de lo contrario retorna null
	 * @param nivel: Nivel a buscar en un arreglo, nivel mayor que 0
	 * @param puntajes: Arreglo de puntajes donde se desea encontrar el jugador con ese nivel, donde puntajes sea diferente de null
	 * @return nivelBuscado: instancia de la Clase puntaje que tiene todos los datos del jugaodor con ese nivel
	 */
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
	public void setEscenario(Escenario e) {
		this.primero = e;
		
	}
	
}
