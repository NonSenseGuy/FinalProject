package hilos;

import interfaz.VentanaPrincipal;
import modelo.ArmaTiro;
import modelo.Bala;
import modelo.PersonajePrincipal;

public class HiloBalas extends Thread{
	
	private PersonajePrincipal personajeP;
	private VentanaPrincipal ventana;
	
	public HiloBalas(PersonajePrincipal p, VentanaPrincipal v) {
		personajeP = p;
		ventana = v;
	}
	
	public void run() {
		while(true) {
			if(personajeP.getArma() instanceof ArmaTiro) {
				ArmaTiro arma = (ArmaTiro) personajeP.getArma();
				for(int i = 0; i < arma.getBala().length; i++) {
					Bala balaDisparada = arma.getBala()[i];
					if(balaDisparada != null) {
						balaDisparada.setPosX(balaDisparada.getPosX() + balaDisparada.getVelocidad());
						if(balaDisparada.getPosX() < 0) {
							balaDisparada = null;
						}else if(balaDisparada.getPosX() > ventana.getWidth()) {
							balaDisparada = null;
						}
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
}
