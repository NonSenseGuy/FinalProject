package hilos;

import interfaz.VentanaPrincipal;
import modelo.ArmaTiro;
import modelo.Bala;
import modelo.Boss;
import modelo.PersonajePrincipal;
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
				//CAMBIAR POR UN TRY-CATCH NULL POINTER 
				if(balaDisparada != null) {					
					
					balaDisparada.setPosX(balaDisparada.getPosX() + balaDisparada.getVelocidad());
					golpeaZombie(balaDisparada);
					
					if(balaDisparada.getPosX() < 0 || balaDisparada.getPosX() > VentanaPrincipal.ANCHO_VENTANA) {
						((ArmaTiro)arma).setBala(null);
					}				
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
	
	public void golpeaZombie(Bala balaDisparada) {
		
		Boss[] bosses = ventana.getJuegoModelo().getEscenario().getBoss();
		
		for(int i = 0; i < bosses.length; i++) {
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
