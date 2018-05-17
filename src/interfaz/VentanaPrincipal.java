package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
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
}
