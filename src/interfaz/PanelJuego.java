package interfaz;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.ArmaTiro;
import modelo.Bala;
import modelo.Personaje;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel{
	
	private VentanaPrincipal v;
	
	
	public PanelJuego(VentanaPrincipal v) {
		this.v = v;
		setFocusable(true);
		addKeyListener(new KeyInput(this));
		
	}
	
	public void paintComponent(Graphics g) {
		
		Font font = new Font("curier", Font.CENTER_BASELINE, 20);
		g.setFont(font);
		ImageIcon usuario = new ImageIcon(v.getJuegoModelo().getEscenario().getImagen());
		Image newImg = usuario.getImage();
		g.drawImage(newImg, 0, 0, null);
		g.drawImage(new ImageIcon(v.getJuegoModelo().getEscenario().getPersonajePrincipal().getImagen()).getImage(), v.getJuegoModelo().getEscenario().getPersonajePrincipal().getPosX(),Personaje.POS_Y, null);
		g.drawString("Score: " + v.getJuegoModelo().getScore() , 15, 20);
		g.drawString("Nivel: " + v.getJuegoModelo().getNivel(), 15, 50);
		if(v.getJuegoModelo().getEscenario().getPersonajePrincipal().getArma() != null){
			g.drawString("Arma: " + v.getJuegoModelo().getEscenario().getPersonajePrincipal().getArma().getNombre(),1150 , 20);
		}
		pintarBalas(g);
	
		
	}
	
	public void pintarBalas(Graphics g) {
		for(int i = 0; i < 3; i ++) {
			if(((ArmaTiro) v.getJuegoModelo().getEscenario().getPersonajePrincipal().getArma()).getBala()[i] != null) {
				Bala bala = ((ArmaTiro) v.getJuegoModelo().getEscenario().getPersonajePrincipal().getArma()).getBala()[i];
				g.drawImage(new ImageIcon(bala.getImagenBala()).getImage(), bala.getPosX(), Personaje.POS_Y +60, null);
			}
		}
		
	}

	
	public void keyPressed(KeyEvent arg0) {		
		if(arg0.getKeyCode() == KeyEvent.VK_A || arg0.getKeyCode() == KeyEvent.VK_D) {
			v.moverPersonajePrincipal(arg0.getKeyCode());
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			v.dispararPersonajePrincipal(arg0.getKeyCode());
		}
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_A || arg0.getKeyCode() == KeyEvent.VK_D) {
				v.getJuegoModelo().getEscenario().getPersonajePrincipal().setVelocidad(0);
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			v.dispararPersonajePrincipal(0);
		}
		
	}

}
