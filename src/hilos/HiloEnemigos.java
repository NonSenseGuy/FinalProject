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
		
		int i = 0;
		
		while(true) {
			try {
				Boss boss = juegoM.getEscenario().getBoss()[i];	
				boss.setPosX(boss.getPosX() + boss.getVelocidad());
				Zombie zombie = boss.getZombie();
				avanzarZombie(zombie);				
				
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
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
