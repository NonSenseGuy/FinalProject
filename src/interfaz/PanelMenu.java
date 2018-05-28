package interfaz;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.PartidaNoGuardadaException;
import modelo.JuegoModelo;

@SuppressWarnings("serial")
public class PanelMenu extends JPanel implements MouseListener{
	
	public final String IMAGEN_FONDO = "./img/background1.png";
	
	public final String[] BOTONES = { "Iniciar Juego", "Cargar Juego", "Puntajes" };
	
	public final int TAMANO_BOTON = 120;
	
	private VentanaPrincipal v;
	
	@SuppressWarnings("unused")
	private DialogoPuntajes dp; 
	
	public PanelMenu(VentanaPrincipal v) {
		this.v =v;
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(IMAGEN_FONDO).getImage(),0,0,null);
		Font f = new Font("curier", Font.BOLD, 60);
		g.setFont(f);
		g.drawString("Dead Pixels", v.getWidth()/2 - 175, 100);
		
		int y = 250;
		for(int i = 0; i < 3; i++) {			
			Font font = new Font("curier" , Font.BOLD, 30);
			g.setFont(font);
			g.drawString(BOTONES[i], VentanaPrincipal.ANCHO_VENTANA/2 -100, y);
			y+= TAMANO_BOTON;
		}	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		
		int posicionBoton = 230;
		
		
		if(x > VentanaPrincipal.ANCHO_VENTANA/2 -300 && x  < VentanaPrincipal.ANCHO_VENTANA/2 + 300) {
			if(y > posicionBoton && y < posicionBoton + TAMANO_BOTON - 60) {
				crearPartida();
			}else if(y > posicionBoton+TAMANO_BOTON && y < posicionBoton+TAMANO_BOTON+50) {
				try {
					cargarPartida();
				}catch(PartidaNoGuardadaException e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}else if(y > 460 && y < 500 ) {
				cargarPuntajes();
			}
		}
		
	}

	private void cargarPuntajes() {
		dp = new DialogoPuntajes(v);
		
	}

	private void cargarPartida()throws PartidaNoGuardadaException {
		if(JuegoModelo.cargarPartida() != null) {
			VentanaPrincipal v = new VentanaPrincipal(JuegoModelo.cargarPartida());
			this.v.dispose();
			v.setVisible(true);
		}else {
			PartidaNoGuardadaException e = new PartidaNoGuardadaException();
			throw e;
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	public void crearPartida() {
		String nickname = JOptionPane.showInputDialog("Digite su nickname");
		if(nickname == null || nickname.equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un nickname valido");
		}else {
			JuegoModelo jm = new JuegoModelo(nickname,0,1);
			VentanaPrincipal v = new VentanaPrincipal(jm);
			this.v.dispose();
			v.setVisible(true);
		}
		
		
	}
}
