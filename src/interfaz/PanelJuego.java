package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.ArmaTiro;
import modelo.Bala;
import modelo.Botiquin;
import modelo.Personaje;
import modelo.RayGun;
import modelo.Zombie;

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
		ImageIcon usuario = new ImageIcon(v.getJuegoModelo().getElegido().getImagen());
		Image newImg = usuario.getImage();
		g.drawImage(newImg, 0, 0, null);
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 1280, 100);
		g.setColor(Color.RED);
		g.fillRect(300, 25, 600, 50);
		g.setColor(Color.GREEN);
		if(v.getJuegoModelo().getElegido().getPersonajePrincipal().getVida() >= 0) {
			g.fillRect(300, 25, v.getJuegoModelo().getElegido().getPersonajePrincipal().getVida()*6, 50);			
		}
		
		g.setColor(Color.WHITE);
		pintarEnemigos(g);
		g.drawImage(new ImageIcon(v.getJuegoModelo().getElegido().getPersonajePrincipal().getImagen()).getImage(), v.getJuegoModelo().getEscenario().getPersonajePrincipal().getPosX(),Personaje.POS_Y, null);
		g.drawString("Score: " + v.getJuegoModelo().getScore() , 15, 20);
		g.drawString("Nivel: " + v.getJuegoModelo().getNivel(), 15, 50);
		g.drawString(v.getJuegoModelo().getNickname(), 15, 80);
		
		if(v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida() != null){
			g.drawString("Arma: " + v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida().getNombre(),1150 , 20);
		}
		pintarBalas(g);
		
		if(v.getJuegoModelo().getElegido().getBotiquin() != null) {
			Botiquin b = v.getJuegoModelo().getElegido().getBotiquin();
			g.drawImage(new ImageIcon(b.getImg()).getImage(), b.getPosX(), b.getPosY(), null);
		}
		
		pintarArma(g);
	}
	
	public void pintarBalas(Graphics g) {
		if(v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida() instanceof ArmaTiro) {
			if(((ArmaTiro) v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida()).getBala() != null) {
				Bala bala = ((ArmaTiro) v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida()).getBala();
				g.drawImage(new ImageIcon(bala.getImagenBala()).getImage(), bala.getPosX(), Personaje.POS_Y +60, null);
				
			}
		}else if(v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida() instanceof RayGun) {
			
			if(((RayGun) v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida()).getBala() != null) {
				Bala bala = ((RayGun) v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida()).getBala();
				g.drawImage(new ImageIcon(bala.getImagenBala()).getImage(), bala.getPosX(), Personaje.POS_Y + 60, null);
				
			}
		}
	}
	
	public void pintarEnemigos(Graphics g) {
		for(int i = 0; i < v.getJuegoModelo().getElegido().getBoss().length; i++) {
			if(v.getJuegoModelo().getElegido().getBoss()[i] != null) {
				Image boss = new ImageIcon(v.getJuegoModelo().getElegido().getBoss()[i].getImagen()).getImage();
				g.drawImage(boss, v.getJuegoModelo().getElegido().getBoss()[i].getPosX(),Personaje.POS_Y, null);
				if(v.getJuegoModelo().getElegido().getBoss()[i].getZombie() != null) {
					pintarZombie(g, v.getJuegoModelo().getElegido().getBoss()[i].getZombie());
				}				
			}
		}
	}
	
	public void pintarArma(Graphics g) {
		if(v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida() != null)
			g.drawImage(new ImageIcon(v.getJuegoModelo().getElegido().getPersonajePrincipal().getArmaElegida().getImagenArma()).getImage(), 1000, -10, null);
		
	}
	
	public void pintarZombie(Graphics g, Zombie zombie) {
		Image imagenZombie = new ImageIcon(zombie.getImagen()).getImage();
		g.drawImage(imagenZombie, zombie.getPosX(), Personaje.POS_Y, null);
		
		if(zombie.getZombieIzq() != null) {
			pintarZombie(g, zombie.getZombieIzq());
		}
		
		if(zombie.getZombieDer() != null) {
			pintarZombie(g, zombie.getZombieDer());
		}
	}
	
	
	

	
	public void keyPressed(KeyEvent arg0) {		
		if(arg0.getKeyCode() == KeyEvent.VK_A || arg0.getKeyCode() == KeyEvent.VK_D) {
			v.moverPersonajePrincipal(arg0.getKeyCode());
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			v.dispararPersonajePrincipal(arg0.getKeyCode());
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_Q || arg0.getKeyCode() == KeyEvent.VK_E) {
			v.cambiarArmaPersonajePrincipal(arg0.getKeyCode());
		}
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_A || arg0.getKeyCode() == KeyEvent.VK_D) {
				v.getJuegoModelo().getEscenario().getPersonajePrincipal().setVelocidad(0);
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				v.dispararPersonajePrincipal(0);
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_Q || arg0.getKeyCode() == KeyEvent.VK_E) {
			v.cambiarArmaPersonajePrincipal(0);
		}
		
	}

}
