package hilos;

import interfaz.VentanaPrincipal;
import modelo.ArmaTiro;
import modelo.Bala;
import modelo.Boss;
import modelo.PersonajePrincipal;
import modelo.RayGun;
import modelo.Rocket;
import modelo.Zombie;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * Clase que controla el movimiento de las balas de acuerdo al tipo de arma
 */
public class HiloBalas extends Thread{
	
	private PersonajePrincipal personajeP;
	private VentanaPrincipal ventana;
	/**
	 * Cosntructor que permite intstanciar el hilo para que se puedan mover las balas
	 * @param p: Personaje principal actual
	 * @param v: ventana Principal del juego actual donde se ejecuta el juego
	 */
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
				Rocket rocket = (Rocket) personajeP.getArmaElegida();
				Bala balaRocket = rocket.getBala();
				
				try {
					balaRocket.setPosX(balaRocket.getPosX() + balaRocket.getVelocidad());
					golpeaZombieRocket(balaRocket, rocket.getRadioExplocion());
					
					if(balaRocket.getPosX() < 0 || balaRocket.getPosX() > VentanaPrincipal.ANCHO_VENTANA) {
						((Rocket)rocket).setBala(null);
					}
				}catch(NullPointerException e) {
					
				}
			}
			
			try {
				Thread.sleep(2);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			ventana.repaint();
		}
	}
	/**
	 * Permite que cuando un zombie o boss sea tocado por una bala, este reciba daño y si su vida es menor a cero entonces desaparezca de la interfaz
	 * grafica. Tambien hace que la bala desaparezca cuando toca a un enemigo
	 * @param balaDisparada: Bala que fue disparada de un arma tipo ArmaTiro
	 */
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
	/**
	 * Permite que cuando un zombie o boss sea tocado por una bala, este reciba daño y si su vida es menor a cero entonces desaparezca de la interfaz
	 * grafica. En este caso la bala no desaparece sino que sigue haciendo daño a los zombies que intersecte hasta que se acabe la ventana
	 * @param balaDisparada: Bala que fue disparada de un arma tipo RayGun
	 */
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
	/**
	 * Permite que cuando un zombie o boss sea tocado por una bala, este reciba daño y si su vida es menor a cero entonces desaparezca de la interfaz
	 * grafica. En este caso la bala desaparece cuando toca un enemigo, pero de acuerdo al radio de explosion del arma daña a los enemigos con  que estan 
	 * en ese radio.
	 * @param balaDisparada: Bala que fue disparada de un arma tipo Rocket
	 */
	public void golpeaZombieRocket(Bala balaDisparada, int radioExplosion) {
		Boss[] bosses = ventana.getJuegoModelo().getElegido().getBoss();
		
		for(int i = 0; i < bosses.length; i++) {
			
			if(bosses[i] != null) {
				Zombie primero = bosses[i].getZombie();
				
				try {
					boolean hizoDamageBoss = bosses[i].quitarVidaBoss(balaDisparada.getPosX(), balaDisparada.getDamage());
					boolean hizoDamage = primero.quitarVidaZombie(balaDisparada.getPosX(), balaDisparada.getDamage());
										
					if(hizoDamage || hizoDamageBoss) {
						
						balaDisparada.setImagen("");
						
						for(int j = 0; j < radioExplosion; j++) {
							
							j += 20;
							int radio = j;
							int posicionActualBala = balaDisparada.getPosX();
							balaDisparada.setPosX(balaDisparada.getPosX() + radio);							
							bosses[i].quitarVidaBoss(balaDisparada.getPosX(), balaDisparada.getDamage());
							primero.quitarVidaZombie(balaDisparada.getPosX(), balaDisparada.getDamage());
							
							balaDisparada.setPosX(posicionActualBala);
							balaDisparada.setPosX(balaDisparada.getPosX() - radio);							
							bosses[i].quitarVidaBoss(balaDisparada.getPosX(), balaDisparada.getDamage());
							primero.quitarVidaZombie(balaDisparada.getPosX(), balaDisparada.getDamage());
							
							balaDisparada.setPosX(posicionActualBala);
						}
						

						balaDisparada.setDamage(0);
					}
					
				}catch(NullPointerException e) {
					
				}				
			}
		}
	}
	
}
