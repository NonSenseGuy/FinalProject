package hilos;
import javax.swing.JOptionPane;

import interfaz.VentanaPrincipal;
import modelo.PersonajePrincipal;

public class HiloPersonaje extends Thread{
	
	private PersonajePrincipal personajePrincipal;
	private VentanaPrincipal ventanaPrincipal;
	
	
	public HiloPersonaje(PersonajePrincipal p, VentanaPrincipal v) {
		this.personajePrincipal = p;
		this.ventanaPrincipal = v;		
	}
	
	public void run() {
		
		while(true) {
			
			if(personajePrincipal.getVida() <= 0) {
				JOptionPane.showMessageDialog(null, "Perdiste, tu score ha sido guardado puedes verlo en puntajes");
				ventanaPrincipal = new VentanaPrincipal();
			}
			personajePrincipal.setPosX(personajePrincipal.getPosX() + personajePrincipal.getVelocidad());
			
			if(personajePrincipal.getPosX() <= 0) {
				personajePrincipal.setPosX(0);
			}else if(personajePrincipal.getPosX() >= VentanaPrincipal.ANCHO_VENTANA - personajePrincipal.ANCHO_IMAGEN) {
				personajePrincipal.setPosX(ventanaPrincipal.getWidth()-personajePrincipal.ANCHO_IMAGEN);
			}
			
			try {
				Thread.sleep(5);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			ventanaPrincipal.repaint();
		}
		
	}
	
}
