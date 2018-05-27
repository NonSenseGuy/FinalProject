package interfaz;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import hilos.HiloBalas;
import hilos.HiloBotiquines;
import hilos.HiloEnemigos;
import hilos.HiloPersonaje;
import modelo.JuegoModelo;
import modelo.PersonajePrincipal;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{
	
	public final static int ANCHO_VENTANA = 1280;
	public final static int ALTO_VENTANA = 720;
	private JuegoModelo jm;
	private PanelJuego pj;
	private PanelMenu pm;
	private HiloPersonaje hiloPersonaje;
	private HiloBalas hiloBalas;
	private HiloEnemigos hiloEnemigos;
	private HiloBotiquines hiloBotiquines;
	
	public VentanaPrincipal() {
		setTitle("Zombies Pixel War");
		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
		setResizable(false);	
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		pm = new PanelMenu(this);
		add(pm);
				
	}
	
	public VentanaPrincipal(JuegoModelo jm2) {
		jm = jm2;
		setTitle("Zombies Pixel War");
		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
		setResizable(false);	
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		pj = new PanelJuego(this);
		add(pj);
		hiloPersonaje = new HiloPersonaje(jm.getElegido().getPersonajePrincipal(), this);
		hiloPersonaje.start();
		hiloBalas = new HiloBalas(jm.getElegido().getPersonajePrincipal(), this);
		hiloBalas.start();
		hiloEnemigos = new HiloEnemigos(jm, this);
		hiloEnemigos.start();
		hiloBotiquines = new HiloBotiquines(this, jm);
		hiloBotiquines.start();
		
		
	}

	public JuegoModelo getJuegoModelo() {
		return jm;
	}	
	
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}

	public void moverPersonajePrincipal(int keyCode) {
		
		if(keyCode == KeyEvent.VK_A) {
			jm.getElegido().getPersonajePrincipal().setVelocidad(-PersonajePrincipal.VELOCIDAD);
		}else if(keyCode == KeyEvent.VK_D){
			jm.getElegido().getPersonajePrincipal().setVelocidad(PersonajePrincipal.VELOCIDAD);;
		}
	}

	public void dispararPersonajePrincipal(int keyCode) {
		if(keyCode == KeyEvent.VK_LEFT) {
			jm.getElegido().getPersonajePrincipal().disparar(keyCode);
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			jm.getElegido().getPersonajePrincipal().disparar(keyCode);
		}		
	}

	public void reset() {
		VentanaPrincipal v = new VentanaPrincipal();
		this.dispose();
		v.setVisible(true);
		
	}

	public void guardarPuntaje() {
		// TODO Auto-generated method stub
		
	}
}
