package hilos;
import javax.swing.JOptionPane;

import interfaz.VentanaPrincipal;
import modelo.Botiquin;
import modelo.PersonajePrincipal;

public class HiloPersonaje extends Thread{
	
	private PersonajePrincipal personajePrincipal;
	private VentanaPrincipal ventanaPrincipal;
	
	
	public HiloPersonaje(PersonajePrincipal p, VentanaPrincipal v) {
		this.personajePrincipal = p;
		this.ventanaPrincipal = v;		
	}
	
	public void run() {
		boolean vivo = true;
		while(vivo) {
			
			if(personajePrincipal.getVida() <= 0) {
				personajePrincipal.setVida(1);
				vivo = false;
				JOptionPane.showMessageDialog(null, "Perdiste, Tu puntaje ha sido guardado puedes verlo en la tabla de puntajes en el menu");
				ventanaPrincipal.guardarPuntaje();
				ventanaPrincipal.reset();
			}
			personajePrincipal.setPosX(personajePrincipal.getPosX() + personajePrincipal.getVelocidad());
			
			if(personajePrincipal.getPosX() <= 0) {
				personajePrincipal.setPosX(0);
			}else if(personajePrincipal.getPosX() >= VentanaPrincipal.ANCHO_VENTANA - personajePrincipal.ANCHO_IMAGEN) {
				personajePrincipal.setPosX(ventanaPrincipal.getWidth()-personajePrincipal.ANCHO_IMAGEN);
			}
			if(ventanaPrincipal.getJuegoModelo().getElegido().getBotiquin() != null ) {
				Botiquin b = ventanaPrincipal.getJuegoModelo().getElegido().getBotiquin();
				if(personajePrincipal.getHitBox().contains(b.getPosX(), b.getPosY()) && personajePrincipal.getVida() < 80) {
					personajePrincipal.setVida(personajePrincipal.getVida() + b.getVida());
					ventanaPrincipal.getJuegoModelo().getElegido().setBotiquin(null);
				}
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
