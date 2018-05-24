package hilos;
import modelo.*;
import interfaz.VentanaPrincipal;

public class HiloPersonaje extends Thread{
	
	private PersonajePrincipal p;
	private VentanaPrincipal v;
	private boolean mover;
	
	
	public HiloPersonaje(PersonajePrincipal p, VentanaPrincipal v) {
		this.p = p;
		this.v = v;
		this.mover = p.isEnMovimiento();
		
	}
	
	public void run() {
		
		while(true) {
			p.setPosX(p.getPosX() + p.getVelocidad());
			if(p.getPosX() <= 0) {
				p.setPosX(0);
			}else if(p.getPosX() >= v.getWidth()-60) {
				p.setPosX(v.getWidth()-60);
			}
			
			try {
				Thread.sleep(5);
			}catch(Exception e) {
				e.printStackTrace();
			}
			v.repaint();
		}
		
	}
	
}
