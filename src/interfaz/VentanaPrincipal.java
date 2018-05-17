package interfaz;

import java.awt.Graphics;

import javax.swing.JFrame;
import modelo.*;

public class VentanaPrincipal extends JFrame{
	
	private JuegoModelo jm;
	private PanelJuego pj;
	
	public VentanaPrincipal() {
		setTitle("Pixel Z");
		setSize(1280,720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	public void paint(Graphics g) {
		
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
