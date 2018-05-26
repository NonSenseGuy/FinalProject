package hilos;
import interfaz.VentanaPrincipal;
import modelo.*;

public class HiloEnemigos extends Thread {
	
	private JuegoModelo juegoM;
	private VentanaPrincipal ventana;
	
	public HiloEnemigos(JuegoModelo jm, VentanaPrincipal ventana) {
		juegoM = jm;
		this.ventana = ventana;
	}
	
	public void run() {
		
		while(true) {
			try {
				for(int i = 0; i < juegoM.getEscenario().getBoss().length; i++) {
					
					Boss boss = juegoM.getEscenario().getBoss()[i];	
					boss.setPosX(boss.getPosX() + boss.getVelocidad());
					Zombie zombie = boss.getZombie();
					avanzarZombie(zombie);					
				}
				
			}catch(NullPointerException e) {
			
				
			}
			ventana.repaint();
		}	
	}
	
	public void avanzarZombie(Zombie zombie) {
		
		zombie.setPosX(zombie.getPosX() + zombie.getVelocidad());
		
		if(zombie.getZombieIzq() != null) {
			avanzarZombie(zombie.getZombieIzq());
		}
		
		if(zombie.getZombieDer() != null) {
			avanzarZombie(zombie.getZombieDer());
		}
	}
}
