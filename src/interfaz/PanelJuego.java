package interfaz;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Escenario;
import modelo.Personaje;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements KeyListener{
	
	private VentanaPrincipal v;
	private boolean parar;
	
	public PanelJuego(VentanaPrincipal v) {
		this.v = v;
		setFocusable(true);
		addKeyListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		addKeyListener(this);
		Font font = new Font("curier", Font.CENTER_BASELINE, 20);
		g.setFont(font);
		ImageIcon usuario = new ImageIcon(v.getJuegoModelo().getEscenario().getImagen());
		Image newImg = usuario.getImage();
		g.drawImage(newImg, 0, 0, null);
		g.drawImage(new ImageIcon(v.getJuegoModelo().getEscenario().getPersonajePrincipal().getImagen()).getImage(), v.getJuegoModelo().getEscenario().getPersonajePrincipal().getPosX(),Personaje.POS_Y, null);
		parar = false;
		g.drawString("Score: " + v.getJuegoModelo().getScore() , 15, 20);
		g.drawString("Nivel: " + v.getJuegoModelo().getNivel(), 15, 50);
		if(v.getJuegoModelo().getEscenario().getPersonajePrincipal().getArma() != null){
			g.drawString("Arma: " + v.getJuegoModelo().getEscenario().getPersonajePrincipal().getArma().getNombre(),1150 , 20);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//JOptionPane.showMessageDialog(null, KeyEvent.VK_A+"");
		
		if(!parar) {
			if(arg0.getKeyCode() == KeyEvent.VK_A || arg0.getKeyCode() == KeyEvent.VK_D) {
				v.moverPersonajePrincipal(arg0.getKeyCode());
			}else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				v.dispararPersonajePrincipal(arg0.getKeyCode());
			}
			
			parar = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//v.moverPersonajePrincipal(arg0.getKeyCode());
	}
}
