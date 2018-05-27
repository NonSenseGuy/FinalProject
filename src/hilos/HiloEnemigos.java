package hilos;
import javax.swing.JOptionPane;

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
				for(int i = 0; i < juegoM.getElegido().getBoss().length; i++) {
					
					Boss boss = juegoM.getElegido().getBoss()[i];	
					boss.setPosX(boss.getPosX() + boss.getVelocidad());
					if(juegoM.getElegido().intersecta(boss)) {
						tick(boss.getDamage());
					}
					Zombie zombie = boss.getZombie();
					
					avanzarZombie(zombie);			
				}
				
				try {
					Thread.sleep(50);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}catch(NullPointerException e) {
			
				
			}
			ventana.repaint();
		}	
	}
	
	public void avanzarZombie(Zombie zombie) {
		
		zombie.setPosX(zombie.getPosX() + zombie.getVelocidad());
		if(juegoM.getElegido().intersecta(zombie)) {
			tick(zombie.getDamage());
		}
		if(zombie.getZombieIzq() != null) {
			avanzarZombie(zombie.getZombieIzq());
		}
		
		if(zombie.getZombieDer() != null) {
			avanzarZombie(zombie.getZombieDer());
		}
	}
	
	public void tick(int dano) {
		PersonajePrincipal p = juegoM.getElegido().getPersonajePrincipal();
		p.setVida(p.getVida() - dano);
		
	}
}
