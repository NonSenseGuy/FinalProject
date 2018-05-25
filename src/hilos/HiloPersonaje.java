package hilos;
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
