package hilos;
import interfaz.VentanaPrincipal;
import modelo.Boss;
import modelo.JuegoModelo;
import modelo.PersonajePrincipal;
import modelo.Zombie;

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
					
					if(boss.localizarZombieMuerto() != null) {
						Zombie muerto = boss.localizarZombieMuerto();
						juegoM.setScore(juegoM.getScore() + muerto.getScore());
						boss.eliminarZombie(muerto.getPosX());
					}
					
					try {
						Zombie zombie = boss.getZombie();
						avanzarZombie(zombie);
					}catch (NullPointerException e) {
						
					}
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
