package interfaz;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.JuegoModelo;

@SuppressWarnings("serial")
public class PanelMenu extends JPanel implements MouseListener{
	
	public final String IMAGEN_FONDO = "./img/background1.png";
	
	public final String[] BOTONES = { "Iniciar Juego", "Cargar Juego", "Instrucciones", "Puntajes" };
	
	public final int TAMANO_BOTON = 120;
	
	private VentanaPrincipal v;
	
	private DialogoPuntajes dp; 
	
	public PanelMenu(VentanaPrincipal v) {
		this.v =v;
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(IMAGEN_FONDO).getImage(),0,0,null);
		Font f = new Font("curier", Font.BOLD, 60);
		g.setFont(f);
		g.drawString("Zombie Pixel Wars", v.getWidth()/2 -260, 100);
		
		int y = 250;
		for(int i = 0; i < 4; i++) {
			
			
			Font font = new Font("curier" , Font.BOLD, 30);
			g.setFont(font);
			g.drawString(BOTONES[i], v.getWidth()/2 -100, y);
			y+= TAMANO_BOTON;
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		
		int posicionBoton = 230;
		
		
		if(x > v.getWidth()/2 -300 && x  < v.getWidth()/2 + 300) {
			if(y > posicionBoton && y < posicionBoton+TAMANO_BOTON-60) {
				crearPartida();
			}else if(y > posicionBoton+TAMANO_BOTON && y < posicionBoton+TAMANO_BOTON+50) {
				cargarPartida();
			}else if(y > 460 && y < 500 ) {
				instrucciones();
			}else if(y > 550 && y < 620) {
				cargarPuntajes();
			}
		}
		
	}

	private void cargarPuntajes() {
		dp = new DialogoPuntajes(v);
		
	}

	private void instrucciones() {
		
	}

	private void cargarPartida() {
		JOptionPane.showMessageDialog(null, "Aqui carga una partida");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void crearPartida() {
		String nickname = JOptionPane.showInputDialog("Digite su nickname");
		JuegoModelo jm = new JuegoModelo(nickname,0,1);
		VentanaPrincipal v = new VentanaPrincipal(jm);
		this.v.dispose();
		v.setVisible(true);
		
	}
}
