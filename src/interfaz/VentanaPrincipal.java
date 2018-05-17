package interfaz;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import modelo.*;

public class VentanaPrincipal extends JFrame{
	
	private JuegoModelo jm;
	private PanelJuego pj;
	private PanelMenu pm;
	
	public VentanaPrincipal() {
		setTitle("Pixel ZombieWar");
		setSize(1280,720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
				
	}
	
	public JuegoModelo getJuegoModelo() {
		return this.jm;
	}	
	
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
