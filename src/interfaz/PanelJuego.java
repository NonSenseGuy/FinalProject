package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Escenario;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements KeyListener{
	
	public final String IMAGEN_FONDO = "./img/background2.png";
	
	private VentanaPrincipal v;
	
	public PanelJuego(VentanaPrincipal v) {
		this.v = v;
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		
		ImageIcon usuario = new ImageIcon(v.getJuegoModelo().getEscenario().getImagen());
		Image newImg = usuario.getImage();
		g.drawImage(newImg, 0, 0, null);
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
