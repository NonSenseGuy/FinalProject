package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.*;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{
	
	private JuegoModelo jm;
	private PanelJuego pj;
	private PanelMenu pm;
	
	public VentanaPrincipal() {
		setTitle("Zombies Pixel War");
		setSize(1280,720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
		setResizable(false);	
		setLayout(new BorderLayout());
		
		pm = new PanelMenu(this);
		add(pm);
				
	}
	
	public VentanaPrincipal(JuegoModelo jm2) {
		jm = jm2;
		setTitle("Zombies Pixel War");
		setSize(1280,720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
		setResizable(false);	
		setLayout(new BorderLayout());
		
		pj = new PanelJuego(this);
		add(pj);
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
			jm.getEscenario().getPersonajePrincipal().moverPersonaje(-1);
		}else if(keyCode == KeyEvent.VK_D){
			jm.getEscenario().getPersonajePrincipal().moverPersonaje(1);
		}
		pj.repaint();
		
	}

	public void dispararPersonajePrincipal(int keyCode) {
		jm.getEscenario().getPersonajePrincipal().disparar();
		
	}
}
