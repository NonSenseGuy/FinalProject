package hilos;

import interfaz.VentanaPrincipal;
import modelo.ArmaTiro;
import modelo.Bala;
import modelo.Boss;
import modelo.PersonajePrincipal;
import modelo.RayGun;
import modelo.Rocket;
import modelo.Zombie;

public class HiloBalas extends Thread{
	
	private PersonajePrincipal personajeP;
	private VentanaPrincipal ventana;
	
	public HiloBalas(PersonajePrincipal p, VentanaPrincipal v) {
		personajeP = p;
		ventana = v;
	}
	
	public void run() {
		while(true) {
			
			if(personajeP.getArmaElegida() instanceof ArmaTiro) {
				
				ArmaTiro arma = (ArmaTiro) personajeP.getArmaElegida();
				Bala balaDisparada = arma.getBala();
				
				if(balaDisparada != null) {
					
					balaDisparada.setPosX(balaDisparada.getPosX() + balaDisparada.getVelocidad());
					golpeaZombieArmaTiro(balaDisparada);
					
					if(balaDisparada.getPosX() < 0 || balaDisparada.getPosX() > VentanaPrincipal.ANCHO_VENTANA) {
						((ArmaTiro)arma).setBala(null);
					}
					
				}
					
				
			}else if (personajeP.getArmaElegida() instanceof RayGun) {
				RayGun rayGun = (RayGun) personajeP.getArmaElegida();
				Bala balaRayGun = rayGun.getBala();
				
				try {
					balaRayGun.setPosX(balaRayGun.getPosX() + balaRayGun.getVelocidad());
					golpeaZombieRayGun(balaRayGun);
					
					if(balaRayGun.getPosX() < 0 || balaRayGun.getPosX() > VentanaPrincipal.ANCHO_VENTANA) {
						((RayGun)rayGun).setBala(null);
					}
				}catch(NullPointerException e) {
					
				}
			}else if(personajeP.getArmaElegida() instanceof Rocket) {
				
			}
			
			try {
				Thread.sleep(2);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			ventana.repaint();
		}
	}
	
	public void golpeaZombieArmaTiro(Bala balaDisparada) {
		
		Boss[] bosses = ventana.getJuegoModelo().getElegido().getBoss();
		
		for(int i = 0; i < bosses.length; i++) {
			
			if(bosses[i] != null) {
				Zombie primero = bosses[i].getZombie();
				
				try {
					boolean hizoDamageBoss = bosses[i].quitarVidaBoss(balaDisparada.getPosX(), balaDisparada.getDamage());
					boolean hizoDamage = primero.quitarVidaZombie(balaDisparada.getPosX(), balaDisparada.getDamage());
					
					
					if(hizoDamage || hizoDamageBoss) {				
						balaDisparada.setImagen("");
						balaDisparada.setDamage(0);
					}
					
				}catch(NullPointerException e) {
					
				}				
			}
		}
	}
	
	public void golpeaZombieRayGun(Bala balaDisparada) {
		Boss[] bosses = ventana.getJuegoModelo().getElegido().getBoss();
		
		for(int i = 0; i < bosses.length; i++) {
			if(bosses[i] != null) {
				Zombie primero = bosses[i].getZombie();
				
				try {
					bosses[i].quitarVidaBoss(balaDisparada.getPosX(), balaDisparada.getDamage());
					primero.quitarVidaZombie(balaDisparada.getPosX(), balaDisparada.getDamage());
				}catch(NullPointerException e) {
					
				}
			}
		}
	
	}
	
}
