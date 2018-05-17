package interfaz;

import javax.swing.JFrame;
import modelo.*;

public class VentanaPrincipal extends JFrame{
	
	private PanelJuego pj;
	
	public VentanaPrincipal() {
		setTitle("Pixel Z");
		setSize(1280,720);
		
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}
