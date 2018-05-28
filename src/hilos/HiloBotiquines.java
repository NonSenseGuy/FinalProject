package hilos;

import interfaz.VentanaPrincipal;
import modelo.Botiquin;
import modelo.JuegoModelo;
import modelo.PersonajePrincipal;

public class HiloBotiquines extends Thread{
	
	private VentanaPrincipal ventanaPrincipal;
	private JuegoModelo juegoM;
	
	public HiloBotiquines(VentanaPrincipal v, JuegoModelo jm) {
		ventanaPrincipal = v;
		juegoM = jm;
	}
	
	public void run() {
		while(true) {
			Botiquin b = new Botiquin(600, PersonajePrincipal.POS_Y + 50);
			juegoM.getElegido().setBotiquin(b);
			/*if(juegoM.getElegido().getPersonajePrincipal().getHitBox().contains(b.getPosX(), b.getPosY())) {
				juegoM.getElegido().getPersonajePrincipal().setVida(juegoM.getElegido().getPersonajePrincipal().getVida() + b.getVida());
				juegoM.getElegido().setBotiquin(null);
			}*/
			
			try {
				Thread.sleep(6000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			ventanaPrincipal.repaint();
		}
	}
}
